package com.glowa_net.tools.unit.pojotester.it;

import com.glowa_net.tools.unit.pojotester.ValidatorMode;

public class PojoValidatorNormalValidIT extends PojoValidatorEasyValidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.NORMAL;
    }
}
