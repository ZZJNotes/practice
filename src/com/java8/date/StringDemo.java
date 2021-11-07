package com.java8.date;

/**
 * @Author zzj
 * @Date 2021/5/22 11:40
 * @Description
 */

public class StringDemo {

    public static void main(String[] args) {
        String a = new String("abc");
        String b = new String("abc");
        String c = "abc";
        String d = "abc";
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("a == b: " + (a == b));
        System.out.println("c == d: " + (c == d));

        System.out.println("a: " + System.identityHashCode(a));
        System.out.println("b: " + System.identityHashCode(b));
        System.out.println("c: " + System.identityHashCode(c));
        System.out.println("d: " + System.identityHashCode(d));

    }
}
