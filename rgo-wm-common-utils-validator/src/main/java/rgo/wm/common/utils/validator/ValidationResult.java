package rgo.wm.common.utils.validator;

public class ValidationResult {

    private final int totalRules;
    private final int passedRules;
    private final String errorMessage;

    private ValidationResult(int totalRules, int passedRules, String errorMessage) {
        this.totalRules = totalRules;
        this.passedRules = passedRules;
        this.errorMessage = errorMessage;
    }

    public static ValidationResult passed(int totalRules) {
        return new ValidationResult(totalRules, totalRules, null);
    }

    public static ValidationResult failed(int totalRules, int passedRules, String errorMessage) {
        return new ValidationResult(totalRules, passedRules, errorMessage);
    }

    public boolean isFailed() {
        return totalRules != passedRules;
    }

    public int getTotalRules() {
        return totalRules;
    }

    public int getPassedRules() {
        return passedRules;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
