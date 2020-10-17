package com.glowa.tools.unit.pojotester.openpojo;

import com.glowa.tools.unit.pojotester.AbstractValidatorConfigFactory;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.NoNestedClassRule;
import com.openpojo.validation.rule.impl.NoPrimitivesRule;
import com.openpojo.validation.rule.impl.NoPublicFieldsExceptStaticFinalRule;
import com.openpojo.validation.rule.impl.NoStaticExceptFinalRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;

public class RuleFactory extends AbstractValidatorConfigFactory<Rule> {

    private static final RuleFactory INSTANCE = new RuleFactory();

    public static final RuleFactory getInstance() {
        return INSTANCE;
    }

    private RuleFactory() {
    }

    @Override
    protected Rule[] defineConfigDefault() {
        return defineConfigNormal();
    }

    @Override
    protected Rule[] defineConfigEasy() {
        Rule[] config = add2Config(null, prepareRulesGS());
        return config;
    }

    @Override
    protected Rule[] defineConfigNormal() {
        Rule[] config = add2Config(null, prepareRulesGS());
        config = add2Config(config, prepareRulesSerializable());
        config = add2Config(config, prepareRulesDeclaration());
        return config;
    }

    @Override
    protected Rule[] defineConfigComplex() {
        Rule[] config = add2Config(null, prepareRulesGS());
        config = add2Config(config, prepareRulesSerializable());
        config = add2Config(config, prepareRulesDeclaration());
        config = add2Config(config, prepareRulesStatic());
        config = add2Config(config, prepareRulesExtended());
        return config;
    }

    protected Rule[] prepareRulesGS() {
        return new Rule[] { //
                new SetterMustExistRule(), //
                new GetterMustExistRule() //
        };
    }

    protected Rule[] prepareRulesSerializable() {
        return new Rule[] { //
                new EqualsAndHashCodeMatchRule(), //
                new SerializableMustHaveSerialVersionUIDRule() //
        };
    }

    protected Rule[] prepareRulesDeclaration() {
        return new Rule[] { //
                new NoFieldShadowingRule(), //
                new TestClassMustBeProperlyNamedRule() //
        };
    }

    protected Rule[] prepareRulesStatic() {
        return new Rule[] { //
                new NoStaticExceptFinalRule(), //
                new NoPublicFieldsExceptStaticFinalRule() //
        };
    }

    protected Rule[] prepareRulesExtended() {
        return new Rule[] { //
                new NoPrimitivesRule(), //
                new NoNestedClassRule() //
        };
    }
}
