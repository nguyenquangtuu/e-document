package repository;

import model.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Gia lap luu tru ho so len Cloud AWS S3
public class S3Repository implements DocumentRepository {
    private final Map<String, Document> s3 = new HashMap<>();

    @Override
    public void save(Document doc) {
        if (doc == null || doc.getId() == null) return;
        System.out.println("Upload ho so len AWS S3: s3://bucket/docs/" + doc.getId() + ".json");
        s3.put(doc.getId(), doc);
    }

    @Override
    public Document findById(String id) {
        return (id != null) ? dbGet(id) : null;
    }

    private Document dbGet(String id) {
        return s3.get(id);
    }

    @Override
    public List<Document> findAll() {
        return new ArrayList<>(s3.values());
    }

    @Override
    public void delete(String id) {
        if (id != null) s3.remove(id);
    }

    @Override
    public boolean exists(String id) {
        return id != null && s3.containsKey(id);
    }
}
