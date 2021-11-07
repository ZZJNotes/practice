package com.java8.date;

/**
 * @Author zzj
 * @Date 2021/5/24 14:41
 * @Description
 */

public class MainTest {
    private int value;

    MainTest (int a) {
        value = a;
    }

    public static void main(String[] a) {
        MainTest mainTest = new MainTest(10);
        System.out.println(mainTest.value);
        int intA = 1;
        double doubleB = 1.0;
        System.out.println(intA + doubleB);
    }
}
