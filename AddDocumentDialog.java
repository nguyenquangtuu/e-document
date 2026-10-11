import command.DocumentCommandInvoker;
import command.SubmitDocumentCommand;
import model.Document;
import model.DocumentStatus;
import service.DocumentProcessor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.UUID;

// Dialog nhap thong tin tiep nhan ho so (Ket noi voi Command Pattern de Submit)
public class AddDocumentDialog extends JDialog {
    private JTextField txtApplicantName, txtApplicantEmail, txtApplicantPhone;
    private JTextField txtOfficerName, txtOfficerEmail, txtOfficerPhone;
    private JComboBox<String> cbDocumentType;
    private JTextField txtDigitalSignature;
    private JLabel lblFileName;
    private File selectedFile;
    
    private DocumentProcessor processor;
    private DocumentCommandInvoker invoker;
    private MainSwingUI parent;

    public AddDocumentDialog(MainSwingUI parent, DocumentProcessor processor) {
        this(parent, processor, parent != null ? parent.getInvoker() : new DocumentCommandInvoker());
    }

    public AddDocumentDialog(MainSwingUI parent, DocumentProcessor processor, DocumentCommandInvoker invoker) {
        super(parent, "Tiep nhan ho so moi (Command Pattern)", true);
        this.parent = parent;
        this.processor = processor;
        this.invoker = (invoker != null) ? invoker : new DocumentCommandInvoker();
        
        setSize(440, 520);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(10, 2, 5, 8));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        formPanel.add(new JLabel("Ten nguoi nop:"));
        txtApplicantName = new JTextField();
        formPanel.add(txtApplicantName);

        formPanel.add(new JLabel("Email nguoi nop:"));
        txtApplicantEmail = new JTextField();
        formPanel.add(txtApplicantEmail);

        formPanel.add(new JLabel("SDT nguoi nop:"));
        txtApplicantPhone = new JTextField();
        formPanel.add(txtApplicantPhone);

        formPanel.add(new JLabel("Ten can bo:"));
        txtOfficerName = new JTextField("Can bo truc ban");
        formPanel.add(txtOfficerName);

        formPanel.add(new JLabel("Email can bo:"));
        txtOfficerEmail = new JTextField("officer@tdtu.edu.vn");
        formPanel.add(txtOfficerEmail);

        formPanel.add(new JLabel("SDT can bo:"));
        txtOfficerPhone = new JTextField("0123456789");
        formPanel.add(txtOfficerPhone);

        formPanel.add(new JLabel("Loai ho so:"));
        cbDocumentType = new JComboBox<>(new String[]{"DON_XIN_PHEP", "BAO_CAO", "HO_SO_THUE"});
        formPanel.add(cbDocumentType);

        formPanel.add(new JLabel("Chu ky so:"));
        txtDigitalSignature = new JTextField("RSA_VALID_SIGNATURE");
        formPanel.add(txtDigitalSignature);

        formPanel.add(new JLabel("Tep dinh kem:"));
        JButton btnFile = new JButton("Chon file...");
        lblFileName = new JLabel("Chua chon file");
        JPanel pFile = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pFile.add(btnFile); pFile.add(lblFileName);
        formPanel.add(pFile);

        add(formPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnSend = new JButton("Gui ho so (Submit)");
        JButton btnCancel = new JButton("Huy");
        btnPanel.add(btnSend);
        btnPanel.add(btnCancel);
        add(btnPanel, BorderLayout.SOUTH);

        btnFile.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedFile = fc.getSelectedFile();
                lblFileName.setText(selectedFile.getName());
            }
        });

        btnCancel.addActionListener(e -> dispose());

        btnSend.addActionListener(e -> submitAction());
    }

    private void submitAction() {
        String filePath = (selectedFile != null) ? selectedFile.getAbsolutePath() : "";
        String ext = "";
        long size = 0;
        if (selectedFile != null) {
            size = selectedFile.length() / 1024;
            String name = selectedFile.getName();
            int lastDot = name.lastIndexOf('.');
            if (lastDot > 0) {
                ext = name.substring(lastDot + 1);
            }
        }

        // Su dung Builder Pattern de khoi tao Document tung buoc va linh hoat
        String id = "DOC" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        Document doc = new Document.Builder()
                .withId(id)
                .withApplicantInfo(
                        txtApplicantName.getText().trim(),
                        txtApplicantEmail.getText().trim(),
                        txtApplicantPhone.getText().trim()
                )
                .withOfficerInfo(
                        txtOfficerName.getText().trim(),
                        txtOfficerEmail.getText().trim(),
                        txtOfficerPhone.getText().trim()
                )
                .withDocumentType(cbDocumentType.getSelectedItem().toString())
                .withFileInfo(filePath, ext, size)
                .withSignatureAndContent(txtDigitalSignature.getText().trim(), "")
                .withStatus(DocumentStatus.MOI_TAO)
                .build();

        try {
            // Su dung Command Pattern de thuc thi lenh nop ho so
            SubmitDocumentCommand submitCmd = new SubmitDocumentCommand(processor, doc);
            invoker.executeCommand(submitCmd);

            if (doc.getStatus() == DocumentStatus.DA_XU_LY || doc.getStatus() == DocumentStatus.DANG_XET_DUYET || doc.getStatus() == DocumentStatus.DA_TIEP_NHAN) {
                if (parent != null) {
                    parent.addDocumentToList(doc);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ho so bi tu choi boi quy trinh kiem duyet (Template Method). Vui long kiem tra log chi tiet.",
                        "Thong bao", JOptionPane.WARNING_MESSAGE);
                if (parent != null) {
                    parent.addDocumentToList(doc);
                }
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Loi khi gui ho so: " + ex.getMessage(),
                    "Loi", JOptionPane.ERROR_MESSAGE);
        }
    }
}