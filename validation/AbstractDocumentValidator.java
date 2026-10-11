package validation;

import model.Document;

public abstract class AbstractDocumentValidator {

    public final ValidationResult validate(Document doc) {
        if (doc == null) {
            return ValidationResult.failure("InputCheck", "Ho so khong duoc null.");
        }

        ValidationResult r1 = validateRequiredFields(doc);
        if (!r1.isValid()) {
            return r1;
        }

        ValidationResult r2 = scanAntivirus(doc);
        if (!r2.isValid()) {
            return r2;
        }

        ValidationResult r3 = checkDuplicate(doc);
        if (!r3.isValid()) {
            return r3;
        }

        if (isSecurityHookEnabled()) {
            ValidationResult rHook = postValidationSecurityHook(doc);
            if (!rHook.isValid()) {
                return rHook;
            }
        }

        return ValidationResult.success();
    }

    protected abstract ValidationResult validateRequiredFields(Document doc);
    protected abstract ValidationResult scanAntivirus(Document doc);
    protected abstract ValidationResult checkDuplicate(Document doc);

    protected boolean isSecurityHookEnabled() {
        return false;
    }

    protected ValidationResult postValidationSecurityHook(Document doc) {
        return ValidationResult.success();
    }
}

