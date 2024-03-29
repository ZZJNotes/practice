package com.thread.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author zzj
 * @Date 2021/4/19 13:13
 * @Description
 */

public class BIOClient {
    private static Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String msg = scanner.nextLine();
        outputStream.write(msg.getBytes(StandardCharsets.UTF_8));//阻塞，写完成才会退出
        scanner.close();
        outputStream.close();

    }
}
