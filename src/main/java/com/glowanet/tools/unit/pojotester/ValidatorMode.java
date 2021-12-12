package com.glowanet.tools.unit.pojotester;

public enum ValidatorMode implements IPojoTesterCommon {

    EASY, NORMAL, COMPLEX, DEFAULT;

    @Override
    public ValidatorMode getValidatorMode() {
        return DEFAULT;
    }
}
