package com.glowa.tools.unit.pojotester.it;

import org.junit.Before;
import org.junit.Test;

import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.glowa.tools.unit.sample.invalid.NoGetterSample;
import com.glowa.tools.unit.sample.invalid.NoSetterSample;

public class PojoValidatorEasyInvalidIT extends AbstractTestSupport {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.EASY;
    }

    @Before
    public void setUp() {
        setValidator(prepareValidator(getValidatorMode()));
    }

    @Test
    public void testNoGetter() {
        Class<?> clazz2Validate = NoGetterSample.class;
        String expectMsg = "getter";

        verifyWithException(expectMsg, clazz2Validate);
    }

    @Test
    public void testNoSetter() {
        Class<?> clazz2Validate = NoSetterSample.class;
        String expectMsg = "setter";

        verifyWithException(expectMsg, clazz2Validate);
    }

}
