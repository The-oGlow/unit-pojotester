package com.glowanet.tools.unit.sample.invalid;

import java.io.Serializable;
import java.util.Objects;

public class SerializableEqualsNotExists implements Serializable {

    private static final long serialVersionUID = -3757013091953944008L;

    private String            simpleObject;

    public String getSimpleObject() {
        return simpleObject;
    }

    public void setSimpleObject(String simpleObject) {
        this.simpleObject = simpleObject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(simpleObject);
    }

}
