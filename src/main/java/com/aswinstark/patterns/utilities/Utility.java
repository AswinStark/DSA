package com.aswinstark.patterns.utilities;

public class Utility {
    public static void outputSeparator(Character separator, int length){
        for (int i = 0; i < length; i++) {
            System.out.print(separator);
        }
        System.out.println();
    }
    public static void outputSeparator(Character separator){
        for (int i = 0; i < 70; i++) {
            System.out.print(separator);
        }
        System.out.println();
    }
}
