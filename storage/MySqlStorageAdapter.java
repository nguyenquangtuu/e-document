package storage;

import model.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Adapter 2 trong Adapter Pattern (Chuong 8 - Course Syllabus 504077):
 * Chuyen doi (Adapt) giao tiep he quan tri co so du lieu quan he (RDBMS MySQL)
 * sang giao tiep chuan DocumentStorageTarget cua he thong.
 */
public class MySqlStorageAdapter implements DocumentStorageTarget {
    // Mo phong Database Table luu tru du lieu quan he trong RAM
    private final Map<String, Document> simulatedDbTable = Collections.synchronizedMap(new LinkedHashMap<>());

    @Override
    public String getStorageName() {
        return "MySQL Database Storage";
    }

    @Override
    public void save(Document doc) throws Exception {
        if (doc == null || doc.getId() == null) return;
        // Mo phong thuc thi cau lenh SQL INSERT / UPDATE INTO documents ...
        simulatedDbTable.put(doc.getId(), new Document(doc));
        System.out.println("[MySqlStorageAdapter] SQL: INSERT INTO documents VALUES ('" + doc.getId() + "', '" + doc.getApplicantName() + "') -> SUCCESS.");
    }

    @Override
    public Document findById(String id) throws Exception {
        if (id == null) return null;
        Document d = simulatedDbTable.get(id);
        return (d != null) ? new Document(d) : null;
    }

    @Override
    public List<Document> findAll() throws Exception {
        List<Document> list = new ArrayList<>();
        for (Document d : simulatedDbTable.values()) {
            list.add(new Document(d));
        }
        return list;
    }

    @Override
    public void delete(String id) throws Exception {
        if (id != null) {
            simulatedDbTable.remove(id);
            System.out.println("[MySqlStorageAdapter] SQL: DELETE FROM documents WHERE id = '" + id + "' -> 1 row affected.");
        }
    }

    @Override
    public boolean exists(String id) throws Exception {
        return id != null && simulatedDbTable.containsKey(id);
    }

    @Override
    public int count() throws Exception {
        return simulatedDbTable.size();
    }
}
