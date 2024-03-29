package com.glowanet.tools.unit.pojotester;

import com.glowanet.tools.unit.pojotester.openpojo.ClassFilterAdapter;
import com.glowanet.tools.unit.pojotester.openpojo.ClassFinderAdapter;
import com.glowanet.tools.unit.pojotester.openpojo.PojoAdapterFactory;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import java.util.Collection;

public class PojoValidator implements IPojoValidator {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private final ValidatorMode validatorMode;

    private IPojoValidatorAdapter validatorAdapter;
    private IClassFinderAdapter   clazzFinder;
    private IClassFilterAdapter   clazzFilter;

    PojoValidator(ValidatorMode validatorMode) {
        // FIXME: remove compile dependency
        this.validatorMode = validatorMode;
        this.validatorAdapter = PojoAdapterFactory.getInstance().createValidatorAdapter(validatorMode);
        this.clazzFinder = new ClassFinderAdapter();
        this.clazzFilter = new ClassFilterAdapter();
    }

    @Override
    public void validate(Class<?> clazz) {
        validateClazz(clazz);
    }

    @Override
    public void validate(String packageName) {
        validatePackage(packageName);
    }

    @Override
    public void validateAndCollect(String packageName) {
        try {
            validatePackage(packageName);
        } catch (Throwable e) {
            collector.addError(e);
        }
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return validatorMode;
    }

    protected void validateClazz(Class<?> clazz) {
        validatorAdapter.validate(clazz);
    }

    protected void validateClazzes(Collection<Class<?>> clazzes) {
        validatorAdapter.validate(clazzes);
    }

    protected void validatePackage(String packageName) {
        validatorAdapter.validate(clazzFinder.retrieveClasses(packageName, clazzFilter));
    }
}
