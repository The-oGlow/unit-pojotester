package com.glowa.tools.unit.pojotester;

import java.util.List;

public interface IPojoValidatorAdapter extends IPojoTesterCommon {

    void validate(List<? extends Object> clazzesToValidate);

    void validate(Object clazzToValidate);
}
