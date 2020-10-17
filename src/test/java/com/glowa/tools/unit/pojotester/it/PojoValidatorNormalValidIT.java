package com.glowa.tools.unit.pojotester.it;

import com.glowa.tools.unit.pojotester.ValidatorMode;

public class PojoValidatorNormalValidIT extends PojoValidatorEasyValidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.NORMAL;
    }
}
