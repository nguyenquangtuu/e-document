package model;

// Lop chua thong tin ho so dien tu (Domain Model)
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

    public Document() {
        this.status = DocumentStatus.MOI_TAO;
    }

    public Document(String id, String applicantName, String applicantEmail, String applicantPhone,
                    String officerName, String officerEmail, String officerPhone,
                    String documentType, String filePath, String fileExtension,
                    long fileSizeKB, String digitalSignature) {
        this.id = id;
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.applicantPhone = applicantPhone;
        this.officerName = officerName;
        this.officerEmail = officerEmail;
        this.officerPhone = officerPhone;
        this.documentType = documentType;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
        this.fileSizeKB = fileSizeKB;
        this.digitalSignature = digitalSignature;
        this.status = DocumentStatus.MOI_TAO;
    }

    // Copy constructor ho tro luu trang thai truoc khi thuc thi lenh (Command Pattern Undo)
    public Document(Document other) {
        if (other != null) {
            this.id = other.id;
            this.applicantName = other.applicantName;
            this.applicantEmail = other.applicantEmail;
            this.applicantPhone = other.applicantPhone;
            this.officerName = other.officerName;
            this.officerEmail = other.officerEmail;
            this.officerPhone = other.officerPhone;
            this.documentType = other.documentType;
            this.filePath = other.filePath;
            this.fileExtension = other.fileExtension;
            this.fileSizeKB = other.fileSizeKB;
            this.digitalSignature = other.digitalSignature;
            this.extractedContent = other.extractedContent;
            this.status = other.status;
        }
    }

    // Kiem tra du 11 truong thong tin co ban
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
    public void setId(String id) { this.id = id; }

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }

    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }

    public String getApplicantPhone() { return applicantPhone; }
    public void setApplicantPhone(String applicantPhone) { this.applicantPhone = applicantPhone; }

    public String getOfficerName() { return officerName; }
    public void setOfficerName(String officerName) { this.officerName = officerName; }

    public String getOfficerEmail() { return officerEmail; }
    public void setOfficerEmail(String officerEmail) { this.officerEmail = officerEmail; }

    public String getOfficerPhone() { return officerPhone; }
    public void setOfficerPhone(String officerPhone) { this.officerPhone = officerPhone; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    public String getFileExtension() { return fileExtension; }
    public void setFileExtension(String fileExtension) { this.fileExtension = fileExtension; }

    public long getFileSizeKB() { return fileSizeKB; }
    public void setFileSizeKB(long fileSizeKB) { this.fileSizeKB = fileSizeKB; }

    public String getDigitalSignature() { return digitalSignature; }
    public void setDigitalSignature(String digitalSignature) { this.digitalSignature = digitalSignature; }

    public String getExtractedContent() { return extractedContent; }
    public void setExtractedContent(String extractedContent) { this.extractedContent = extractedContent; }

    public DocumentStatus getStatus() { return status; }
    public String getStatusName() { return status != null ? status.name() : ""; }

    public void setStatus(DocumentStatus status) { this.status = status; }
    public void setStatus(String statusStr) { this.status = DocumentStatus.fromString(statusStr); }

    @Override
    public String toString() {
        return "Ho so: " + id + " - Nguoi nop: " + applicantName + " - Trang thai: " + (status != null ? status.getDisplayName() : "");
    }
}