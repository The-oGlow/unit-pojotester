package com.glowanet.tools.unit.pojotester;

import java.util.Collection;

public interface IPojoValidatorAdapter extends IPojoTesterCommon {

    // FIXME: Think about this method again
    void validate(String packageNameToValidate);

    void validate(Collection<?> clazzesToValidate);

    void validate(Class<?> clazzToValidate);
}
