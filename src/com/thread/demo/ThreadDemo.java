package com.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author zzj
 * @Date 2021/4/12 17:01
 * @Description 线程创建与运行
 *      Java中有三种线程创建方式，分别为
 *           实现Runnable接口的run方法
 *           继承Thread类并重写run的方法
 *           使用FutureTask方式
 */

public class ThreadDemo {

    //创建线程
    Thread thread1 = new Thread(()->{

    });

    // 继承Thread类并重写run方法
    public static class MyThread1 extends Thread{
        @Override
        public void run(){
            System.out.println(currentThread() + "I am MyThread1");
        }

    }

    // 实现Runnable 接口
    public static class Mythread2 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "I am Mythread2");
        }
    }

    // 实现Callable 接口,使用FutureTask
    public static class Mythread3 implements Callable{

        @Override
        public String call() throws Exception {
            return Thread.currentThread() + "I am Mythread3";
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Mythread2 mythread2 = new Mythread2();
        Mythread3 mythread3 = new Mythread3();
        System.out.println("启动线程");
        myThread1.start();
        new Thread(mythread2).start();
        FutureTask<String> futureTask = new FutureTask<>(new Mythread3());
        new Thread(futureTask).start();
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
