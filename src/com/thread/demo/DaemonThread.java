package com.thread.demo;

/**
 * @Author zzj
 * @Date 2021/4/13 17:31
 * @Description 守护线程 和 用户线程
 *      在用户线程还存在的情况下JVM进程并不会终止，
 *      JVM发现当前没有用户线程的时候，即使还存在正在执行任务的守护线程，JVM不等守护线程运行完毕就会终止JVM进程
 *      当父线程结束后，子线程还是可以继续存在的，也就是子线程的生命周期并不受父线程的影响
 */

public class DaemonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            // 无限循环
            for (;;) {

            }
        });

        // 1. 用户线程
//        thread.start();
//        System.out.println("main thread is over");

        // 2. 守护线程
        // 将线程设为守护线程
        thread.setDaemon(true);
        thread.start();
        System.out.println("main thread is over");
    }
}
