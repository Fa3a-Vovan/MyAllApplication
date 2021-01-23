package com.example.lesson04;

import java.util.Arrays;

public class Logic {
    public int[] arraySort(int[] array) {
        Arrays.sort(array);
        return array;
    }

    public String result(String s, int[] a) {
        return s.concat(Arrays.toString(a).replaceAll("\\[", " (").replace(']', ')'));

    }
}
