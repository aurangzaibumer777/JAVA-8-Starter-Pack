package com.company.main;

/**
 * Created by VenD-Aurangzaib on 6/8/2018.
 */

public class Something {
    String startsWith(String word){
        return String.valueOf(word.charAt(0));
    }

    String endsWith(String word){
        return String.valueOf(word.charAt(word.length()-1));
    }

    public static boolean isCharExist(CharSequence charSequence, String value) {
        return (value.contains(charSequence));
    }

    public static int textLength(String s) {
        return s.length();
    }
}
