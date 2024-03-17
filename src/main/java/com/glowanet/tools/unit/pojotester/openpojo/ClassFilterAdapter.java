package com.glowanet.tools.unit.pojotester.openpojo;

import com.glowanet.tools.unit.pojotester.IClassFilterAdapter;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.filters.FilterSyntheticClasses;

import java.util.ArrayList;
import java.util.List;

public class ClassFilterAdapter implements IClassFilterAdapter {

    @Override
    public List<String> getDefaultExcludedClazzes() {
        return new ArrayList<>();
    }

    @Override
    public Object getFilter() {
        return prepareFilter();
    }

    protected PojoClassFilter prepareFilter() {
        // Define Filter
        return new FilterChain( //
                new FilterPackageInfo(), // exclude package-info
                new FilterSyntheticClasses(), // exclude synthetic classes
                new FilterExplicitExcludedClasses(getDefaultExcludedClazzes()), // exclude specific classes
                new FilterTestClasses() //
        );
    }

}
