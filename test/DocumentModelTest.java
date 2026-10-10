package test;

import model.Document;
import model.DocumentStatus;

public class DocumentModelTest {
    public static void main(String[] args) {
        System.out.println("Running DocumentModelTest...");

        // 1. Test creation and default status
        Document doc = new Document();
        assert doc.getStatus() == DocumentStatus.MOI_TAO : "Default status must be MOI_TAO";

        // 2. Test full constructor
        Document fullDoc = new Document(
            "TEST_01", "Nguyen Van A", "a@test.com", "0123456789",
            "Can bo B", "b@tdtu.edu.vn", "0987654321",
            "DON_XIN_PHEP", "sample.txt", "txt", 1024, "RSA_TEST"
        );
        assert fullDoc.validate() : "Full document must be valid";
        assert "TEST_01".equals(fullDoc.getId()) : "ID must match";

        // 3. Test copy constructor
        Document copy = new Document(fullDoc);
        assert copy.getId().equals(fullDoc.getId()) : "Copy must have same ID";
        copy.setStatus(DocumentStatus.DA_XU_LY);
        assert fullDoc.getStatus() == DocumentStatus.MOI_TAO : "Original status must remain untouched";
        assert copy.getStatus().isTerminal() : "Status DA_XU_LY must be terminal";

        System.out.println("DocumentModelTest PASSED.");
    }
}
