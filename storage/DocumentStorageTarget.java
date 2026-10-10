package storage;

import model.Document;
import java.util.List;

/**
 * Target Interface trong Adapter Pattern (Chuong 8 - Course Syllabus 504077):
 * Dinh nghia giao dien tieu chuan thong nhat ma Client (DocumentProcessor) su dung.
 * Cho phep he thong tich hop de dang voi cac he thong luu tru khac nhau (File JSON, Database, Cloud S3)
 * ma khong lam thay doi ma nguon nghiep vu.
 */
public interface DocumentStorageTarget {
    void save(Document doc) throws Exception;
    Document findById(String id) throws Exception;
    List<Document> findAll() throws Exception;
    void delete(String id) throws Exception;
    boolean exists(String id) throws Exception;
    String getStorageName();
}
