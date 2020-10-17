package com.glowa.tools.unit.pojotester.openpojo;

import java.util.Collection;
import java.util.List;

import com.glowa.tools.unit.pojotester.IPojoValidatorAdapter;
import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
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
    public void validate(Class<?> clazzToValidate) {
        getValidator().validate(preparePojoClass(clazzToValidate));
    }

    @Override
    public void validate(Collection<?> clazzesToValidate) {
        for (Object clazzToValidate : clazzesToValidate) {
            validate((Class<?>) clazzToValidate);
        }
    }

    @Override
    public void validate(String packageNameToValidate) {
        getValidator().validate(preparePojoClasses(packageNameToValidate));
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

    @Override
    public ValidatorMode getValidatorMode() {
        return validatorMode;
    }

    protected PojoClass preparePojoClass(Class<?> clazz) {
        return PojoClassFactory.getPojoClass(clazz);
    }

    protected List<PojoClass> preparePojoClasses(String packageName) {
        return PojoClassFactory.getPojoClasses(packageName);
    }

    protected Validator prepareValidator(Rule[] rules, Tester[] tester) {
        return ValidatorBuilder.create().with(rules).with(tester).build();
    }

}
