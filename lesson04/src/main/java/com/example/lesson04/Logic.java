package com.example.lesson04;

import java.util.Arrays;

public class Logic {
    public double[] arraySort(double[] array) {
        Arrays.sort(array);
        return array;
    }

    public String result(String s, double[] a) {
        return String.format("%s (%s)", s, Arrays.toString(a).replaceAll("^\\[|\\]$", ""));

    }
}
