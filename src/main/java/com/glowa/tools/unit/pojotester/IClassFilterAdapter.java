package com.glowa.tools.unit.pojotester;

import java.util.List;

public interface IClassFilterAdapter {

    List<String> getDefaultExcludedClazzes();

    Object getFilter();

}
