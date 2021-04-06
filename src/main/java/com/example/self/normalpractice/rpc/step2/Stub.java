package com.example.self.normalpractice.rpc.step2;

import com.example.self.normalpractice.rpc.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 11:12
 */
public class Stub {

    public User getUser(int age) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeInt(age);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int id = dataInputStream.readInt();
        String name = dataInputStream.readUTF();
        System.out.println("client接受到了id:"+id);
        System.out.println("client接受到了name:"+name);

        User user = new User();
        user.setId(id);
        user.setName(name);

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

        return user;
    }

}
