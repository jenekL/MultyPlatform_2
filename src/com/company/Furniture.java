package com.company;

import java.io.Serializable;

public abstract class Furniture implements Serializable {
    protected String name;
    protected int numOfLegs;
    protected String soft;

    public String getAll(){ return name + " " + numOfLegs + " " + soft; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public String isSoft() { return soft; }

    public void setSoft(String soft) { this.soft = soft; }
}
