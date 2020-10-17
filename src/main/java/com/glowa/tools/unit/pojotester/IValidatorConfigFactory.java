package com.glowa.tools.unit.pojotester;

public interface IValidatorConfigFactory<T> extends IPojoTesterCommon {

    T[] createConfig(ValidatorMode validatorMode);

}
