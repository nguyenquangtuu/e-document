package extractor;

import java.io.IOException;

// Gia lap OCR nhan dien hinh anh (.jpg, .jpeg, .png)
public class ImageOcrExtractor implements ContentExtractor {

    @Override
    public boolean supports(String fileExtension) {
        if (fileExtension == null) return false;
        String ext = fileExtension.toLowerCase().trim();
        return ext.equals("jpg") || ext.equals("jpeg") || ext.equals("png");
    }

    @Override
    public String extract(String filePath) throws IOException {
        System.out.println("Gia lap OCR doc hinh anh: " + filePath);
        return "Noi dung trich xuat tu hinh anh qua OCR";
    }
}
