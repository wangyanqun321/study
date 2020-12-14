package com.wyq.algorithm;

import org.junit.Test;

/**
 * @author 王艳群
 * @description Solution
 * @date 2020/7/27
 */
public class Solution {

    @Test
    public void isSubsequence() {
        String s = "abc";
        String t = "ahbgdc";
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.toCharArray()[i] == t.toCharArray()[j]) {
                i++;
            }
            j++;
        }
        //System.out.println(i == n);
    }

}
