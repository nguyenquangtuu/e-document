package validation;

public class ValidationResult {
    private final boolean valid;
    private final String errorMessage;
    private final String failedStepName;

    private ValidationResult(boolean valid, String failedStepName, String errorMessage) {
        this.valid = valid;
        this.failedStepName = failedStepName;
        this.errorMessage = errorMessage;
    }

    public static ValidationResult success() {
        return new ValidationResult(true, null, null);
    }

    public static ValidationResult failure(String stepName, String message) {
        return new ValidationResult(false, stepName, message);
    }

    public boolean isValid() { return valid; }
    public String getErrorMessage() { return errorMessage; }
    public String getFailedStepName() { return failedStepName; }
    public String getFailedHandlerName() { return failedStepName; }
}

