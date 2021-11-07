package com.jvm;

/**
 * @Author zzj
 * @Date 2021/7/5 10:01
 * @Description
 */

public class ClassLoaderView {
    public static void main(String[] args) throws ClassNotFoundException {
        // 加载核心类库的 BootStrap ClassLoader
        // 如果这个类是由 BootStrap ClassLoader 加载的，那么这个方法在这种实现中将返回null
        System.out.println("核心类库加载器："
            + ClassLoaderView.class.getClassLoader().loadClass("java.lang.String").getClassLoader());
        // 加载拓展类库的 Extension ClassLoader
        System.out.println("拓展类加载器："
            + ClassLoaderView.class.getClassLoader().loadClass("com.sun.nio.zipfs.ZipCoder").getClassLoader());
        // 加载应用程序的
        System.out.println("应用程序库加载器："
            + ClassLoaderView.class.getClassLoader());

    }
}
