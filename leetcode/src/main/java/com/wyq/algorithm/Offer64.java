package com.wyq.algorithm;

/**
 * @author 王艳群
 * @description Offer64
 * @date 2020/10/21
 */
public class Offer64 {
    private static int sum = 0;
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int n) {
        boolean x = n > 1 && sum(n - 1) > 0;
        sum += n;
        return sum;
    }

}
