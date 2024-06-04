package rgo.wm.common.utils.validator.rule;

public class ValidationRuleResult {

    private final String errorMessage;

    private ValidationRuleResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ValidationRuleResult passed() {
        return new ValidationRuleResult(null);
    }

    public static ValidationRuleResult failed(String errorMessage) {
        return new ValidationRuleResult(errorMessage);
    }

    public boolean isFailed() {
        return errorMessage != null;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
