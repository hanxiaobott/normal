package com.example.self.normalpractice.Thread;

/**
 * @description: 交替输出数字字母
 * @author: hanxiaobo
 * @create: 2021-04-28 10:02
 */
public class JiaoTiShuChuCas {

    private  static volatile Boolean flag = false;

    public static void main(String[] args) {

        new Thread(()->{
            for (int i = 1; i <= 26; i++) {
                while (flag){
                }
                System.out.print(i);
                flag = true;
            }
        }).start();

        new Thread(()->{
            for (int i = 1; i <= 26; i++) {
                while (!flag){

                }
                System.out.print((char)(i+64));
                flag = false;
            }
        }).start();
    }

//    public static class Flag{
//        private volatile Boolean flag = false;
//    }

}
