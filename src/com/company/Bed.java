package com.company;

public class Bed extends Furniture {
    private int numOfSleepingPlaces;

    public Bed(int numOfSleepingPlaces, String name, int numOfLegs, String soft) {
        this.numOfSleepingPlaces = numOfSleepingPlaces;
        this.name = name;
        this.numOfLegs = numOfLegs;
        this.soft = soft;
    }

    @Override
    public String getAll() {
        return super.getAll() + " " + this.numOfSleepingPlaces;
    }

    @Override
    public String toString() {
        return "Bed  " +
                ", name='" + name + '\'' +
                ", numOfLegs=" + numOfLegs +
                ", soft='" + soft + '\'' +
                ", numOfSleepingPlaces=" + numOfSleepingPlaces;

    }
}
