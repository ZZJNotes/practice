package com.leetcode;

import java.util.Stack;

/**
 * @Author zzj
 * @Date 2021/5/24 16:00
 * @Description 用两个栈实现队列
 */

public class MyQueue {

    private Stack<Integer> inStack ;
    private Stack<Integer> outStack ;

    MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int e) {
        inStack.push(e);
    }

    public int pop() throws Exception {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        if (outStack.isEmpty()) {
            throw new Exception("Your queue is empty!");
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        try {
            System.out.println(myQueue.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
