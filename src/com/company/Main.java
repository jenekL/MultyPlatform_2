package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Furniture> furnitureArrayList = new ArrayList<>();
        Logger logs = Logger.getInstance();
        Handler h = new Handler();
        h.doSmth(furnitureArrayList);

//        try {
//            System.in.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}