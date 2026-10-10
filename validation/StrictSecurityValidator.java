package validation;

import model.Document;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Concrete Class 2 trong Template Method Pattern:
 * Kiem duyet ho so theo tieu chuan nghiem ngat ve an ninh (Strict Security).
 * Bat Hook Method de kiem tra chu ky so RSA va danh sach trang whitelist dinh dang tep.
 */
public class StrictSecurityValidator extends StandardDocumentValidator {
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>(Arrays.asList("txt", "pdf", "jpg", "png"));

    public StrictSecurityValidator() {
        super();
    }

    public StrictSecurityValidator(Set<String> initialIds) {
        super(initialIds);
    }

    // BẬT HOOK METHOD (Hollywood Principle)
    @Override
    protected boolean isSecurityHookEnabled() {
        return true;
    }

    // TRIỂN KHAI HOOK METHOD CHO AN NINH MỨC CAO
    @Override
    protected ValidationResult postValidationSecurityHook(Document doc) {
        // 1. Kiem tra dinh dang trong Whitelist
        String ext = (doc.getFileExtension() != null) ? doc.getFileExtension().toLowerCase().trim() : "";
        if (!ALLOWED_EXTENSIONS.contains(ext)) {
            return ValidationResult.failure("StrictSecurityHook", "Dinh dang tap tin ." + ext + " khong nam trong Whitelist duoc phep cua bo phan an ninh.");
        }

        // 2. Kiem tra bat buoc chu ky so hop le (Chung thu so RSA)
        String signature = doc.getDigitalSignature();
        if (signature == null || signature.trim().isEmpty() || !signature.startsWith("RSA")) {
            return ValidationResult.failure("StrictSecurityHook", "Chung thu chu ky so khong hop le hoac bi thieu (Yeu cau tieu chuan RSA).");
        }

        return ValidationResult.success();
    }
}
