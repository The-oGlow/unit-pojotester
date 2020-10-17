package com.glowa.tools.unit.sample.invalid;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SerializableNotExists implements Serializable {

    private String simpleObject;

    public String getSimpleObject() {
        return simpleObject;
    }

    public void setSimpleObject(String simpleObject) {
        this.simpleObject = simpleObject;
    }

}
