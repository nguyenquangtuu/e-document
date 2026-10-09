package repository;

import model.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Gia lap luu tru ho so vao MySQL Database
public class MySqlRepository implements DocumentRepository {
    private final Map<String, Document> db = new HashMap<>();

    @Override
    public void save(Document doc) {
        if (doc == null || doc.getId() == null) return;
        System.out.println("Ghi vao CSDL MySQL: ho so " + doc.getId() + " - " + doc.getApplicantName());
        db.put(doc.getId(), doc);
    }

    @Override
    public Document findById(String id) {
        return (id != null) ? db.get(id) : null;
    }

    @Override
    public List<Document> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public void delete(String id) {
        if (id != null) db.remove(id);
    }

    @Override
    public boolean exists(String id) {
        return id != null && db.containsKey(id);
    }
}
