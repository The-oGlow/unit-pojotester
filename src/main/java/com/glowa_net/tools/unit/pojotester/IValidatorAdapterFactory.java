package com.glowa_net.tools.unit.pojotester;

public interface IValidatorAdapterFactory extends IPojoTesterCommon {

    IPojoValidatorAdapter createValidatorAdapter(ValidatorMode validatorMode);

}
