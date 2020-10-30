package com.glowanet.tools.unit.pojotester.it;

import com.glowanet.tools.unit.pojotester.ValidatorMode;

public class PojoValidatorNormalValidIT extends PojoValidatorEasyValidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.NORMAL;
    }
}
