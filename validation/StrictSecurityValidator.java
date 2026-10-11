package validation;

import model.Document;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StrictSecurityValidator extends StandardDocumentValidator {
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "pdf", "jpg", "png"));

    public StrictSecurityValidator() {
        super();
    }

    public StrictSecurityValidator(Set<String> initialIds) {
        super(initialIds);
    }

    @Override
    protected boolean isSecurityHookEnabled() {
        return true;
    }

    @Override
    protected ValidationResult postValidationSecurityHook(Document doc) {

        String ext = (doc.getFileExtension() != null) ? doc.getFileExtension().toLowerCase().trim() : "";
        if (!ALLOWED_EXTENSIONS.contains(ext)) {
            return ValidationResult.failure("StrictSecurityHook", "Dinh dang tap tin ." + ext + " khong nam trong Whitelist duoc phep cua bo phan an ninh.");
        }

        String signature = doc.getDigitalSignature();
        if (signature == null || signature.trim().isEmpty() || !signature.startsWith("RSA")) {
            return ValidationResult.failure("StrictSecurityHook", "Chung thu chu ky so khong hop le hoac bi thieu (Yeu cau tieu chuan RSA).");
        }

        return ValidationResult.success();
    }
}

