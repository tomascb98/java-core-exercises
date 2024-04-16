package com.epam.rd.autotasks.max;

public class MaxMethod {
    public static int max(int[] values) {
        int max = values[0];
        for (int num: values) {
            if(num>max) max=num;
        }
        return max;
    }
}
