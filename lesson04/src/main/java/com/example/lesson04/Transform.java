package com.example.lesson04;

import android.app.Dialog;

import java.util.Arrays;

public class Transform {
    public String[] stringSeparator(String inputText) {
        String[] strings = inputText.split(" ");
        strings[1] = strings[1].replaceAll("[()]", "");
        return strings;
    }


    public int[] array(String s) {
        String stringValues[] = s.split(",");
        int[] array = new int[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            array[i] = Integer.parseInt(stringValues[i]);
        }
        return array;
    }
}
