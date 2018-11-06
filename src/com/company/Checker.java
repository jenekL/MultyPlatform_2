package com.company;

public class Checker {

    public static void checkString (String str) throws Exception {
        if(!str.matches("^\\D*$")) throw new Exception("There are numbers '" + str + "'");
    }
}