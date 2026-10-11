package extractor;

import java.io.IOException;

public interface ContentExtractor {
    String extract(String filePath) throws IOException;
    boolean supports(String fileExtension);
}

