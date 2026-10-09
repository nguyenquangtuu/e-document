package validation;

// Ket qua kiem tra sau moi tram
public class ValidationResult {
    private final boolean valid;
    private final String errorMessage;
    private final String failedHandlerName;

    private ValidationResult(boolean valid, String failedHandlerName, String errorMessage) {
        this.valid = valid;
        this.failedHandlerName = failedHandlerName;
        this.errorMessage = errorMessage;
    }

    public static ValidationResult success() {
        return new ValidationResult(true, null, null);
    }

    public static ValidationResult failure(String handlerName, String message) {
        return new ValidationResult(false, handlerName, message);
    }

    public boolean isValid() { return valid; }
    public String getErrorMessage() { return errorMessage; }
    public String getFailedHandlerName() { return failedHandlerName; }
}
