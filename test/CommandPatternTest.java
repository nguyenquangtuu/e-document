package test;

import command.ApproveDocumentCommand;
import command.DocumentCommandInvoker;
import model.Document;
import model.DocumentStatus;
import storage.JsonFileStorageAdapter;

public class CommandPatternTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Running CommandPatternTest...");

        DocumentCommandInvoker invoker = new DocumentCommandInvoker();
        Document doc = new Document();
        doc.setId("CMD_TEST_01");
        doc.setStatus(DocumentStatus.DA_TIEP_NHAN);

        // Execute Approve Command
        ApproveDocumentCommand approveCmd = new ApproveDocumentCommand(new JsonFileStorageAdapter("server_storage"), doc, "Test approval");
        invoker.executeCommand(approveCmd);

        assert doc.getStatus() == DocumentStatus.DA_XU_LY : "Document status must be DA_XU_LY";
        assert invoker.canUndo() : "Invoker must be able to undo";
        assert invoker.getUndoStackSize() == 1 : "Undo stack size must be 1";

        // Undo Approve Command
        boolean undoResult = invoker.undo();
        assert undoResult : "Undo must succeed";
        assert doc.getStatus() == DocumentStatus.DA_TIEP_NHAN : "Status must revert to DA_TIEP_NHAN";
        assert invoker.canRedo() : "Invoker must be able to redo";

        System.out.println("CommandPatternTest PASSED.");
    }
}
