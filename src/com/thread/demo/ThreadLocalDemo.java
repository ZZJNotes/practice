package com.thread.demo;

/**
 * @Author zzj
 * @Date 2021/4/13 17:39
 * @Description ThreadLocal
 *      ThreadLocal 是 JDK包提供的，它提供了线程本地变量，也就是如果你创建了一个ThreadLocal变量，
 *      那么访问这个变量的每个线程都会有这个变量的一个本地副本。当多个线程操作这个变量时，实际操作的是
 *      自己本地内存里面的变量，从而避免了线程安全问题。创建一个TheadLocal变量后，每个线程都会复制一
 *      个变量到自己的本地内存
 */

public class ThreadLocalDemo {

    // 创建 ThreadLocal 变量
    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    // print
    static void print(String str) {
        System.out.println(str + ":" + localVariable.get());
        localVariable.remove();
    }

    public static void main(String[] args) {
        // 创建线程1
        Thread threadA = new Thread(() -> {
            localVariable.set("threadA local variable");
            print("threadA");
            System.out.println("threadA remove after" + ":" + localVariable.get());
        });
        // 创建线程B
        Thread threadB = new Thread(() -> {
            localVariable.set("threadB local variable");
            print("threadB");
            System.out.println("threadB remove after" + ":" + localVariable.get());
        });

        threadA.start();
        threadB.start();

    }
}
