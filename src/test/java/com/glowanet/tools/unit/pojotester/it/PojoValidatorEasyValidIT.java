package com.glowanet.tools.unit.pojotester.it;

import com.glowanet.tools.unit.pojotester.ValidatorMode;
import com.glowanet.tools.unit.sample.valid.ValidSample;
import org.junit.Before;
import org.junit.Test;

public class PojoValidatorEasyValidIT extends AbstractTestSupport {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.EASY;
    }

    @Before
    public void setUp() {
        setValidator(prepareValidator(getValidatorMode()));
    }

    @Test
    public void testClazzIsValid() {
        Class<?> clazz2Validate = ValidSample.class;
        verifySuccess(clazz2Validate);
    }
}
