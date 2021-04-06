package com.example.self.normalpractice.rpc.step1;

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
        Socket socket = new Socket("127.0.0.1", 8888);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeInt(1);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        int id = dataInputStream.readInt();
        String name = dataInputStream.readUTF();
        System.out.println("client接受到了id:"+id);
        System.out.println("client接受到了name:"+name);

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
