package validation;

import model.Document;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Concrete Class 1 trong Template Method Pattern:
 * Kiem duyet ho so theo tieu chuan nghiep vu co ban (Standard).
 */
public class StandardDocumentValidator extends AbstractDocumentValidator {
    private final Set<String> existingIds = Collections.synchronizedSet(new HashSet<>());

    public StandardDocumentValidator() {}

    public StandardDocumentValidator(Set<String> initialIds) {
        if (initialIds != null) {
            this.existingIds.addAll(initialIds);
        }
    }

    public void registerExistingId(String id) {
        if (id != null) {
            existingIds.add(id);
        }
    }

    @Override
    protected ValidationResult validateRequiredFields(Document doc) {
        if (doc.getId() == null || doc.getId().trim().isEmpty()) {
            return ValidationResult.failure("RequiredFields", "Ma ho so khong duoc de trong.");
        }
        if (doc.getApplicantName() == null || doc.getApplicantName().trim().isEmpty()) {
            return ValidationResult.failure("RequiredFields", "Ten nguoi nop khong duoc de trong.");
        }
        if (doc.getApplicantEmail() == null || !doc.getApplicantEmail().contains("@")) {
            return ValidationResult.failure("RequiredFields", "Email nguoi nop khong hop le.");
        }
        if (doc.getFileSizeKB() > 5120) { // Vuot qua 5MB
            return ValidationResult.failure("RequiredFields", "Dung luong tep vuot qua gioi han 5MB (Hien tai: " + doc.getFileSizeKB() + " KB).");
        }
        return ValidationResult.success();
    }

    @Override
    protected ValidationResult scanAntivirus(Document doc) {
        String path = (doc.getFilePath() != null) ? doc.getFilePath().toLowerCase() : "";
        if (path.contains("virus") || path.contains("malware") || path.contains("trojan") || path.contains("eicar")) {
            return ValidationResult.failure("AntivirusScan", "Phat hien ma doc nguy hiem trong tap tin: " + doc.getFilePath());
        }
        return ValidationResult.success();
    }

    @Override
    protected ValidationResult checkDuplicate(Document doc) {
        if (existingIds.contains(doc.getId())) {
            return ValidationResult.failure("DuplicateCheck", "Ma ho so da ton tai trong he thong: " + doc.getId());
        }
        return ValidationResult.success();
    }

    // Standard validator giu nguyen hook mac dinh (khong bat hook bao mat cao)
}
