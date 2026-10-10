package test;

import extractor.ContentExtractor;
import extractor.ExtractorFactory;
import extractor.TxtExtractor;
import extractor.PdfExtractor;
import extractor.ImageOcrExtractor;

public class StrategyExtractorTest {
    public static void main(String[] args) {
        System.out.println("Running StrategyExtractorTest...");

        // 1. Test Factory returns correct Strategy
        ContentExtractor txt = ExtractorFactory.getExtractor("txt");
        assert txt instanceof TxtExtractor : "Must return TxtExtractor for txt extension";

        ContentExtractor pdf = ExtractorFactory.getExtractor("pdf");
        assert pdf instanceof PdfExtractor : "Must return PdfExtractor for pdf extension";

        ContentExtractor jpg = ExtractorFactory.getExtractor("jpg");
        assert jpg instanceof ImageOcrExtractor : "Must return ImageOcrExtractor for jpg extension";

        // 2. Test dynamic custom extractor registration
        ExtractorFactory.registerExtractor(new ContentExtractor() {
            @Override
            public String extract(String filePath) { return "CUSTOM_EXTRACTED"; }
            @Override
            public boolean supports(String ext) { return "custom".equalsIgnoreCase(ext); }
        });

        ContentExtractor custom = ExtractorFactory.getExtractor("custom");
        assert custom != null : "Custom extractor must be registered and returned";

        System.out.println("StrategyExtractorTest PASSED.");
    }
}
