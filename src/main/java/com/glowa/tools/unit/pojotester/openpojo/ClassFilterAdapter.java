package com.glowa.tools.unit.pojotester.openpojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.glowa.tools.unit.pojotester.IClassFilterAdapter;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.filters.FilterSyntheticClasses;

public class ClassFilterAdapter implements IClassFilterAdapter {

    private static final List<String> DEFAULT_EXCLUDED_CLAZZES = new ArrayList<>(Arrays.asList( //
    ));

    @Override
    public List<String> getDefaultExcludedClazzes() {
        return DEFAULT_EXCLUDED_CLAZZES;
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
