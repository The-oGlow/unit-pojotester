package com.glowa.tools.unit.pojotester;

public class ValidatorFactory implements IPojoTesterCommon {

    private static final ValidatorFactory INSTANCE = new ValidatorFactory();

    private ValidatorFactory() {
    }

    public static ValidatorFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return null;
    }

    public IPojoValidator createValidator(ValidatorMode validatorMode) {

        IPojoValidator validator = new PojoValidator(validatorMode);
        return validator;
    }
}
