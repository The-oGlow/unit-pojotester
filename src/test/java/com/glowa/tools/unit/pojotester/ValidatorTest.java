package com.glowa.tools.unit.pojotester;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThrows;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import com.glowa.tools.unit.sample.invalid.NoGetterSample;
import com.glowa.tools.unit.sample.simple.SimpleSample;

public class ValidatorTest {

    private PojoValidator           o2T;
    private String              package2Test        = "com.glowa.tools.unit.sample.simple";
    private String              packageInvalid2Test = "com.glowa.tools.unit.sample.invalid";
    private Class<SimpleSample> clazz2Test          = SimpleSample.class;
    private Class<?>            clazzInvalid2Test   = NoGetterSample.class;
    private ValidatorMode       validatorMode       = ValidatorMode.COMPLEX;

    @Before
    public void setUp() throws Exception {
        this.o2T = new PojoValidator(validatorMode);
    }

    @Test
    public void testValidatorIsAnInstanceOfInterface() {
        assertThat(o2T, notNullValue());
        assertThat(o2T, Matchers.instanceOf(IPojoValidator.class));
    }

    @Test
    public void testValidateAndCollectWithoutException() {
        o2T.validateAndCollect(package2Test);
    }

    @Test
    public void testValidateAndCollectWithException() {
        o2T.validateAndCollect(packageInvalid2Test);
    }

    @Test
    public void testValidateAListOfClazzesWithoutException() {
        o2T.validate(package2Test);
    }

    @Test
    public void testValidateASingleClazzesWithoutException() {
        o2T.validate(clazz2Test);
    }

    @Test
    public void testValidateASingleClazzesWithException() {
        assertThrows(AssertionError.class, () -> o2T.validate(clazzInvalid2Test));
    }

}
