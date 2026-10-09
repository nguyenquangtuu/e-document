package validation;

import model.Document;

// Quan ly chuoi kiem tra ho so
public class ValidationPipeline {
    private ValidationHandler firstHandler;
    private ValidationHandler lastHandler;

    public ValidationPipeline addHandler(ValidationHandler handler) {
        if (handler == null) return this;
        if (firstHandler == null) {
            firstHandler = handler;
            lastHandler = handler;
        } else {
            lastHandler.setNext(handler);
            lastHandler = handler;
        }
        return this;
    }

    public ValidationResult validate(Document doc) {
        if (firstHandler == null) {
            return ValidationResult.success();
        }
        return firstHandler.handle(doc);
    }

    // Tao pipeline mac dinh voi 3 tram kiem tra
    public static ValidationPipeline createDefaultPipeline() {
        return new ValidationPipeline()
                .addHandler(new RequiredFieldsHandler())
                .addHandler(new AntivirusScanHandler())
                .addHandler(new DuplicateCheckHandler());
    }
}
