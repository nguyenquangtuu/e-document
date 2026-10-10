import re
import os
from docx import Document
from docx.shared import Inches, Pt, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.oxml import parse_xml, OxmlElement
from docx.oxml.ns import nsdecls, qn

def set_cell_background(cell, fill_hex):
    shading_elm = parse_xml(f'<w:shd {nsdecls("w")} w:fill="{fill_hex}"/>')
    cell._tc.get_or_add_tcPr().append(shading_elm)

def set_cell_margins(cell, top=100, bottom=100, left=150, right=150):
    tcPr = cell._tc.get_or_add_tcPr()
    tcMar = parse_xml(f'<w:tcMar {nsdecls("w")}><w:top w:w="{top}" w:type="dxa"/><w:bottom w:w="{bottom}" w:type="dxa"/><w:left w:w="{left}" w:type="dxa"/><w:right w:w="{right}" w:type="dxa"/></w:tcMar>')
    tcPr.append(tcMar)

def set_table_borders(table, color="D3D3D3"):
    tblPr = table._tbl.tblPr
    borders = parse_xml(
        f'<w:tblBorders {nsdecls("w")}>'
        f'<w:top w:val="single" w:sz="4" w:space="0" w:color="{color}"/>'
        f'<w:bottom w:val="single" w:sz="4" w:space="0" w:color="{color}"/>'
        f'<w:left w:val="none"/>'
        f'<w:right w:val="none"/>'
        f'<w:insideH w:val="single" w:sz="4" w:space="0" w:color="{color}"/>'
        f'<w:insideV w:val="none"/>'
        f'</w:tblBorders>'
    )
    tblPr.append(borders)

def build_word_report(md_path, docx_path):
    with open(md_path, 'r', encoding='utf-8') as f:
        lines = f.readlines()

    doc = Document()

    # Set page margins to standard 1 inch
    for section in doc.sections:
        section.top_margin = Inches(1.0)
        section.bottom_margin = Inches(1.0)
        section.left_margin = Inches(1.0)
        section.right_margin = Inches(1.0)

    # Base Normal Style
    style = doc.styles['Normal']
    font = style.font
    font.name = 'Times New Roman'
    font.size = Pt(13)
    font.color.rgb = RGBColor(0x22, 0x22, 0x22)
    style.paragraph_format.line_spacing = 1.25
    style.paragraph_format.space_after = Pt(4)

    i = 0
    in_code_block = False
    code_lines = []
    
    in_table = False
    table_rows = []

    def flush_table():
        nonlocal in_table, table_rows
        if not table_rows:
            in_table = False
            return
        
        # Determine cols
        num_cols = max(len(r) for r in table_rows)
        table = doc.add_table(rows=len(table_rows), cols=num_cols)
        table.autofit = True
        set_table_borders(table)

        for r_idx, row_data in enumerate(table_rows):
            is_header = (r_idx == 0)
            for c_idx in range(num_cols):
                cell = table.cell(r_idx, c_idx)
                text = row_data[c_idx] if c_idx < len(row_data) else ""
                cell.text = text.strip()
                set_cell_margins(cell)
                
                # Format cell text
                for p in cell.paragraphs:
                    p.paragraph_format.space_after = Pt(2)
                    p.paragraph_format.line_spacing = 1.15
                    for run in p.runs:
                        run.font.name = 'Times New Roman'
                        run.font.size = Pt(11)
                        if is_header:
                            run.font.bold = True
                            run.font.color.rgb = RGBColor(0x00, 0x33, 0x66)

                if is_header:
                    set_cell_background(cell, "EAEFF5")
                elif r_idx % 2 == 1:
                    set_cell_background(cell, "F9FAFB")
        
        doc.add_paragraph() # Spacing
        table_rows = []
        in_table = False

    while i < len(lines):
        line = lines[i].rstrip('\r\n')

        # Code block handling
        if line.startswith("```"):
            if not in_code_block:
                in_code_block = True
                code_lines = []
            else:
                in_code_block = False
                # Add code table / box
                code_text = "\n".join(code_lines)
                tbl = doc.add_table(rows=1, cols=1)
                cell = tbl.cell(0, 0)
                set_cell_background(cell, "F4F5F7")
                set_cell_margins(cell, top=120, bottom=120, left=180, right=180)
                cell.text = code_text
                for p in cell.paragraphs:
                    p.paragraph_format.space_after = Pt(0)
                    p.paragraph_format.line_spacing = 1.15
                    for run in p.runs:
                        run.font.name = 'Consolas'
                        run.font.size = Pt(9.5)
                        run.font.color.rgb = RGBColor(0x1A, 0x2A, 0x3A)
                doc.add_paragraph()
            i += 1
            continue

        if in_code_block:
            code_lines.append(line)
            i += 1
            continue

        # Markdown Tables
        if "|" in line and not line.startswith("```"):
            stripped = line.strip()
            if stripped.startswith("|") and stripped.endswith("|"):
                parts = [p.strip() for p in stripped.split("|")[1:-1]]
                # Check if it's separator
                if all(re.match(r'^:?-+:?$', p) for p in parts if p):
                    i += 1
                    continue
                in_table = True
                table_rows.append(parts)
                i += 1
                continue
        
        if in_table:
            flush_table()

        # Headings
        if line.startswith("# "):
            h = doc.add_heading(level=1)
            h.paragraph_format.space_before = Pt(14)
            h.paragraph_format.space_after = Pt(6)
            run = h.add_run(line[2:].strip())
            run.font.name = 'Times New Roman'
            run.font.bold = True
            run.font.size = Pt(17)
            run.font.color.rgb = RGBColor(0x00, 0x33, 0x66) # Dark Navy
            i += 1
            continue
        elif line.startswith("## "):
            h = doc.add_heading(level=2)
            h.paragraph_format.space_before = Pt(12)
            h.paragraph_format.space_after = Pt(4)
            run = h.add_run(line[3:].strip())
            run.font.name = 'Times New Roman'
            run.font.bold = True
            run.font.size = Pt(15)
            run.font.color.rgb = RGBColor(0x00, 0x4C, 0x8C)
            i += 1
            continue
        elif line.startswith("### "):
            h = doc.add_heading(level=3)
            h.paragraph_format.space_before = Pt(10)
            h.paragraph_format.space_after = Pt(3)
            run = h.add_run(line[4:].strip())
            run.font.name = 'Times New Roman'
            run.font.bold = True
            run.font.size = Pt(13.5)
            run.font.color.rgb = RGBColor(0x22, 0x22, 0x22)
            i += 1
            continue

        # Horizontal Rule
        if line.strip() in ["---", "***", "___"]:
            p = doc.add_paragraph()
            p.paragraph_format.space_after = Pt(6)
            run = p.add_run("_________________________________________________________________________________")
            run.font.color.rgb = RGBColor(0xCC, 0xCC, 0xCC)
            run.font.size = Pt(8)
            i += 1
            continue

        # Regular text or bullet
        clean_line = line.strip()
        if not clean_line:
            i += 1
            continue

        p = doc.add_paragraph()
        if clean_line.startswith("* ") or clean_line.startswith("- "):
            p.paragraph_format.left_indent = Inches(0.25)
            clean_line = clean_line[2:]
        elif re.match(r'^\d+\.\s', clean_line):
            m = re.match(r'^(\d+\.\s)', clean_line)
            p.paragraph_format.left_indent = Inches(0.25)
            clean_line = clean_line[len(m.group(1)):]

        # Process bold and inline code formatting
        # Simple parser for **bold** and `code`
        tokens = re.split(r'(\*\*.*?\*\*|`.*?`)', clean_line)
        for tok in tokens:
            if tok.startswith("**") and tok.endswith("**"):
                r = p.add_run(tok[2:-2])
                r.font.bold = True
            elif tok.startswith("`") and tok.endswith("`"):
                r = p.add_run(tok[1:-1])
                r.font.name = 'Consolas'
                r.font.size = Pt(11)
                r.font.color.rgb = RGBColor(0x99, 0x00, 0x33)
            else:
                p.add_run(tok)

        i += 1

    if in_table:
        flush_table()

    doc.save(docx_path)
    print("Exported successfully to docx file.")

if __name__ == "__main__":
    script_dir = os.path.dirname(os.path.abspath(__file__))
    md_file = os.path.join(script_dir, "BAO_CAO_TIET_LUAN_GIUA_KY.md")
    docx_file = os.path.join(script_dir, "BAO_CAO_TIET_LUAN_GIUA_KY.docx")
    build_word_report(md_file, docx_file)
