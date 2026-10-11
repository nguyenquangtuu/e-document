package test;

import model.Document;
import validation.StandardDocumentValidator;
import validation.StrictSecurityValidator;
import validation.ValidationResult;

public class TemplateMethodValidationTest {
    public static void main(String[] args) {
        System.out.println("Running TemplateMethodValidationTest...");

        StandardDocumentValidator standardValidator = new StandardDocumentValidator();
        Document validDoc = new Document(
            "VAL_01", "Le Van A", "a@gmail.com", "0901234567",
            "Can bo", "cb@tdtu.edu.vn", "0123456789",
            "DON_XIN_PHEP", "don.txt", "txt", 100, "NON_RSA_SIG"
        );
        ValidationResult r1 = standardValidator.validate(validDoc);
        assert r1.isValid() : "Valid document must pass standard validation";

        StrictSecurityValidator strictValidator = new StrictSecurityValidator();
        ValidationResult r2 = strictValidator.validate(validDoc);
        assert !r2.isValid() : "Document without RSA signature must fail strict security hook";
        assert "StrictSecurityHook".equals(r2.getFailedStepName()) : "Failed step must be StrictSecurityHook";

        validDoc.setDigitalSignature("RSA_VALID_2026");
        ValidationResult r3 = strictValidator.validate(validDoc);
        assert r3.isValid() : "Document with RSA signature must pass strict validation";

        System.out.println("TemplateMethodValidationTest PASSED.");
    }
}

