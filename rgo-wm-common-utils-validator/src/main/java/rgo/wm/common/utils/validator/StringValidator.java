package rgo.wm.common.utils.validator;

import rgo.wm.common.utils.validator.rule.ValidationRule;

import java.util.List;

public class StringValidator extends AbstractValidator<String> {

    public StringValidator(List<ValidationRule<String>> steps) {
        super(steps);
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }
}
