
package com.openpojo.validation.test.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoField;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;

/**
 * Tests, if all getter will be listed (except those, not needed) or not allowed
 * to be listed.
 *
 */
public class ToStringContentTester implements Tester {
    private static final String             SERIAL_VERSION_UID_NAME      = "serialVersionUID";
    private static final String             CLASS_NAME                   = "class";

    /**
     * Fieldnames in the class, which should be generally ignored on testing
     * {@link #toString()}.
     */
    private static final Collection<String> FIELDS_COMMON_IGNORE         = new HashSet<>(List.of(CLASS_NAME, SERIAL_VERSION_UID_NAME));
    private Collection<String>              allFieldsToIgnoreForToString = FIELDS_COMMON_IGNORE;

    @Override
    public void run(PojoClass pojoClass) {
        Object instance = RandomFactory.getRandomValue(pojoClass.getClazz());

        Collection<String> expectedFields = new ArrayList<String>();
        for (PojoField field : pojoClass.getPojoFields()) {
            if (!allFieldsToIgnoreForToString.contains(field.getName())) {
                expectedFields.add(field.getName());
            }
        }
        String actualString = instance.toString();
        Boolean actualResult = Arrays.stream(expectedFields.toArray(new String[] {})).allMatch(actualString::contains);

        Affirm.affirmTrue("Expected string mismatch '" + actualString + "', '" + expectedFields + "'", actualResult);
    }
}