package com.glowanet.tools.unit.pojotester;

public interface IValidatorAdapterFactory extends IPojoTesterCommon {

    IPojoValidatorAdapter createValidatorAdapter(ValidatorMode validatorMode);

}
