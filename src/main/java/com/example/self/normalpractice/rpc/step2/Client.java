package com.example.self.normalpractice.rpc.step2;

import com.example.self.normalpractice.rpc.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 10:32
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Stub stub = new Stub();
        User user = stub.getUser(1);
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
}
