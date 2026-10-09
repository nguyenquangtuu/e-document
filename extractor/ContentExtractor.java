package extractor;

import java.io.IOException;

// Strategy Pattern: interface trich xuat noi dung file
public interface ContentExtractor {
    String extract(String filePath) throws IOException;
    boolean supports(String fileExtension);
}
