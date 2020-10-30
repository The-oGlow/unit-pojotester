package com.glowanet.tools.unit.pojotester.it;

import org.junit.Ignore;
import org.junit.Test;

import com.glowanet.tools.unit.pojotester.ValidatorMode;
import com.glowanet.tools.unit.sample.invalid.SerializableEqualsNotExists;
import com.glowanet.tools.unit.sample.invalid.SerializableHashcodeNotExists;
import com.glowanet.tools.unit.sample.invalid.SerializableIsInvalid;
import com.glowanet.tools.unit.sample.invalid.SerializableNotExists;

public class PojoValidatorNormalInvalidIT extends PojoValidatorEasyInvalidIT {

    @Override
    protected ValidatorMode getValidatorMode() {
        return ValidatorMode.NORMAL;
    }

    @Test
    public void testSerializableNotExists() {
        Class<?> clazz2Validate = SerializableNotExists.class;
        String expectMsg = "No [serialVersionUID] field defined";

        verifyWithException(expectMsg, clazz2Validate);
    }

    @Test
    @Ignore("FIXME: check test")
    public void testSerializableIsInvalid() {
        Class<?> clazz2Validate = SerializableIsInvalid.class;
        String expectMsg = "getter";

        verifyWithException(expectMsg, clazz2Validate);
    }

    @Test
    public void testSerializableHashcodeNotExists() {
        Class<?> clazz2Validate = SerializableHashcodeNotExists.class;
        String expectMsg = "equals implemented but hashcode";

        verifyWithException(expectMsg, clazz2Validate);
    }

    @Test
    public void testSerializableEqualsNotExits() {
        Class<?> clazz2Validate = SerializableEqualsNotExists.class;
        String expectMsg = "hashCode implemented but equals";

        verifyWithException(expectMsg, clazz2Validate);
    }
}
