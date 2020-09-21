package com.openpojo.validation.affirm;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import com.openpojo.reflection.construct.InstanceFactory;
import com.openpojo.reflection.facade.FacadeFactory;

public class JUnitCollectorAffirmation implements Affirmation {

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    private final Affirmation affirmation;

    public JUnitCollectorAffirmation() {
        affirmation = (Affirmation) InstanceFactory
                .getInstance(FacadeFactory.getLoadedFacadePojoClass(new String[] { "com.openpojo.validation.affirm.JUnitAssertAffirmation" }));
    }

    @Override
    public void fail(String message) {
        collector.addError(new AssertionError(message));
    }

    @Override
    public void affirmTrue(String message, boolean condition) {
        affirmation.affirmTrue(message, condition);
    }

    @Override
    public void affirmFalse(String message, boolean condition) {
        affirmation.affirmFalse(message, condition);
    }

    @Override
    public void affirmNotNull(String message, Object object) {
        affirmation.affirmNotNull(message, object);
    }

    @Override
    public void affirmNull(String message, Object object) {
        affirmation.affirmNull(message, object);
    }

    @Override
    public void affirmEquals(String message, Object expected, Object actual) {
        affirmation.affirmEquals(message, expected, actual);
    }

    @Override
    public void affirmSame(String message, Object first, Object second) {
        affirmation.affirmSame(message, first, second);
    }
}
