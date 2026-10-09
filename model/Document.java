package model;

// Lop chua thong tin ho so dien tu
public class Document {
    private String id;
    private String applicantName;
    private String applicantEmail;
    private String applicantPhone;
    private String officerName;
    private String officerEmail;
    private String officerPhone;
    private String documentType;
    private String filePath;
    private String fileExtension;
    private long fileSizeKB;
    private String digitalSignature;
    private String extractedContent;
    private DocumentStatus status;

    // Khoi tao qua Builder
    public Document(DocumentBuilder builder) {
        if (builder != null) {
            this.id = builder.getId();
            this.applicantName = builder.getApplicantName();
            this.applicantEmail = builder.getApplicantEmail();
            this.applicantPhone = builder.getApplicantPhone();
            this.officerName = builder.getOfficerName();
            this.officerEmail = builder.getOfficerEmail();
            this.officerPhone = builder.getOfficerPhone();
            this.documentType = builder.getDocumentType();
            this.filePath = builder.getFilePath();
            this.fileExtension = builder.getFileExtension();
            this.fileSizeKB = builder.getFileSizeKB();
            this.digitalSignature = builder.getDigitalSignature();
            this.extractedContent = builder.getExtractedContent();
            this.status = (builder.getStatus() != null) ? builder.getStatus() : DocumentStatus.MOI_TAO;
        }
    }

    // Kiem tra du 11 truong thong tin bat buoc
    public boolean validate() {
        return isNotEmpty(this.id) &&
               isNotEmpty(this.applicantName) &&
               isNotEmpty(this.applicantEmail) &&
               isNotEmpty(this.applicantPhone) &&
               isNotEmpty(this.officerName) &&
               isNotEmpty(this.officerEmail) &&
               isNotEmpty(this.officerPhone) &&
               isNotEmpty(this.documentType) &&
               isNotEmpty(this.filePath) &&
               isNotEmpty(this.fileExtension) &&
               isNotEmpty(this.digitalSignature);
    }

    private boolean isNotEmpty(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Getters va Setters
    public String getId() { return id; }
    public String getApplicantName() { return applicantName; }
    public String getApplicantEmail() { return applicantEmail; }
    public String getApplicantPhone() { return applicantPhone; }
    public String getOfficerName() { return officerName; }
    public String getOfficerEmail() { return officerEmail; }
    public String getOfficerPhone() { return officerPhone; }
    public String getDocumentType() { return documentType; }
    public String getFilePath() { return filePath; }
    public String getFileExtension() { return fileExtension; }
    public long getFileSizeKB() { return fileSizeKB; }
    public String getDigitalSignature() { return digitalSignature; }
    public String getExtractedContent() { return extractedContent; }
    public DocumentStatus getStatus() { return status; }
    public String getStatusName() { return status != null ? status.name() : ""; }

    public void setStatus(DocumentStatus status) { this.status = status; }
    public void setStatus(String statusStr) { this.status = DocumentStatus.fromString(statusStr); }
    public void setExtractedContent(String extractedContent) { this.extractedContent = extractedContent; }

    @Override
    public String toString() {
        return "Ho so: " + id + " - Nguoi nop: " + applicantName + " - Trang thai: " + (status != null ? status.getDisplayName() : "");
    }
}