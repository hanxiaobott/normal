package com.example.self.normalpractice.circle;

import com.example.self.normalpractice.ThreadLoacl.ContextEnv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @author: hanxiaobo
 * @create: 2021-05-14 16:27
 */
@Controller
public class TestController {

    @Autowired
    private MyCircle myCircle;

    @GetMapping("/api/test/test")
    public void test(){
        ContextEnv.email.set("EMAIL");
        ContextEnv.tel.set("333");
    }

}
