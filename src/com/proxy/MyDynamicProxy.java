package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.*;

/**
 * @Author zj
 * @Date 2021/10/19 19:50
 * @Description
 */

public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(hello);
        // 构造代码实例
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), myInvocationHandler);
        proxyHello.sayHello();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 3, 222, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    }
}

interface Hello {
    void sayHello();
}

class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;
    public MyInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        System.out.println("after sayHello");
        return result;
    }
}
