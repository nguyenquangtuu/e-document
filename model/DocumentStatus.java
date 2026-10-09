package model;

// Enum cac trang thai cua ho so
public enum DocumentStatus {
    MOI_TAO("Moi tao"),
    DA_TIEP_NHAN("Da tiep nhan"),
    DANG_XET_DUYET("Dang xet duyet"),
    DA_XU_LY("Da xu ly"),
    TU_CHOI("Tu choi");

    private final String displayName;

    DocumentStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static DocumentStatus fromString(String text) {
        if (text != null) {
            for (DocumentStatus status : DocumentStatus.values()) {
                if (status.name().equalsIgnoreCase(text.trim())) {
                    return status;
                }
            }
        }
        return MOI_TAO;
    }
}
