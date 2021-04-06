package com.example.self.normalpractice.rpc.step3;

import com.example.self.normalpractice.rpc.User;
import com.example.self.normalpractice.rpc.UserService;
import com.example.self.normalpractice.rpc.UserServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
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

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // 从socket读取参数
        String methodName = objectInputStream.readUTF();
        Object[] args = (Object[]) objectInputStream.readObject();
        Class[] parameterType = (Class[])objectInputStream.readObject();

        System.out.println("读取到的methodName是"+methodName);

        // 从本地查询数据
        UserService userService = new UserServiceImpl();
        Method method = userService.getClass().getMethod(methodName, parameterType);
        User result = (User)method.invoke(userService, args);

        // 给client写数据
        objectOutputStream.writeObject(result);
        objectOutputStream.flush();
        objectInputStream.close();
        objectOutputStream.close();

    }
}
