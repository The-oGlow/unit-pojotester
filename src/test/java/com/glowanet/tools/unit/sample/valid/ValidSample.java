package com.glowanet.tools.unit.sample.valid;

import java.io.Serializable;
import java.util.Objects;

public class ValidSample implements Serializable {

    private static final long serialVersionUID = 863429336010118674L;

    private String            privateField;

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    @Override
    public int hashCode() {
        return Objects.hash(privateField);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidSample)) {
            return false;
        }
        ValidSample other = (ValidSample) obj;
        return Objects.equals(privateField, other.privateField);
    }

    @Override
    public String toString() {
        return "ValidSample [privateField=" + privateField + "]";
    }

}
