package com.example.self.normalpractice.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-21 16:21
 */
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader classLoader = new ClassLoader(){
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                synchronized (getClassLoadingLock(name)) {
                    // First, check if the class has already been loaded
                    Class<?> c = findClass(name);
                    if(c != null) {
                        if (resolve) {
                            resolveClass(c);
                        }
                    }else{
                        System.out.println("系统加载"+name);
                        c = getClass().getClassLoader().loadClass(name);
                    }
                    return c;
                }
            }

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                Class log = null;
                // 获取该class文件字节码数组
                byte[] classData = getData(name);

                if (classData != null) {
                    // 将class的字节码数组转换成Class类的实例
                    log = defineClass(name, classData, 0, classData.length);
                }
                return log;
            }

            private byte[] getData(String name) {
                String path = name.replace('.', '/').concat(".class");
                String path1 = this.getResource("").getPath();
                path = path1 + path;
                File file = new File(path);
                if (file.exists()) {
                    FileInputStream in = null;
                    ByteArrayOutputStream out = null;
                    try {
                        in = new FileInputStream(file);
                        out = new ByteArrayOutputStream();

                        byte[] buffer = new byte[1024];
                        int size = 0;
                        while ((size = in.read(buffer)) != -1) {
                            out.write(buffer, 0, size);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            in.close();
                        } catch (IOException e) {

                            e.printStackTrace();
                        }
                    }
                    return out.toByteArray();
                } else {
                    return null;
                }


            }

        };
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        System.out.println(aClass.getClassLoader());
    }
}
