package extractor;

import java.util.ArrayList;
import java.util.List;

public class ExtractorFactory {
    private static final List<ContentExtractor> extractors = new ArrayList<>();

    static {
        extractors.add(new TxtExtractor());
        extractors.add(new PdfExtractor());
        extractors.add(new ImageOcrExtractor());
    }

    public static void registerExtractor(ContentExtractor extractor) {
        if (extractor != null && !extractors.contains(extractor)) {
            extractors.add(0, extractor);
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

