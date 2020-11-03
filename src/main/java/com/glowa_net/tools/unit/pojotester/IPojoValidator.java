package com.glowa_net.tools.unit.pojotester;

public interface IPojoValidator extends IPojoTesterCommon {

    void validate(Class<?> clazz);

    void validate(String packageName);

    void validateAndCollect(String packageName);
}
