package com.glowanet.tools.unit.pojotester.openpojo;

import java.util.List;

import com.glowanet.tools.unit.pojotester.IClassFilterAdapter;
import com.glowanet.tools.unit.pojotester.IClassFinderAdapter;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;

public class ClassFinderAdapter implements IClassFinderAdapter {

    @Override
    public Object retrieveClass(Class<?> clazz) {
        return PojoClassFactory.getPojoClass(clazz);
    }

    @Override
    public List<? extends Object> retrieveClasses(String packageName, IClassFilterAdapter clazzFilter) {
        // Get all classes recursively under package
        return PojoClassFactory.getPojoClassesRecursively(packageName, (PojoClassFilter) clazzFilter.getFilter());
    }

}
