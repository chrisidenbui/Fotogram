package com.fotogram.demo;


public class TestString {
    
    public static String capitalize(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }
    
    public static void main(String[] args) {
        String a = "RmiT SaI gOn";
        System.out.println(capitalize(a));
        
    }

}
