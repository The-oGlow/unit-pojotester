package com.glowanet.tools.unit.pojotester.it;

import com.glowanet.tools.unit.pojotester.ValidatorMode;

public class PojoValidatorComplexValidIT extends PojoValidatorEasyValidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.COMPLEX;
    }
}
