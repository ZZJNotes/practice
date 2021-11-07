package com.leetcode;

import java.util.Stack;

/**
 * @Author zzj
 * @Date 2021/5/7 9:56
 * @Description
 */

public class getMinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public getMinStack(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public Integer pop(Integer newNum) {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }

        return value;
    }

    public void push(Integer newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        }
        else if (newNum <= getMin()) {
            stackMin.push(newNum);
        }

    }

    public Integer getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is Empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        getMinStack getMinStack = new getMinStack();
        getMinStack.push(3);
        getMinStack.push(1);
        getMinStack.push(4);
        getMinStack.push(3);
        getMinStack.push(5);
        for (Integer i : getMinStack.stackData) {
            System.out.print(i + " ");
        }
        getMinStack.push(4);
        System.out.println();
        for (Integer i : getMinStack.stackData) {
            System.out.print(i + " ");
        }
        System.out.println();
        Integer min = getMinStack.getMin();
        System.out.println("min: " + min);
    }

}
