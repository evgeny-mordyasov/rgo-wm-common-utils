package rgo.wm.common.utils.validator;

public class UnknownValidator implements Validator<Object> {

    @Override
    public ValidationResult validate(Object object) {
        throw new UnknownValidatorException("The " + object.getClass() + " is not registered in the validator registry.");
    }

    @Override
    public Class<Object> getType() {
        return Object.class;
    }

    public static class UnknownValidatorException extends RuntimeException {

        public UnknownValidatorException(String message) {
            super(message);
        }
    }
}
