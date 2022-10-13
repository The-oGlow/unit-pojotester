package com.glowanet.tools.unit.pojotester.openpojo;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;

import java.util.List;

class FilterExplicitExcludedClasses implements PojoClassFilter {

    private final List<String> excludedClazzes;

    FilterExplicitExcludedClasses(List<String> excludedClazzes) {
        this.excludedClazzes = List.copyOf(excludedClazzes);
    }

    // true includes this class, false excludes it.
    @Override
    public boolean include(final PojoClass pojoClass) {
        return !isClazzExcluded(pojoClass);
    }

    private boolean isClazzExcluded(PojoClass pojoClass) {
        return excludedClazzes.contains(pojoClass.getName());
    }
}
