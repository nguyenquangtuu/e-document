package validation;

import model.Document;

import java.util.HashSet;
import java.util.Set;

// Tram 3: Kiem tra trung lap ma ho so
public class DuplicateCheckHandler extends ValidationHandler {
    private final Set<String> processedIds = new HashSet<>();

    @Override
    public ValidationResult handle(Document doc) {
        if (doc != null && doc.getId() != null) {
            String id = doc.getId().trim();
            if (processedIds.contains(id)) {
                return ValidationResult.failure("DuplicateCheckHandler", "Ma ho so da ton tai: " + id);
            }
            processedIds.add(id);
        }
        return passToNext(doc);
    }
}
