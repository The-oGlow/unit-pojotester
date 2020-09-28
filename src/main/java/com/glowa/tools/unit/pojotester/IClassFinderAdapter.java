package com.glowa.tools.unit.pojotester;

import java.util.List;

public interface IClassFinderAdapter {

    Object retrieveClass(Class<?> clazz);

    List<? extends Object> retrieveClasses(String packageName, IClassFilterAdapter clazzFilter);
}
