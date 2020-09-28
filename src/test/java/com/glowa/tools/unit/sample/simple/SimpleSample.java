package com.glowa.tools.unit.sample.simple;

import java.util.List;

public class SimpleSample {

    private int                simpleNative;
    private String             simpleObject;
    private List<CharSequence> simpleCollectionObject;
    private char[]             simpleArrayNative;
    private Long[]             simpleArrayObject;

    public SimpleSample(int simpleNative, String simpleObject, List<CharSequence> simpleCollectionObject, char[] simpleArrayNative, Long[] simpleArrayObject) {
        this.simpleNative = simpleNative;
        this.simpleObject = simpleObject;
        this.simpleCollectionObject = simpleCollectionObject;
        this.simpleArrayNative = simpleArrayNative;
        this.simpleArrayObject = simpleArrayObject;
    }

    public int getSimpleNative() {
        return simpleNative;
    }

    public void setSimpleNative(int simpleNative) {
        this.simpleNative = simpleNative;
    }

    public String getSimpleObject() {
        return simpleObject;
    }

    public void setSimpleObject(String simpleObject) {
        this.simpleObject = simpleObject;
    }

    public List<CharSequence> getSimpleCollectionObject() {
        return simpleCollectionObject;
    }

    public void setSimpleCollectionObject(List<CharSequence> simpleCollectionObject) {
        this.simpleCollectionObject = simpleCollectionObject;
    }

    public char[] getSimpleArrayNative() {
        return simpleArrayNative;
    }

    public void setSimpleArrayNative(char[] simpleArrayNative) {
        this.simpleArrayNative = simpleArrayNative;
    }

    public Long[] getSimpleArrayObject() {
        return simpleArrayObject;
    }

    public void setSimpleArrayObject(Long[] simpleArrayObject) {
        this.simpleArrayObject = simpleArrayObject;
    }

}
