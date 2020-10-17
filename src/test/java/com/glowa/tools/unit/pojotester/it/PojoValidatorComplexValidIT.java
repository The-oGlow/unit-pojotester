package com.glowa.tools.unit.pojotester.it;

import com.glowa.tools.unit.pojotester.ValidatorMode;

public class PojoValidatorComplexValidIT extends PojoValidatorEasyValidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.COMPLEX;
    }
}
