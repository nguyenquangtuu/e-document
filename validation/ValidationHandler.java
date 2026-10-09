package validation;

import model.Document;

// Chain of Responsibility: abstract handler kiem tra ho so
public abstract class ValidationHandler {
    public static final int MAX_FILE_SIZE_KB = 5120; // 5MB

    protected ValidationHandler next;

    public ValidationHandler setNext(ValidationHandler next) {
        this.next = next;
        return next;
    }

    public abstract ValidationResult handle(Document doc);

    protected ValidationResult passToNext(Document doc) {
        if (this.next != null) {
            return this.next.handle(doc);
        }
        return ValidationResult.success();
    }
}
