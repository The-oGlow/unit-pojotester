package com.glowa.tools.unit.pojotester;

public interface IValidatorConfigFactory extends IPojoTesterCommon {

    // FIXME Object typisieren
    Object[] createConfig(ValidatorMode validatorMode);

}
