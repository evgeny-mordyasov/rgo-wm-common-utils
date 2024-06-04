package rgo.wm.common.utils.validator;

public interface Validator<T> {

    ValidationResult validate(T t);

    Class<T> getType();
}
