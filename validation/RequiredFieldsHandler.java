package validation;

import model.Document;

// Tram 1: Kiem tra 11 truong bat buoc va dung luong <= 5MB
public class RequiredFieldsHandler extends ValidationHandler {

    @Override
    public ValidationResult handle(Document doc) {
        if (doc == null || !doc.validate()) {
            return ValidationResult.failure("RequiredFieldsHandler", "Ho so thieu cac truong bat buoc.");
        }
        if (doc.getFileSizeKB() > MAX_FILE_SIZE_KB) {
            return ValidationResult.failure("RequiredFieldsHandler", "Dung luong file vuot qua 5MB: " + doc.getFileSizeKB() + "KB");
        }
        return passToNext(doc);
    }
}
