package com.wyq.algorithm;

/**
 * @author 王艳群
 * @description Offer10_1
 * @date 2020/10/27
 */
public class Offer10_1 {

    public static void main(String[] args) {
        System.out.println(fibonacci(4));
    }

    public static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
