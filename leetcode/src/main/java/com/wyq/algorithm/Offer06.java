package com.wyq.algorithm;

import com.google.common.collect.Lists;

import java.util.Stack;

/**
 * @author 王艳群
 * @description Offer06
 * @date 2020/10/21
 */
public class Offer06 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1).setNext(new ListNode(2).setNext(new ListNode(3)));
        int[] ints = new Solution().reversePrint(head);
        System.out.println(Lists.newArrayList(ints));
    }

    static class Solution {

        public int[] reversePrint(ListNode head) {
            Stack<Integer> stack = new Stack<>();
            ListNode next = head;
            while (next != null) {
                stack.push( next.val);
                next = next.next;
            }
            int[] result = new int[stack.size()];
            int i = 0;
            while (!stack.empty()) {
                result[i] = stack.pop();
                i++;
            }
            return result;
        }
    }

    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode setNext(ListNode next) {
            this.next = next;
            return this;
        }
    }

}
