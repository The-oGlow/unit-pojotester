package com.glowa.tools.unit.pojotester.openpojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.glowa.tools.unit.pojotester.IValidatorConfigFactory;
import com.glowa.tools.unit.pojotester.ValidatorMode;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

public class TesterFactory implements IValidatorConfigFactory {

    private static final TesterFactory INSTANCE = new TesterFactory();

    public static final TesterFactory getInstance() {
        return INSTANCE;
    }

    private TesterFactory() {
    }

    @Override
    public ValidatorMode getValidatorMode() {
        return null;
    }

    @Override
    public Object[] createConfig(ValidatorMode validatorMode) {
        List<Tester> rules = new ArrayList<>();

        switch (validatorMode) {
        case NORMAL:
            rules.addAll(prepareTesterGS());
            rules.addAll(prepareTesterSerializable());
            break;
        case COMPLEX:
            rules.addAll(prepareTesterGS());
            rules.addAll(prepareTesterSerializable());
            rules.addAll(prepareTesterComplex());
            break;
        default:
            rules.addAll(prepareTesterGS());
            break;
        }
        return rules.toArray(new Tester[] {});
    }

    protected List<Tester> prepareTesterGS() {
        return new ArrayList<>(Arrays.asList(new Tester[] { //
                new SetterTester(), //
                new GetterTester() //
        }));
    }

    protected List<Tester> prepareTesterSerializable() {
        return new ArrayList<>(Arrays.asList(new Tester[] { //
        }));
    }

    protected List<Tester> prepareTesterComplex() {
        return new ArrayList<>(Arrays.asList(new Tester[] { //
        }));
    }

}
