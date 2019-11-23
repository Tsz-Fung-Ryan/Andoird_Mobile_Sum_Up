package com.example.cps731_project.common;

public class Utilities {

    public int[] toIntArray(String[] numArray) {
        int[] intArray = new int[numArray.length];
        for(int i = 0; i < numArray.length; i++) {
            intArray[i] = Integer.parseInt(numArray[i]);
        }

        return intArray;
    }

    public char[] toCharArray(String[] stringArray) {
        char[] opArray = new char[stringArray.length];
        for(int i = 0; i < stringArray.length; i++) {
            opArray[i] = stringArray[i].charAt(0);
        }

        return opArray;
    }
}
