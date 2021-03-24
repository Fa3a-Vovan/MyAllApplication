package com.example.lesson07kr.sort;

import java.util.Arrays;

public class LogicSort {
    public double[] arraySort(double[] array) {
        Arrays.sort(array);
        return array;
    }

    public String result(String s, double[] a) {
        return String.format("%s (%s)", s, Arrays.toString(a).replaceAll("^\\[|\\]$", ""));

    }
}
