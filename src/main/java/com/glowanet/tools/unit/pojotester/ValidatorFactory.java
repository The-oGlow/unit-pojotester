package com.glowanet.tools.unit.pojotester;

public class ValidatorFactory implements IPojoTesterCommon {

    private static final ValidatorFactory INSTANCE = new ValidatorFactory();

    private ValidatorFactory() {
    }

    public static ValidatorFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return ValidatorMode.DEFAULT;
    }

    public IPojoValidator createValidator(ValidatorMode validatorMode) {

        return new PojoValidator(validatorMode);
    }
}
