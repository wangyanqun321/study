package com.wyq.algorithm;

import java.util.Queue;
import java.util.Stack;

/**
 * @author 王艳群
 * @description Offer
 * @date 2020/10/21
 */
public class Offer {

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(1);
        stackQueue.add(2);
        stackQueue.add(3);
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        stackQueue.add(4);
        stackQueue.add(5);
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
        System.out.println(stackQueue.poll());
    }


    static class StackQueue {
        Stack<Integer> in = new Stack<>();

        Stack<Integer> out = new Stack<>();

        public Integer poll() {
            if(out.empty()) {
                if(in.empty()) {
                    return null;
                }
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }

        public void add(Integer data) {
            in.push(data);
        }
    }

}
