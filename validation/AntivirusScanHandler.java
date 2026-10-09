package validation;

import model.Document;

// Tram 2: Quet virus va ma doc
public class AntivirusScanHandler extends ValidationHandler {

    @Override
    public ValidationResult handle(Document doc) {
        String path = doc.getFilePath();
        if (path != null) {
            String lower = path.toLowerCase();
            if (lower.contains("virus") || lower.contains("malware")) {
                return ValidationResult.failure("AntivirusScanHandler", "Phat hien ma doc hoac virus trong file: " + path);
            }
        }
        return passToNext(doc);
    }
}
