package com.example.self.normalpractice.rpc.step3;

import com.example.self.normalpractice.rpc.User;
import com.example.self.normalpractice.rpc.UserService;

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
        UserService stub = Stub.getStub();
        User user = stub.getUserById(1);
        System.out.println(user);
    }
}
