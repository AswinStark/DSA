package com.aswinstark.patterns.recursion;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombinationProblem {
    public static void main(String[] args) {
        KeyPad keyPad = new KeyPad();
        List<String> kayPadList = keyPad.getCombinations("123");
        kayPadList.stream().forEach(System.out::println);
        System.out.println("Total Count: "+ kayPadList.size());
    }
}

class KeyPad {
    String[] keyPad = {".", "abc", "def", "ghi", "jkl", "mnop", "qrst", "uvw", "xyz"};

    // 123 -> adg, a
    public List<String> getCombinations(String num) {

        if(num.length()==0){
            List<String> base = new ArrayList<String>();
            base.add("");
            return base;
        }
        char ch = num.charAt(0);
        String restOfKeyPadStroke = num.substring(1);
        List<String> recursionResult = getCombinations(restOfKeyPadStroke);
        List<String> myResult = new ArrayList<>();
        for (char c : keyPad[ch - '0'].toCharArray()) {
            for (String s : recursionResult) {
                myResult.add(c + s);
            }
        }
        return myResult;
    }
}
