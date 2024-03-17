package com.glowanet.tools.unit.pojotester;

import java.util.Collection;

public interface IClassFinderAdapter {

    Object retrieveClass(Class<?> clazz);

    @SuppressWarnings("java:S1452")
    Collection<?> retrieveClasses(String packageName, IClassFilterAdapter clazzFilter);
}
