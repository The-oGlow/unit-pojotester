package com.glowanet.tools.unit.pojotester.it;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThrows;

import org.hamcrest.Matchers;

import com.glowanet.tools.unit.pojotester.IPojoValidator;
import com.glowanet.tools.unit.pojotester.ValidatorFactory;
import com.glowanet.tools.unit.pojotester.ValidatorMode;

public abstract class AbstractTestSupport {

    private IPojoValidator validator;

    protected abstract ValidatorMode getValidatorMode();

    protected IPojoValidator getValidator() {
        return validator;
    }

    protected void setValidator(IPojoValidator validator) {
        this.validator = validator;
    }

    protected IPojoValidator prepareValidator(ValidatorMode validatorMode) {
        return ValidatorFactory.getInstance().createValidator(validatorMode);
    }

    protected void verifySuccess(Class<?> clazz2Validate) {
        validator.validate(clazz2Validate);
    }

    protected void verifyWithException(String expectMsg, Class<?> clazz2Validate) {
        Class<? extends Throwable> expectExc = AssertionError.class;
        verifyWithException(expectExc, expectMsg, clazz2Validate);
    }

    protected void verifyWithException(Class<? extends Throwable> expectExc, String expectMsg, Class<?> clazz2Validate) {
        Throwable actualExc = assertThrows(Throwable.class, () -> validator.validate(clazz2Validate));

        assertThat(actualExc, instanceOf(expectExc));
        assertThat(actualExc.getMessage(), Matchers.containsString(expectMsg));
    }

}
