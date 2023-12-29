package com.nicolas.demo.classes;

public class Util {
    public static String convertToUsablePath(String path){
        path = "\"" + path + "\"";
//        path.replace("/", "\\"); // Create a new variable
        return path;
    }
}
