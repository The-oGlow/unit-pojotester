package com.glowa.tools.unit.pojotester.openpojo;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.glowa.tools.unit.pojotester.IClassFilterAdapter;
import com.glowa.tools.unit.pojotester.IPojoValidatorAdapter;
import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;

public class MultiPackageTest {

    @org.junit.Rule
    public ErrorCollector       collector       = new ErrorCollector();

    // The top level package for all classes to be tested
    private static final String DEFAULT_PACKAGE = "com.glowa.tools.unit.sample.simple";

//    private static final List<String> DEFAULT_EXCLUDED_CLAZZES = new ArrayList<>(Arrays.asList(     //
//    ));

    private String              packageName;
    private List<PojoClass>     pojoClasses;
    private IPojoValidatorAdapter   validator;

    public MultiPackageTest() {
        this.packageName = DEFAULT_PACKAGE;
    }

    @Before
    public void setup() {
        pojoClasses = (List<PojoClass>) new ClassFinderAdapter().retrieveClasses(packageName, new ClassFilterAdapter());
//        pojoClasses = retrieveClazzes(packageName, new ClassFilterAdapter());
    }

    @Test
    public void testGetterSetter() {
        validator = PojoAdapterFactory.getInstance().createValidatorAdapter(ValidatorMode.EASY);
//        validator = prepareValidator(null, prepareTestersGS());

//        System.out.println(VersionFactory.getVersion("5.0.0"));
//        System.out.println(ASMDetector.ASM_CLASS_NAME);
//        System.out.println(ByteCodeFactory.ASM_MIN_VERSION);
//        Affirmation affirm = AffirmationFactory.getInstance().getAffirmation();
//
//        Affirmation affirm2 = (Affirmation) InstanceFactory.getInstance(PojoClassFactory.getPojoClass(JUnitCollectorAffirmation.class));
//        AffirmationFactory.getInstance().setActiveAffirmation(affirm2);

        validate(validator, pojoClasses);
    }

    @Test
    public void validateGetterSetter() {
        validator = PojoAdapterFactory.getInstance().createValidatorAdapter(ValidatorMode.EASY);
//        validator = prepareValidator( //
//                ArrayUtils.addAll(prepareRulesGS(), prepareRulesAdditional()), //
//                ArrayUtils.addAll(prepareTestersGS(), prepareTestersAdditional() //
//                ));
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

    protected void validateAndCollect(IPojoValidatorAdapter validateCollector, List<PojoClass> clazzesToValidate) {
        try {
            validate(validateCollector, clazzesToValidate);
        } catch (Throwable e) {
            collector.addError(e);
        }
    }

    protected void validate(IPojoValidatorAdapter validateCollector, List<PojoClass> clazzesToValidate) {
        validateCollector.validate(clazzesToValidate);
    }

    protected List<PojoClass> retrieveClazzes(String packageName, IClassFilterAdapter clazzFilter) {
        // Get all classes recursively under package
        return PojoClassFactory.getPojoClassesRecursively(packageName, (PojoClassFilter) clazzFilter.getFilter());
    }

//    protected Validator prepareValidator(Rule[] rules, Tester[] tester) {
//        return ValidatorBuilder.create().with(rules).with(tester).build();
//    }

//    protected FilterChain prepareFilter() {
//        // Define Filter
//        return new FilterChain( //
//                new FilterPackageInfo(), // exclude package-info
//                new FilterSyntheticClasses(), // exclude synthetic classes
//                new FilterExplicitExcludedClasses(DEFAULT_EXCLUDED_CLAZZES), // exclude specific classes
//                new FilterTestClasses() //
//        );
//    }

//    protected Rule[] prepareRulesGS() {
//        // Define Rules
//        return new Rule[] { //
//                new SetterMustExistRule(), //
//                new GetterMustExistRule(), //
//        };
//    }
//
//    protected Tester[] prepareTestersGS() {
//        // Define Tester
//        return new Tester[] { //
//                new SetterTester(), //
//                new GetterTester() //
//        };
//    }
//
//    protected Rule[] prepareRulesAdditional() {
//        // Define Rules
//        return new Rule[] { //
//                new EqualsAndHashCodeMatchRule(), //
//                new SerializableMustHaveSerialVersionUIDRule(), //
//                new NoFieldShadowingRule(), //
//                new TestClassMustBeProperlyNamedRule() //
//                // new BusinessKeyMustExistRule() //
//        };
//    }
//
//    protected Tester[] prepareTestersAdditional() {
//        // Define Tester
//        return new Tester[] { //
//                new SerializableTester(), //
//                new ToStringTester() //
//                // new BusinessIdentityTester() //
//        };
//    }

//    public static class FilterExplicitExcludedClasses implements PojoClassFilter {
//
//        private final List<String> excludedClazzes;
//
//        FilterExplicitExcludedClasses(List<String> excludedClazzes) {
//            this.excludedClazzes = excludedClazzes;
//        }
//
//        // true includes this class, false excludes it.
//        @Override
//        public boolean include(final PojoClass pojoClass) {
//            return !isClazzExcluded(pojoClass);
//        }
//
//        private boolean isClazzExcluded(PojoClass pojoClass) {
//            return excludedClazzes.contains(pojoClass.getName());
//        }
//    }
//
//    private static class FilterTestClasses implements PojoClassFilter {
//
//        @Override
//        public boolean include(PojoClass pojoClass) {
//            return !pojoClass.getSourcePath().contains("/test-classes/");
//        }
//    }
}
