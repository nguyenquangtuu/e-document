package command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * Invoker trong Command Pattern (Chuong 7 - Course Syllabus 504077):
 * - Quan ly viec goi thuc thi lenh (execute)
 * - Quan ly ngan xep lich su phuc vu Hoan tac / Lam lai (Case Study 7.5: Undo / Redo)
 * - Quan ly nhat ky giao dich kiem toan he thong (Case Study 7.6: Logging)
 */
public class DocumentCommandInvoker {
    private final Stack<DocumentCommand> undoStack = new Stack<>();
    private final Stack<DocumentCommand> redoStack = new Stack<>();
    private final List<String> auditLogs = Collections.synchronizedList(new ArrayList<>());
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // Thuc thi lenh moi
    public void executeCommand(DocumentCommand command) throws Exception {
        if (command == null) return;

        command.execute();
        undoStack.push(command);
        redoStack.clear(); // Xoa stack redo khi co hanh dong moi

        logAction("EXECUTE", command.getDescription());
    }

    // Hoan tac lenh vua thuc thi (Undo)
    public boolean undo() {
        if (undoStack.isEmpty()) {
            System.out.println("[CommandInvoker] Ngan xep Undo rong, khong the hoan tac.");
            return false;
        }

        DocumentCommand cmd = undoStack.pop();
        try {
            cmd.undo();
            redoStack.push(cmd);
            logAction("UNDO", cmd.getDescription());
            return true;
        } catch (Exception e) {
            System.out.println("[CommandInvoker] Loi khi Undo: " + e.getMessage());
            return false;
        }
    }

    // Lam lai lenh vua hoan tac (Redo)
    public boolean redo() {
        if (redoStack.isEmpty()) {
            System.out.println("[CommandInvoker] Ngan xep Redo rong, khong the lam lai.");
            return false;
        }

        DocumentCommand cmd = redoStack.pop();
        try {
            cmd.execute();
            undoStack.push(cmd);
            logAction("REDO", cmd.getDescription());
            return true;
        } catch (Exception e) {
            System.out.println("[CommandInvoker] Loi khi Redo: " + e.getMessage());
            return false;
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public List<String> getAuditLogs() {
        return Collections.unmodifiableList(auditLogs);
    }

    private void logAction(String actionType, String description) {
        String logEntry = String.format("[%s] [%s] %s", dateFormat.format(new Date()), actionType, description);
        auditLogs.add(logEntry);
        System.out.println("[AUDIT LOG] " + logEntry);
    }
}
