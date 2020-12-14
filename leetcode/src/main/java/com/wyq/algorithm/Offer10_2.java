package com.wyq.algorithm;

/**
 * @author 王艳群
 * @description Offer10_2
 * @date 2020/10/27
 */
public class Offer10_2 {

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

    public static int numWays(int n) {
        if(n == 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }else {
            return numWays(n - 1) + numWays(n - 2);
        }
    }

}
