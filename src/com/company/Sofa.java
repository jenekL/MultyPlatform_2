package com.company;

public class Sofa extends Furniture {
    private int numPlacesForSeating;

    public Sofa(int numPlacesForSeating, String name, int numOfLegs, String soft) {
        this.numPlacesForSeating = numPlacesForSeating;
        this.name = name;
        this.numOfLegs = numOfLegs;
        this.soft = soft;
    }

    @Override
    public String getAll() {
        return super.getAll() + " " + this.numPlacesForSeating;
    }

    @Override
    public String toString() {
        return "Sofa " +
                ", name='" + name + '\'' +
                ", numOfLegs=" + numOfLegs +
                ", soft='" + soft + '\'' +
                ", numPlacesForSeating=" + numPlacesForSeating;
    }

}
