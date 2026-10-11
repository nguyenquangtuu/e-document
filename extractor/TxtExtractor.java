package extractor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtExtractor implements ContentExtractor {

    @Override
    public boolean supports(String fileExtension) {
        return fileExtension != null && fileExtension.equalsIgnoreCase("txt");
    }

    @Override
    public String extract(String filePath) throws IOException {
        System.out.println("Dang doc file txt: " + filePath);
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

