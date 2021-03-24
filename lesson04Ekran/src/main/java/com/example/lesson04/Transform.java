package com.example.lesson04;

import android.app.Dialog;

import java.util.Arrays;

public class Transform {
    public String[] stringSeparator(String inputText) {
        String[] strings = inputText.split(" \\(");
        strings[1] = strings[1].replaceAll("\\)", "");
        return strings;
    }


    public double[] stringToDoubleArray(String s) {
        String stringValues[] = s.split(",");
        double[] array = new double[stringValues.length];
        for (int i = 0; i < stringValues.length; i++) {
            array[i] = Double.parseDouble(stringValues[i]);
        }
        return array;
    }
}
