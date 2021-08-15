package com.example.self.normalpractice.proxy;

import com.example.self.normalpractice.rpc.UserService;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-01-22 15:01
 */
public class ProxyGenerator {

    private static final String PROXY_CLASS_NAME = "proxy";

    private static final String ENTER = "\n";

    private static final String TAB = "\t";

    /**
     * 生成接口实现类的源代码, 并持久化到java文件
     * @param interface_
     * @param proxyJavaFileDir
     * @throws Exception
     */
    private static void generateJavaFile(Class<?> interface_, String proxyJavaFileDir) throws Exception {
        StringBuilder proxyJava = new StringBuilder();
        proxyJava.append("package ").append(interface_.getPackage().getName()).append(";").append(ENTER).append(ENTER)
                .append("public class ").append(PROXY_CLASS_NAME).append(" implements ").append(interface_.getName()).append(" {");
        Method[] methods = interface_.getMethods();
        for(Method method : methods) {
            Type returnType = method.getGenericReturnType();
            Type[] paramTypes = method.getGenericParameterTypes();
            proxyJava.append(ENTER).append(ENTER).append(TAB).append("@Override").append(ENTER)
                    .append(TAB).append("public ").append(returnType.getTypeName()).append(" ").append(method.getName()).append("(");
            for(int i=0; i<paramTypes.length; i++) {
                if (i != 0) {
                    proxyJava.append(", ");
                }
                proxyJava.append(paramTypes[i].getTypeName()).append(" param").append(i);
            }
            proxyJava.append(") {").append(ENTER)
                    .append(TAB).append(TAB)
                    .append("System.out.println(\"数据库操作, 并获取执行结果...\");").append(ENTER); // 真正数据库操作，会有返回值，下面的return返回应该是此返回值
            if (!"void".equals(returnType.getTypeName())) {
                proxyJava.append(TAB).append(TAB).append("return null;").append(ENTER);      // 这里的"null"应该是上述中操作数据库后的返回值，为了演示写成了null
            }
            proxyJava.append(TAB).append("}").append(ENTER);
        }
        proxyJava .append("}");

        // 写入文件
        File f = new File(proxyJavaFileDir + PROXY_CLASS_NAME + ".java");
        FileWriter fw = new FileWriter(f);
        fw.write(proxyJava.toString());
        fw.flush();
        fw.close();
    }

    /**
     * 用JavaPoet生成接口实现类的源代码,并持久化到java文件(javapoe实现动态代理)
     * @param interface_ 目标接口类
     * @return
     */
//    public static void generateJavaFileByJavaPoet(Class<?> interface_) throws Exception {
//
//        // 类名、实现的接口，以及类访问限定符
//        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("JavaPoet$Proxy0")
//                .addSuperinterface(interface_)
//                .addModifiers(Modifier.PUBLIC);
//
//        Method[] methods = interface_.getDeclaredMethods();
//        for (Method method : methods) {
//
//            // 方法参数列表
//            List<ParameterSpec> paramList = new ArrayList<>();
//            Type[] paramTypes = method.getGenericParameterTypes();
//            int count = 1 ;
//            for (Type param : paramTypes) {
//                ParameterSpec paramSpec = ParameterSpec.builder(Class.forName(param.getTypeName()), "param" + count)
//                        .build();
//                count ++;
//                paramList.add(paramSpec);
//            }
//
//            // 方法名、方法访问限定符、参数列表、返回值、方法体等
//            Class<?> returnType = method.getReturnType();
//            MethodSpec.Builder builder = MethodSpec.methodBuilder(method.getName())
//                    .addModifiers(Modifier.PUBLIC)
//                    .addParameters(paramList)
//                    .addAnnotation(Override.class)
//                    .returns(returnType)
//                    .addCode("\n")
//                    .addStatement("$T.out.println(\"数据库操作, 并获取执行结果...\")", System.class)    // 真正数据库操作，会有返回值，下面的return返回应该是此返回值
//                    .addCode("\n");
//            if (!"void".equals(returnType.getName())) {
//                builder.addStatement("return null");       // 这里的"null"应该是上述中操作数据库后的返回值，为了演示写成了null
//            }
//
//            MethodSpec methodSpec = builder.build();
//            typeSpecBuilder.addMethod(methodSpec);
//
//        }
//
//        JavaFile javaFile = JavaFile.builder(interface_.getPackage().getName(), typeSpecBuilder.build()).build();
//        javaFile.writeTo(new File(SRC_JAVA_PATH));
//    }

    public static void main(String[] args) throws Exception {
        generateJavaFile(UserService.class,"/Users/hanxiaobo/Downloads/normal-practice/src/main/java/com/example/self/normalpractice/rpc/");
    }
}
