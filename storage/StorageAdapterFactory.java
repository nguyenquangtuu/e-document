package storage;

/**
 * StorageAdapterFactory:
 * Factory khoi tao cac Adapter luu tru tuong ung theo cau hinh he thong.
 */
public class StorageAdapterFactory {

    public static DocumentStorageTarget getStorageAdapter(String type) {
        if (type == null) {
            return new JsonFileStorageAdapter();
        }
        String lower = type.trim().toLowerCase();
        switch (lower) {
            case "mysql":
            case "db":
            case "database":
                return new MySqlStorageAdapter();
            case "s3":
            case "aws":
            case "cloud":
                return new AwsS3StorageAdapter();
            case "json":
            case "file":
            default:
                return new JsonFileStorageAdapter();
        }
    }

    public static DocumentStorageTarget getDefaultAdapter() {
        return new JsonFileStorageAdapter();
    }
}
