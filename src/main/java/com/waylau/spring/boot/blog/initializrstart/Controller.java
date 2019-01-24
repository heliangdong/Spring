package com.waylau.spring.boot.blog.initializrstart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller

public class Controller {

    @RequestMapping("/hello")
    @ResponseBody

            String test(){
                    return "hello";
            }
}
