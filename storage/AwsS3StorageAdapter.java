package storage;

import model.Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Adapter 3 trong Adapter Pattern (Chuong 8 - Course Syllabus 504077):
 * Chuyen doi (Adapt) giao tiep Cloud Object Storage (AWS S3 Bucket)
 * sang giao tiep chuan DocumentStorageTarget cua he thong.
 */
public class AwsS3StorageAdapter implements DocumentStorageTarget {
    private final String bucketName;
    // Mo phong AWS S3 Bucket Object Key-Value Storage
    private final Map<String, Document> s3BucketStorage = Collections.synchronizedMap(new LinkedHashMap<>());

    public AwsS3StorageAdapter() {
        this("edocument-cloud-bucket-prod");
    }

    public AwsS3StorageAdapter(String bucketName) {
        this.bucketName = bucketName;
    }

    @Override
    public String getStorageName() {
        return "AWS S3 Cloud Storage (Bucket: " + bucketName + ")";
    }

    @Override
    public void save(Document doc) throws Exception {
        if (doc == null || doc.getId() == null) return;
        // Mo phong lenh s3Client.putObject(bucketName, key, documentPayload)
        s3BucketStorage.put(doc.getId(), new Document(doc));
        System.out.println("[AwsS3StorageAdapter] S3::putObject(bucket='" + bucketName + "', key='" + doc.getId() + "') -> 200 OK.");
    }

    @Override
    public Document findById(String id) throws Exception {
        if (id == null) return null;
        Document d = s3BucketStorage.get(id);
        return (d != null) ? new Document(d) : null;
    }

    @Override
    public List<Document> findAll() throws Exception {
        List<Document> list = new ArrayList<>();
        for (Document d : s3BucketStorage.values()) {
            list.add(new Document(d));
        }
        return list;
    }

    @Override
    public void delete(String id) throws Exception {
        if (id != null) {
            s3BucketStorage.remove(id);
            System.out.println("[AwsS3StorageAdapter] S3::deleteObject(bucket='" + bucketName + "', key='" + id + "') -> Success.");
        }
    }

    @Override
    public boolean exists(String id) throws Exception {
        return id != null && s3BucketStorage.containsKey(id);
    }

    @Override
    public int count() throws Exception {
        return s3BucketStorage.size();
    }
}
