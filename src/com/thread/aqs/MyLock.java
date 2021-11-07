package com.thread.aqs;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author zzj
 * @Date 2021/4/22 11:24
 * @Description
 */

public class MyLock implements Lock {
    // 如何判断一个锁的状态或者 拥有者
    volatile AtomicReference<Thread> owner = new AtomicReference<>();
    // 保存 正在等待的线程
    volatile LinkedBlockingDeque<Thread> waiters = new LinkedBlockingDeque<>();

    @Override
    public void lock() {
        boolean addQ = true;
        while (!tryLock()) {
            if (addQ) {
               // 进入等待
               waiters.offer(Thread.currentThread());
               addQ = false;
            } else {
                // 阻塞 挂起当前的线程，不要继续往下跑了
                LockSupport.park(); // 伪唤醒，就是非unpark唤醒的
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return owner.compareAndSet(null, Thread.currentThread());
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
