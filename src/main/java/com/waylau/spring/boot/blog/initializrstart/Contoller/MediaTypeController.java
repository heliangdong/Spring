package com.waylau.spring.boot.blog.initializrstart.Contoller;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;

public class MediaTypeController {
    /**
     * 根据客户端请求的 Content-Type，响应相应的 UserVO 类型.
     *
     * @return
     */
    @RequestMapping("/user")
    public User getUser() {
        return new User("waylau", 30);
    }
}
