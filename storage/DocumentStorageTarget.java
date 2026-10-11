package storage;

import model.Document;
import java.util.List;

public interface DocumentStorageTarget {
    void save(Document doc) throws Exception;
    Document findById(String id) throws Exception;
    List<Document> findAll() throws Exception;
    void delete(String id) throws Exception;
    boolean exists(String id) throws Exception;
    int count() throws Exception;
    String getStorageName();
}

