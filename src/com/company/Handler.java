package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Handler {

    //private ArrayList<Furniture> furnitureArrayList = new ArrayList<>();

    public void doSmth(ArrayList<Furniture> furnitureArrayList) {

        FileRW.readInfo("C:/Users/Tom/Desktop/Laba2/Furniture.csv", furnitureArrayList);
        for(Furniture f: furnitureArrayList){
            System.out.println(f.toString());
        }
        try {
            FileRW.serializationToFile("C:/Users/Tom/Desktop/Laba2/fff.txt", furnitureArrayList);
            FileRW.deserializationFromFile("C:/Users/Tom/Desktop/Laba2/fff.txt", furnitureArrayList.size());

//            fileRW.surDis("C:/Users/Tom/Desktop/Laba2/fff.txt", furnitureArrayList);
        } catch (IOException e) {
            Logger.addLog(e.getMessage());
            e.printStackTrace();
        }
    }
}
