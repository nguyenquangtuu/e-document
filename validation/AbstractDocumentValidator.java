package validation;

import model.Document;

/**
 * Template Method Pattern (Chuong 4 - Course Syllabus 504077):
 * Dinh nghia khung xuong thuat toan kiem duyet ho so trong phuong thuc 'validate'.
 * Cac lop con trien khai cac buoc cu the ma khong duoc phep thay doi cau truc thuat toan.
 * 
 * Nguyen tac Hollywood Principle: "Don't call us, we'll call you" -
 * Lop cha goi cac phuong thuc cua lop con thong qua Template Method va Hook method.
 */
public abstract class AbstractDocumentValidator {

    // TEMPLATE METHOD: Co dinh khung quy trinh kiem duyet, danh dau 'final' de ngan lop con override
    public final ValidationResult validate(Document doc) {
        if (doc == null) {
            return ValidationResult.failure("InputCheck", "Ho so khong duoc null.");
        }

        // Buoc 1: Kiem tra thong tin bat buoc va dung luong tap tin (Primitive Step 1)
        ValidationResult r1 = validateRequiredFields(doc);
        if (!r1.isValid()) {
            return r1;
        }

        // Buoc 2: Quet an toan tap tin chong ma doc / virus (Primitive Step 2)
        ValidationResult r2 = scanAntivirus(doc);
        if (!r2.isValid()) {
            return r2;
        }

        // Buoc 3: Kiem tra tinh toan ven va chong trung lap ma ho so (Primitive Step 3)
        ValidationResult r3 = checkDuplicate(doc);
        if (!r3.isValid()) {
            return r3;
        }

        // Buoc 4: HOOK METHOD (Hollywood Principle)
        // Lop con quyet dinh co bat hook kiem tra bo sung hay khong
        if (isSecurityHookEnabled()) {
            ValidationResult rHook = postValidationSecurityHook(doc);
            if (!rHook.isValid()) {
                return rHook;
            }
        }

        return ValidationResult.success();
    }

    // Cac phuong thuc nguyen thuy (Primitive steps) buoc lop con phai trien khai
    protected abstract ValidationResult validateRequiredFields(Document doc);
    protected abstract ValidationResult scanAntivirus(Document doc);
    protected abstract ValidationResult checkDuplicate(Document doc);

    // HOOK METHODS: Cung cap hanh vi mac dinh, lop con co the ghi de (override) neu muon
    protected boolean isSecurityHookEnabled() {
        return false; // Mac dinh khong bat hook
    }

    protected ValidationResult postValidationSecurityHook(Document doc) {
        return ValidationResult.success(); // Mac dinh pass qua hook
    }
}
