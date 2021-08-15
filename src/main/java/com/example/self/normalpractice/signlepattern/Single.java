package com.example.self.normalpractice.signlepattern;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-04-28 15:41
 */
public class Single {

    private Single(){}

    private static volatile Single single;

    private static Single getSingle(){
        if(null == single){
            synchronized (Single.class){
                if(null == single){
                    single = new Single();
                }
            }
        }
        return single;
    }

}
