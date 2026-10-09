import model.Document;
import repository.DocumentRepository;
import repository.RepositoryFactory;
import service.DocumentProcessor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Giao dien Swing chinh cua he thong
public class MainSwingUI extends JFrame {
    private JTextArea consoleArea;
    private JTable documentTable;
    private DefaultTableModel tableModel;
    private DocumentProcessor processor;
    private DocumentRepository repository;
    private List<Document> documentList;

    public MainSwingUI() {
        repository = RepositoryFactory.getDefaultRepository();
        processor = new DocumentProcessor(repository);
        documentList = new ArrayList<>();

        setTitle("He thong Quan ly Ho so Dien tu - eDocument v2.0");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Ma ho so", "Nguoi nop", "Loai ho so", "Trang thai", "Dinh dang"};
        tableModel = new DefaultTableModel(columnNames, 0);
        documentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(documentTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Danh sach ho so"));

        consoleArea = new JTextArea();
        consoleArea.setEditable(false);
        consoleArea.setBackground(new Color(30, 30, 30));
        consoleArea.setForeground(new Color(100, 255, 100));
        consoleArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        JScrollPane logScrollPane = new JScrollPane(consoleArea);
        logScrollPane.setBorder(BorderFactory.createTitledBorder("Log he thong"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, tableScrollPane, logScrollPane);
        splitPane.setDividerLocation(280);
        add(splitPane, BorderLayout.CENTER);

        JPanel toolBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdd = new JButton("Them ho so");
        JButton btnClear = new JButton("Xoa log");
        toolBar.add(btnAdd);
        toolBar.add(btnClear);
        add(toolBar, BorderLayout.NORTH);

        redirectSystemStreams();
        loadExistingDocuments();
        refreshTable();

        btnAdd.addActionListener(e -> {
            AddDocumentDialog dialog = new AddDocumentDialog(this, processor);
            dialog.setVisible(true);
            refreshTable();
        });

        btnClear.addActionListener(e -> consoleArea.setText(""));

        documentTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && documentTable.getSelectedRow() != -1) {
                int selectedRow = documentTable.getSelectedRow();
                String docId = tableModel.getValueAt(selectedRow, 0).toString();
                
                for (Document doc : documentList) {
                    if (doc.getId().equals(docId)) {
                        System.out.println("\nChi tiet ho so: " + doc.getId());
                        System.out.println("- Nguoi nop: " + doc.getApplicantName() + " (" + doc.getApplicantEmail() + ", " + doc.getApplicantPhone() + ")");
                        System.out.println("- Can bo: " + doc.getOfficerName() + " (" + doc.getOfficerEmail() + ")");
                        System.out.println("- Loai ho so: " + doc.getDocumentType());
                        System.out.println("- Tep dinh kem: " + doc.getFilePath() + " (" + doc.getFileSizeKB() + " KB)");
                        System.out.println("- Chu ky so: " + doc.getDigitalSignature());
                        System.out.println("- Trang thai: " + (doc.getStatus() != null ? doc.getStatus().getDisplayName() : ""));
                        break;
                    }
                }
            }
        });
    }

    private void loadExistingDocuments() {
        try {
            List<Document> loadedDocs = repository.findAll();
            documentList.clear();
            documentList.addAll(loadedDocs);
            System.out.println("Da nap " + loadedDocs.size() + " ho so tu repository.");
        } catch (Exception e) {
            System.out.println("Loi nap du lieu: " + e.getMessage());
        }
    }

    public void addDocumentToList(Document doc) {
        if (doc != null) {
            documentList.add(doc);
        }
    }

    private void refreshTable() {
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

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new MainSwingUI().setVisible(true));
    }
}