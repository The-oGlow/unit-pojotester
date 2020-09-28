package com.glowa.tools.unit.pojotester.openpojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.glowa.tools.unit.pojotester.IValidatorConfigFactory;
import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.openpojo.validation.rule.Rule;
import com.openpojo.validation.rule.impl.EqualsAndHashCodeMatchRule;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.NoFieldShadowingRule;
import com.openpojo.validation.rule.impl.SerializableMustHaveSerialVersionUIDRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.rule.impl.TestClassMustBeProperlyNamedRule;

public class RuleFactory implements IValidatorConfigFactory {

    private static final RuleFactory INSTANCE = new RuleFactory();

    public static final RuleFactory getInstance() {
        return INSTANCE;
    }

    private RuleFactory() {
    }

    @Override
    public Object[] createConfig(ValidatorMode validatorMode) {
        List<Rule> rules = new ArrayList<>();

        switch (validatorMode) {
        case NORMAL:
            rules.addAll(prepareRulesGS());
            rules.addAll(prepareRulesSerializable());
            break;
        case COMPLEX:
            rules.addAll(prepareRulesGS());
            rules.addAll(prepareRulesSerializable());
            rules.addAll(prepareRulesComplex());
            break;
        default:
            rules.addAll(prepareRulesGS());
            break;
        }
        return rules.toArray(new Rule[] {});
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return null;
    }

    protected List<Rule> prepareRulesGS() {
        return new ArrayList<>(Arrays.asList(new Rule[] { //
                new SetterMustExistRule(), //
                new GetterMustExistRule(), //
        }));
    }

    protected List<Rule> prepareRulesSerializable() {
        return new ArrayList<>(Arrays.asList(new Rule[] { //
                new EqualsAndHashCodeMatchRule(), //
                new SerializableMustHaveSerialVersionUIDRule(), //
        }));
    }

    protected List<Rule> prepareRulesComplex() {
        return new ArrayList<>(Arrays.asList(new Rule[] { //
                new NoFieldShadowingRule(), //
                new TestClassMustBeProperlyNamedRule() //
        }));
    }

}
