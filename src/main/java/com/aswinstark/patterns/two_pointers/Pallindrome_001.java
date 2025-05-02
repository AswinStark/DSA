package com.aswinstark.patterns.two_pointers;

import com.aswinstark.patterns.utilities.Utility;

import java.util.Scanner;
import java.util.*;

public class Pallindrome_001 {

    public static boolean checkPallindrome(String s){
        int left = 0, right = s.length() - 1;

        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<right && Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {
                "A man, a plan, a canal: Panama",
                "race a car",
                "1A@2!3 23!2@a1",
                "No 'x' in Nixon",
                "12321"
                // ADD MORE TEST CASES HERE
        };
        Utility.outputSeparator('_', 80);
        for (int i = 0; i < testCases.length; i++) {
            if(checkPallindrome(testCases[i])){
                System.out.println(testCases[i] + " - IS Palindrome");
            }else{
                System.out.println(testCases[i] + " - IS NOT Palindrome");
            }
            Utility.outputSeparator('-', 80);
        }
    }
}