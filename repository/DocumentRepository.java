package repository;

import model.Document;
import java.util.List;

// Repository Pattern: interface thao tac du lieu ho so
public interface DocumentRepository {
    void save(Document doc) throws Exception;
    Document findById(String id) throws Exception;
    List<Document> findAll() throws Exception;
    void delete(String id) throws Exception;
    boolean exists(String id) throws Exception;
}
