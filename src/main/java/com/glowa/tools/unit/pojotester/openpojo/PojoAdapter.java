package com.glowa.tools.unit.pojotester.openpojo;

import java.util.List;

import com.glowa.tools.unit.pojotester.IPojoValidatorAdapter;
import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.test.Tester;

public class PojoAdapter implements IPojoValidatorAdapter {

    private final Validator     validator;
    private final ValidatorMode validatorMode;

    public PojoAdapter(ValidatorMode validatorMode) {
        this.validatorMode = validatorMode;
        this.validator = prepareValidator( //
                (Rule[]) RuleFactory.getInstance().createConfig(this.validatorMode), //
                (Tester[]) TesterFactory.getInstance().createConfig(this.validatorMode) //
        );
    }

    @Override
    public void validate(Object clazzToValidate) {
        getValidator().validate((PojoClass) clazzToValidate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void validate(List<? extends Object> clazzesToValidate) {
        getValidator().validate((List<PojoClass>) clazzesToValidate);
    }

    protected Tester[] prepareTestersAdditional() {
        return new Tester[] {};
    }

    protected Rule[] prepareRulesAdditional() {
        return new Rule[] {};
    }

    public Validator getValidator() {
        return validator;
    }

    public ValidatorMode getValidatorMode() {
        return validatorMode;
    }

    protected Validator prepareValidator(Rule[] rules, Tester[] tester) {
        return ValidatorBuilder.create().with(rules).with(tester).build();
    }
}
