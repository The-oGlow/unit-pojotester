package com.glowanet.tools.unit.pojotester;

import java.util.Collection;

public interface IClassFinderAdapter {

    Object retrieveClass(Class<?> clazz);

    Collection<?> retrieveClasses(String packageName, IClassFilterAdapter clazzFilter);
}
