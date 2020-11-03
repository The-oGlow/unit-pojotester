package com.glowa_net.tools.unit.pojotester;

import org.apache.commons.lang3.ArrayUtils;

public abstract class AbstractValidatorConfigFactory<T> implements IValidatorConfigFactory<T> {

    private ValidatorMode lastMode;

    @Override
    public ValidatorMode getValidatorMode() {
        return lastMode;
    }

    @Override
    public T[] createConfig(ValidatorMode validatorMode) {
        T[] config = null;

        lastMode = validatorMode;

        switch (validatorMode) {
        case EASY:
            config = add2Config(config, defineConfigEasy());
            break;
        case NORMAL:
            config = add2Config(config, defineConfigNormal());
            break;
        case COMPLEX:
            config = add2Config(config, defineConfigComplex());
            break;
        default:
            config = add2Config(config, defineConfigDefault());
            break;
        }
        return config;
    }

    protected abstract T[] defineConfigDefault();

    protected abstract T[] defineConfigComplex();

    protected abstract T[] defineConfigEasy();

    protected abstract T[] defineConfigNormal();

    protected T[] add2Config(T[] config, T[] newConfig) {
        return ArrayUtils.addAll(config, newConfig);
    }
}
