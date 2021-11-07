package com.leetcode;

import java.time.LocalDate;

/**
 * @Author zj
 * @Date 2021/8/4 11:42
 * @Description
 */

public class FibDemo {

    public static int fib(int n) {
        if (n == 0)
        {
            return 0;
        }
        else if (n == 1)
        {
            return 1;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }


    }

    public static void main(String[] args) {
        System.out.println("f(0) = " + fib(0));
        System.out.println("f(1) = " + fib(1));
        System.out.println("f(2) = " + fib(2));
        System.out.println("f(3) = " + fib(3));
        System.out.println("f(5) = " + fib(5));
        System.out.println(LocalDate.now());
    }
}
