package model;

// Builder Pattern: ho tro tao Document tung buoc va luu nhap
public class DocumentBuilder {
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
    private DocumentStatus status = DocumentStatus.MOI_TAO;

    public DocumentBuilder() {}

    public DocumentBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public DocumentBuilder setApplicantInfo(String name, String email, String phone) {
        this.applicantName = name;
        this.applicantEmail = email;
        this.applicantPhone = phone;
        return this;
    }

    public DocumentBuilder setOfficerInfo(String name, String email, String phone) {
        this.officerName = name;
        this.officerEmail = email;
        this.officerPhone = phone;
        return this;
    }

    public DocumentBuilder setDocumentInfo(String documentType) {
        this.documentType = documentType;
        return this;
    }

    public DocumentBuilder setFileInfo(String filePath, String fileExtension, long fileSizeKB) {
        this.filePath = filePath;
        this.fileExtension = fileExtension;
        this.fileSizeKB = fileSizeKB;
        return this;
    }

    public DocumentBuilder setSecurityInfo(String digitalSignature) {
        this.digitalSignature = digitalSignature;
        return this;
    }

    public DocumentBuilder setExtractedContent(String extractedContent) {
        this.extractedContent = extractedContent;
        return this;
    }

    public DocumentBuilder setStatus(DocumentStatus status) {
        this.status = status;
        return this;
    }

    public DocumentBuilder setStatus(String statusStr) {
        this.status = DocumentStatus.fromString(statusStr);
        return this;
    }

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

    public Document build() {
        return new Document(this);
    }
}
