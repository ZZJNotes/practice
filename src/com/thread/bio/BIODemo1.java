package com.thread.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zzj
 * @Date 2021/4/19 13:07
 * @Description
 */

public class BIODemo1 {
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        // 绑定 8080 端口
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("tomcat 服务器启动成功");

        while (!serverSocket.isClosed()) {
            Socket request = serverSocket.accept();// 阻塞方法，如果没有连接，就一直等待在这一步
            System.out.println("收到新的连接：" + request.toString());
            threadPool.execute(() -> {
                try {
                    InputStream inputStream = request.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                    String msg;
                    while ((msg = reader.readLine()) != null) {
                        if (msg.length() == 0) {
                            break;
                        }
                        System.out.println(msg);
                    }
                    System.out.println("收到数据，来自：" + request.toString());

                    OutputStream outputStream = request.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-Length: 11\r\n\r\n".getBytes());
                    outputStream.write("Hello World".getBytes());
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        request.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
