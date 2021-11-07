package com.thread.demo;

/**
 * @Author zzj
 * @Date 2021/4/12 17:21
 * @Description  死锁
 *      死锁是指两个或两个以上的线程在执行过程中，因争夺资源而造成的互相等待的现象，
 *      在无外力作用的情况下，这些线程会一直互相等待而无法继续运行下去
 */

public class DeadLockDemo {
    public static Object resource1 = new Object();
    public static Object resource2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + " get resource1");
                System.out.println(Thread.currentThread() + " try to get resource2");
                try {
                    // 休眠1s是为了保证线程A在获取到resource2对应的锁钱让线程B抢占到CPU
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + " get resource 2");
                }

            }


        });

        Thread threadB = new Thread(() -> {

            synchronized (resource2) {
                System.out.println(Thread.currentThread() + " get resource2");
                System.out.println(Thread.currentThread() + " try to get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + " get resource 1");
                }

            }

        });

        System.out.println("启动线程");
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("线程结束");
    }
}
