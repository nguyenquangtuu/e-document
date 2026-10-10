package extractor;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory Method Pattern (Chuong 5) ket hop Strategy Pattern (Chuong 3):
 * Chịu trách nhiệm khởi tạo và cung cấp Strategy ContentExtractor phù hợp
 * dựa trên phần mở rộng của tệp tài liệu.
 * Giúp client tách biệt hoàn toàn khỏi logic kiểm tra chuỗi định dạng (gỡ bỏ if-else cứng nhắc).
 */
public class ExtractorFactory {
    private static final List<ContentExtractor> extractors = new ArrayList<>();

    static {
        extractors.add(new TxtExtractor());
        extractors.add(new PdfExtractor());
        extractors.add(new ImageOcrExtractor());
    }

    public static void registerExtractor(ContentExtractor extractor) {
        if (extractor != null && !extractors.contains(extractor)) {
            extractors.add(0, extractor); // Uu tien extractor moi dang ky
        }
    }

    public static ContentExtractor getExtractor(String fileExtension) {
        if (fileExtension != null && !fileExtension.trim().isEmpty()) {
            for (ContentExtractor extractor : extractors) {
                if (extractor.supports(fileExtension)) {
                    return extractor;
                }
            }
        }
        throw new RuntimeException("Dinh dang file khong duoc ho tro: " + fileExtension);
    }
}
