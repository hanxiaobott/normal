package com.example.self.normalpractice.rpc.step3;

import com.example.self.normalpractice.rpc.User;
import com.example.self.normalpractice.rpc.UserService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 11:12
 */
public class Stub {

    public static UserService getStub() throws IOException {
        Object o = Proxy.newProxyInstance(UserService.class.getClassLoader(), new Class[]{UserService.class}, new NetInvocationHandler());
        return (UserService) o;
    }

    static class NetInvocationHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectOutputStream dataOutputStream = new ObjectOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(method.getName());
            Class<?>[] parameterTypes = method.getParameterTypes();
            dataOutputStream.writeObject(parameterTypes);
            dataOutputStream.writeObject(args);

            ObjectInputStream dataInputStream = new ObjectInputStream(socket.getInputStream());
            User user = (User)dataInputStream.readObject();
            System.out.println("client接受到了user:"+user);

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

            return user;
        }
    }

}
