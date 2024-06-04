package rgo.wm.common.utils.validator.rule;

public interface ValidationRule<T> {

    ValidationRuleResult validate(T t);
}
