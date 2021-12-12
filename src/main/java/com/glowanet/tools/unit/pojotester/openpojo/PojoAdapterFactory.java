package com.glowanet.tools.unit.pojotester.openpojo;

import com.glowanet.tools.unit.pojotester.IPojoValidatorAdapter;
import com.glowanet.tools.unit.pojotester.IValidatorAdapterFactory;
import com.glowanet.tools.unit.pojotester.ValidatorMode;

public class PojoAdapterFactory implements IValidatorAdapterFactory {

    private static final PojoAdapterFactory INSTANCE = new PojoAdapterFactory();

    public static PojoAdapterFactory getInstance() {
        return INSTANCE;
    }

    private PojoAdapterFactory() {
    }

    @Override
    public IPojoValidatorAdapter createValidatorAdapter(ValidatorMode validatorMode) {
        return new PojoAdapter(validatorMode);
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return null;
    }
}
