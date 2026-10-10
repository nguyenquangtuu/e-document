package command;

import model.Document;

/**
 * Command Interface trong Command Pattern (Chuong 7 - Course Syllabus 504077):
 * Dong goi mot yeu cau thao tac tren ho so duoi dang mot doi tuong.
 * Ho tro cac chuc nang kinh dien trong de cuong: Thuc thi (Execute), Hoan tac (Undo) va Ghi log (Logging).
 */
public interface DocumentCommand {
    void execute() throws Exception;
    void undo() throws Exception;
    String getDescription();
    Document getDocument();
}
