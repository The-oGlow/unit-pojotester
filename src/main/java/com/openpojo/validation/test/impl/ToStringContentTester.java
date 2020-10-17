
package com.openpojo.validation.test.impl;

import com.openpojo.business.identity.IdentityFactory;
import com.openpojo.random.RandomFactory;
import com.openpojo.reflection.PojoClass;
import com.openpojo.validation.affirm.Affirm;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.utils.IdentityHandlerStub;

public class ToStringContentTester implements Tester {

    @Override
    public void run(PojoClass pojoClass) {
        Object instance = RandomFactory.getRandomValue(pojoClass.getClazz());

        IdentityHandlerStub identityHandlerStub = new IdentityHandlerStub(instance);
        identityHandlerStub.setToStringReturn(RandomFactory.getRandomValue(String.class));

        IdentityFactory.registerIdentityHandler(identityHandlerStub);

        Affirm.affirmEquals("Expected string mismatch", identityHandlerStub.getToStringReturn(), instance.toString());
    }
}
