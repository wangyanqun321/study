package com.wyq.algorithm;

/**
 * @author 王艳群
 * @description Offer11
 * @date 2020/10/27
 */
public class Offer11 {

    public static void main(String[] args) {
        System.out.println(rotateArray(new int[]{2, 2, 2, 0, 1}));
    }

    public static int rotateArray(int[] arr) {

        if(arr.length == 1) {
            return arr[0];
        }

        for(int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return arr[i];
            }
        }
        return arr[0];
    }

}
