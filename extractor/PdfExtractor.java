package extractor;

import java.io.IOException;

// Gia lap OCR doc file PDF
public class PdfExtractor implements ContentExtractor {

    @Override
    public boolean supports(String fileExtension) {
        return fileExtension != null && fileExtension.equalsIgnoreCase("pdf");
    }

    @Override
    public String extract(String filePath) throws IOException {
        System.out.println("Gia lap OCR doc file PDF: " + filePath);
        return "Noi dung trich xuat tu PDF qua OCR";
    }
}
