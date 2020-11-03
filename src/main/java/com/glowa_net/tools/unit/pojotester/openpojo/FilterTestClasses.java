package com.glowa_net.tools.unit.pojotester.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

class FilterTestClasses implements PojoClassFilter {

    @Override
    public boolean include(PojoClass pojoClass) {
        return !pojoClass.getSourcePath().contains("/test-classes/");
    }
}
