package com.glowa.maven.tools.unit.pojotester;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.construct.InstanceFactory;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.filters.FilterSyntheticClasses;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.reflection.java.bytecode.ByteCodeFactory;
import com.openpojo.reflection.java.bytecode.asm.ASMDetector;
import com.openpojo.reflection.java.version.VersionFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.affirm.Affirmation;
import com.openpojo.validation.affirm.AffirmationFactory;
import com.openpojo.validation.affirm.JUnitCollectorAffirmation;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SerializableTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.test.impl.ToStringTester;

public class MultiPackageTest {

    @org.junit.Rule
    public ErrorCollector collector = new ErrorCollector();

    // The top level package for all classes to be tested
    private static final String DEFAULT_PACKAGE = "de.arvato.systems.nmvs.core.base";

    private static final List<String> DEFAULT_EXCLUDED_CLAZZES = new ArrayList<>(Arrays.asList( //
    ));

    private String          packageName;
    private List<PojoClass> pojoClasses;
    private Validator       validator;

    public MultiPackageTest() {
        this.packageName = DEFAULT_PACKAGE;
    }

    @Before
    public void setup() {
        pojoClasses = retrieveClazzes(packageName, prepareFilter());
    }

    @Test
    public void testGetterSetter() {
        validator = prepareValidator(null, prepareTestersGS());

        System.out.println(VersionFactory.getVersion("5.0.0"));
        System.out.println(ASMDetector.ASM_CLASS_NAME);
        System.out.println(ByteCodeFactory.ASM_MIN_VERSION);
        Affirmation affirm = AffirmationFactory.getInstance().getAffirmation();

        Affirmation affirm2 = (Affirmation) InstanceFactory.getInstance(PojoClassFactory.getPojoClass(JUnitCollectorAffirmation.class));
        AffirmationFactory.getInstance().setActiveAffirmation(affirm2);

        validate(validator, pojoClasses);
    }

    @Test
    public void validateGetterSetter() {
        validator = prepareValidator( //
                ArrayUtils.addAll(prepareRulesGS(), prepareRulesAdditional()), //
                ArrayUtils.addAll(prepareTestersGS(), prepareTestersAdditional() //
                ));
        validateAndCollect(validator, pojoClasses);
    }

    // Ge-/Setter

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    // Move to separate class

    protected void validateAndCollect(Validator validateCollector, List<PojoClass> clazzesToValidate) {
        try {
            validate(validateCollector, clazzesToValidate);
        } catch (Throwable e) {
            collector.addError(e);
        }
    }

    protected void validate(Validator validateCollector, List<PojoClass> clazzesToValidate) {
        validateCollector.validate(clazzesToValidate);
    }

    protected List<PojoClass> retrieveClazzes(String packageName, PojoClassFilter clazzFilter) {
        // Get all classes recursively under package
        return PojoClassFactory.getPojoClassesRecursively(packageName, clazzFilter);
    }

    protected Validator prepareValidator(Rule[] rules, Tester[] tester) {
        return ValidatorBuilder.create().with(rules).with(tester).build();
    }

    protected FilterChain prepareFilter() {
        // Define Filter
        return new FilterChain( //
                new FilterPackageInfo(), // exclude package-info
                new FilterSyntheticClasses(), // exclude synthetic classes
                new FilterExplicitExcludedClasses(DEFAULT_EXCLUDED_CLAZZES), // exclude specific classes
                new FilterTestClasses() //
        );
    }

    protected Rule[] prepareRulesGS() {
        // Define Rules
        return new Rule[] {  //
                new SetterMustExistRule(), //
                new GetterMustExistRule(),  //
        };
    }

    protected Tester[] prepareTestersGS() {
        // Define  Tester
        return new Tester[] { //
                new SetterTester(), //
                new GetterTester() //
        };
    }

    protected Rule[] prepareRulesAdditional() {
        // Define Rules
        return new Rule[] {  //
                new EqualsAndHashCodeMatchRule(), //
                new SerializableMustHaveSerialVersionUIDRule(), //
                new NoFieldShadowingRule(), //
                new TestClassMustBeProperlyNamedRule() //
                // new BusinessKeyMustExistRule() //
        };
    }

    protected Tester[] prepareTestersAdditional() {
        // Define  Tester
        return new Tester[] { //
                new SerializableTester(), //
                new ToStringTester() //
                // new BusinessIdentityTester() //
        };
    }

    public static class FilterExplicitExcludedClasses implements PojoClassFilter {

        private final List<String> excludedClazzes;

        FilterExplicitExcludedClasses(List<String> excludedClazzes) {
            this.excludedClazzes = excludedClazzes;
        }

        // true includes this class, false excludes it.
        @Override
        public boolean include(final PojoClass pojoClass) {
            return !isClazzExcluded(pojoClass);
        }

        private boolean isClazzExcluded(PojoClass pojoClass) {
            return excludedClazzes.contains(pojoClass.getName());
        }
    }

    private static class FilterTestClasses implements PojoClassFilter {

        @Override
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/");
        }
    }
}

