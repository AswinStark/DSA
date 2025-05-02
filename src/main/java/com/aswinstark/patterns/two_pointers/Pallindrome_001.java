package com.aswinstark.patterns.two_pointers;

import java.util.Scanner;
import java.util.*;

public class Pallindrome_001 {

    public static boolean checkPallindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
        };
    }
}