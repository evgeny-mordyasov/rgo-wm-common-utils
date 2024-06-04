package rgo.wm.common.utils.validator;

import rgo.wm.common.utils.validator.rule.ValidationRule;

import java.util.List;

public class IntegerValidator extends AbstractValidator<Integer> {

    protected IntegerValidator(List<ValidationRule<Integer>> steps) {
        super(steps);
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }
}
