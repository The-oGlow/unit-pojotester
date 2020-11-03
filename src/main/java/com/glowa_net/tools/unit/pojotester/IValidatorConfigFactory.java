package com.glowa_net.tools.unit.pojotester;

public interface IValidatorConfigFactory<T> extends IPojoTesterCommon {

    T[] createConfig(ValidatorMode validatorMode);

}
