package com.example.self.normalpractice.rpc.step1;

import com.example.self.normalpractice.rpc.User;
import com.example.self.normalpractice.rpc.UserService;
import com.example.self.normalpractice.rpc.UserServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 10:32
 */
public class Server {
    private static boolean IS_RUNNING = true;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (IS_RUNNING){
            System.out.println("server等待client连接");
            Socket client = serverSocket.accept();
            System.out.println("server已经连接到client");

            handle(client);
            client.close();
        }
        serverSocket.close();
    }

    private static void handle(Socket client) throws Exception {
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        DataInputStream dis = new DataInputStream(inputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);

        // 从socket读取参数
        int num = dis.readInt();
        System.out.println("读取到的参数是"+num);

        // 从本地查询数据
        UserService userService = new UserServiceImpl();
        User user = userService.getUserById(num);

        // 给client写数据
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();

        dis.close();
        dis.close();

    }
}
