package com.glowa_net.tools.unit.sample.invalid;

import java.io.Serializable;
import java.util.Objects;

public class SerializableHashcodeNotExists implements Serializable {

    private static final long serialVersionUID = -3757013091953944008L;

    private String            simpleObject;

    public String getSimpleObject() {
        return simpleObject;
    }

    public void setSimpleObject(String simpleObject) {
        this.simpleObject = simpleObject;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SerializableHashcodeNotExists)) {
            return false;
        }
        SerializableHashcodeNotExists other = (SerializableHashcodeNotExists) obj;
        return Objects.equals(simpleObject, other.simpleObject);
    }

}
