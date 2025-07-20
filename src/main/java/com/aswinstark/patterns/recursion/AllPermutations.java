package com.aswinstark.patterns.recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AllPermutations {
    public static void main(String[] args) {
        Permute p = new Permute();
        ArrayList<String> results = p.permutations("abc");
        results.stream().forEach(System.out::println);
    }
}

class Permute {
    public ArrayList<String> permutations(String query) {
        if(query.length()==0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = query.charAt(0);
        String remainingString = query.substring(1);
        ArrayList<String> rres = permutations(remainingString);

        ArrayList<String> myres = new ArrayList<>();
        for(String s: rres){
            myres.add(s);
            myres.add(ch+s);
        }
        return myres;
    }
}