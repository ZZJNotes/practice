package com.alitest;

import java.util.ArrayList;
import java.util.concurrent.Executors;

/**
 * @Author zj
 * @Date 2021/10/20 17:01
 * @Description
 */

public class CircularArrayFIFOQueue implements Queue{
    /**
     3	* 环形数组⼤⼩上限
     4	*/
    private static final int MAX_ARRAY_SIZE =65536;
    /**
     8	* 环形数组，存放队列元素
     9	*/
    private Object[] items;

    /**
     13	* 队列头部（在items中）的下标
     14	*/
    private int front;

    /**
     18	* 队列尾部（在items中）的下标
     19	*/
    private int rear;

    /**
     * 带参数的构造函数，输⼊参数为队列初始化的⼤⼩。此处约定队列⻓度不得超过初始化的⻓度。初始化时，rear应指向front的“前”⼀元素。
     * @param initQueueSize 队列中最多可容纳的元素数量
     */
    public CircularArrayFIFOQueue(int initQueueSize) {
        if (initQueueSize + 1 <= 0) {
            throw new RuntimeException("初始化容量不能为空");
        } else if (initQueueSize + 1 > MAX_ARRAY_SIZE) {
            throw new RuntimeException("初始化容量超过");
        }
        items = new Object[initQueueSize + 1];
        front = 0;
        rear = items.length - 1;
    }

    @Override
    public boolean enqueue(Object o) {
        if ((rear + 2) % items.length != front) {
            rear = (rear + 1) % items.length;
            items[rear] = o;
            return true;
        }

        return false;
    }

    @Override
    public Object dequeue() {
        if ((rear + 1) % items.length == front) {
            throw new RuntimeException("队列为空");
        }
        Object result = items[front];
        front = (front + 1) % items.length;
        return result;
    }

    @Override
    public int size() {

        return ((rear + 1 + items.length - front) % items.length);
    }

    public static void main(String[] args) {
        CircularArrayFIFOQueue queue = new CircularArrayFIFOQueue(12);
        System.out.println(queue.items.length);
        System.out.println("size:" + queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("size:" + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("size:" + queue.size());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("size:" + queue.size());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        queue.enqueue(11);
        System.out.println("size:" + queue.size());
        System.out.println(queue.enqueue(12));
        System.out.println(queue.enqueue(13));

        Executors.newCachedThreadPool();
    }
}
