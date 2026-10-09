package repository;

// Factory Pattern: tao repository theo loai luu tru (json, mysql, s3)
public class RepositoryFactory {

    public static DocumentRepository createRepository(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Loai repository khong hop le.");
        }
        String t = type.trim().toLowerCase();
        switch (t) {
            case "json":
            case "file":
                return new JsonFileRepository();
            case "mysql":
            case "db":
                return new MySqlRepository();
            case "s3":
            case "cloud":
                return new S3Repository();
            default:
                throw new IllegalArgumentException("Khong ho tro loai repository: " + type);
        }
    }

    public static DocumentRepository getDefaultRepository() {
        return createRepository("json");
    }
}
