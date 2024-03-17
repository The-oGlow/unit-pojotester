package com.glowanet.tools.unit.pojotester.openpojo;

import com.glowanet.tools.unit.pojotester.AbstractValidatorConfigFactory;
import com.openpojo.validation.test.Tester;
import com.openpojo.validation.test.impl.DefaultValuesNullTester;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SerializableTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.openpojo.validation.test.impl.ToStringContentTester;

public class TesterFactory extends AbstractValidatorConfigFactory<Tester> {

    private static final TesterFactory INSTANCE = new TesterFactory();

    private TesterFactory() {
    }

    public static final TesterFactory getInstance() {
        return INSTANCE;
    }

    @Override
    protected Tester[] defineConfigDefault() {
        return defineConfigNormal();
    }

    @Override
    protected Tester[] defineConfigEasy() {
        return add2Config(null, prepareTesterGS());
    }

    @Override
    protected Tester[] defineConfigNormal() {
        Tester[] config = add2Config(null, prepareTesterGS());
        config = add2Config(config, prepareTesterSerializable());
        return config;
    }

    @Override
    protected Tester[] defineConfigComplex() {
        Tester[] config = add2Config(null, prepareTesterGS());
        config = add2Config(config, prepareTesterSerializable());
        config = add2Config(config, prepareTesterComplex());
        return config;
    }

    protected Tester[] prepareTesterGS() {
        return new Tester[]{ //
                new SetterTester(), //
                new GetterTester() //
        };
    }

    protected Tester[] prepareTesterSerializable() {
        return new Tester[]{ //
                new SerializableTester(true), //
                new ToStringContentTester() //
        };
    }

    protected Tester[] prepareTesterComplex() {
        return new Tester[]{ //
                new DefaultValuesNullTester() //
        };
    }
}
