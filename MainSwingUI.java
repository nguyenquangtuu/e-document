import command.ApproveDocumentCommand;
import command.DocumentCommandInvoker;
import command.RejectDocumentCommand;
import model.Document;
import storage.DocumentStorageTarget;
import storage.StorageAdapterFactory;
import service.DocumentProcessor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainSwingUI extends JFrame {
    private JTextArea consoleArea;
    private JTable documentTable;
    private DefaultTableModel tableModel;
    private DocumentProcessor processor;
    private DocumentStorageTarget storageAdapter;
    private final DocumentCommandInvoker invoker;
    private List<Document> documentList;
    private JComboBox<String> cbStorageType;

    public MainSwingUI() {
        this.invoker = new DocumentCommandInvoker();
        this.storageAdapter = StorageAdapterFactory.getDefaultAdapter();
        this.processor = new DocumentProcessor(this.storageAdapter);
        this.documentList = new ArrayList<>();

        setTitle("He thong Quan ly Ho so Dien tu - eDocument v2.0");
        setSize(980, 680);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Ma ho so", "Nguoi nop", "Loai ho so", "Trang thai", "Dinh dang"};
        tableModel = new DefaultTableModel(columnNames, 0);
        documentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(documentTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Danh sach ho so dien tu"));

        consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        consoleArea.setBackground(new Color(25, 25, 25));
        consoleArea.setForeground(new Color(120, 255, 120));
        consoleArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane logScrollPane = new JScrollPane(consoleArea);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Nhat ky he thong"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScrollPane, logScrollPane);
        splitPane.setDividerLocation(300);
        add(splitPane, BorderLayout.CENTER);

        JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        JButton btnAdd = new JButton("Them ho so");
        JButton btnApprove = new JButton("Phe duyet");
        JButton btnReject = new JButton("Tu choi");
        JButton btnUndo = new JButton("Hoan tac");
        JButton btnClear = new JButton("Xoa log");

        JLabel lblStorage = new JLabel("Kho luu tru:");
        cbStorageType = new JComboBox<>(new String[]{"Local JSON File", "MySQL Database", "AWS S3 Cloud"});

        toolBar.add(btnAdd);
        toolBar.add(btnApprove);
        toolBar.add(btnReject);
        toolBar.add(btnUndo);
        toolBar.add(new JSeparator(SwingConstants.VERTICAL));
        toolBar.add(lblStorage);
        toolBar.add(cbStorageType);
        toolBar.add(btnClear);
        add(toolBar, BorderLayout.NORTH);

        redirectSystemStreams();
        loadExistingDocuments();
        refreshTable();

        cbStorageType.addActionListener(e -> {
            String selected = (String) cbStorageType.getSelectedItem();
            String key = "json";
            if (selected != null && selected.contains("MySQL")) key = "mysql";
            else if (selected != null && selected.contains("AWS")) key = "s3";

            this.storageAdapter = StorageAdapterFactory.getStorageAdapter(key);
            this.processor = new DocumentProcessor(this.storageAdapter);
            System.out.println("\n[Storage] Da chuyen sang kho luu tru: " + storageAdapter.getStorageName());
            loadExistingDocuments();
            refreshTable();
        });

        btnAdd.addActionListener(e -> {
            AddDocumentDialog dialog = new AddDocumentDialog(this, processor, invoker);
            dialog.setVisible(true);
            refreshTable();
        });

        btnApprove.addActionListener(e -> {
            Document selectedDoc = getSelectedDocument();
            if (selectedDoc == null) {
                JOptionPane.showMessageDialog(this, "Vui long chon 1 ho so trong bang de phe duyet!");
                return;
            }
            try {
                invoker.executeCommand(new ApproveDocumentCommand(storageAdapter, selectedDoc, "Can bo da duyet qua giao dien Swing"));
                refreshTable();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi khi phe duyet: " + ex.getMessage());
            }
        });

        btnReject.addActionListener(e -> {
            Document selectedDoc = getSelectedDocument();
            if (selectedDoc == null) {
                JOptionPane.showMessageDialog(this, "Vui long chon 1 ho so trong bang de tu choi!");
                return;
            }
            String reason = JOptionPane.showInputDialog(this, "Nhap ly do tu choi:", "Tu choi ho so", JOptionPane.QUESTION_MESSAGE);
            if (reason != null && !reason.trim().isEmpty()) {
                try {
                    invoker.executeCommand(new RejectDocumentCommand(storageAdapter, selectedDoc, reason.trim()));
                    refreshTable();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi tu choi: " + ex.getMessage());
                }
            }
        });

        btnUndo.addActionListener(e -> {
            if (invoker.canUndo()) {
                invoker.undo();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Khong co thao tac nao de hoan tac!");
            }
        });

        btnClear.addActionListener(e -> consoleArea.setText(""));

        documentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && documentTable.getSelectedRow() != -1) {
                Document doc = getSelectedDocument();
                if (doc != null) {
                    System.out.println("\nChi tiet ho so: " + doc.getId());
                    System.out.println("- Nguoi nop: " + doc.getApplicantName() + " (" + doc.getApplicantEmail() + ", " + doc.getApplicantPhone() + ")");
                    System.out.println("- Can bo: " + doc.getOfficerName() + " (" + doc.getOfficerEmail() + ")");
                    System.out.println("- Loai ho so: " + doc.getDocumentType());
                    System.out.println("- Tep dinh kem: " + doc.getFilePath() + " (" + doc.getFileSizeKB() + " KB)");
                    System.out.println("- Chu ky so: " + doc.getDigitalSignature());
                    System.out.println("- Noi dung trich xuat: " + (doc.getExtractedContent() != null ? doc.getExtractedContent() : "(Chua co)"));
                    System.out.println("- Trang thai: " + (doc.getStatus() != null ? doc.getStatus().getDisplayName() : ""));
                }
            }
        });
    }

    private Document getSelectedDocument() {
        int selectedRow = documentTable.getSelectedRow();
        if (selectedRow == -1) return null;
        String docId = tableModel.getValueAt(selectedRow, 0).toString();
        for (Document doc : documentList) {
            if (doc.getId().equals(docId)) {
                return doc;
            }
        }
        return null;
    }

    public void loadExistingDocuments() {
        try {
            List<Document> loadedDocs = storageAdapter.findAll();
            documentList.clear();
            documentList.addAll(loadedDocs);
            System.out.println("Da nap " + loadedDocs.size() + " ho so tu kho " + storageAdapter.getStorageName());
        } catch (Exception e) {
            System.out.println("Loi nap du lieu: " + e.getMessage());
        }
    }

    public void addDocumentToList(Document doc) {
        if (doc != null) {
            documentList.add(doc);
        }
    }

    public void refreshTable() {
        tableModel.setRowCount(0);
        for (Document doc : documentList) {
            tableModel.addRow(new Object[]{
                doc.getId(),
                doc.getApplicantName(),
                doc.getDocumentType(),
                (doc.getStatus() != null ? doc.getStatus().name() : ""),
                doc.getFileExtension()
            });
        }
    }

    private void redirectSystemStreams() {
        OutputStream out = new OutputStream() {
            @Override public void write(int b) { updateTextArea(String.valueOf((char) b)); }
            @Override public void write(byte[] b, int off, int len) { updateTextArea(new String(b, off, len)); }
        };
        System.setOut(new PrintStream(out, true));
        System.setErr(new PrintStream(out, true));
    }

    private void updateTextArea(final String text) {
        SwingUtilities.invokeLater(() -> {
            consoleArea.append(text);
            consoleArea.setCaretPosition(consoleArea.getDocument().getLength());
        });
    }

    public DocumentCommandInvoker getInvoker() { return invoker; }
    public DocumentProcessor getProcessor() { return processor; }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new MainSwingUI().setVisible(true));
    }
}
