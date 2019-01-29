package com.waylau.spring.boot.blog.initializrstart.resp;

import com.waylau.spring.boot.blog.initializrstart.domain.User;

import java.util.List;

public interface UserRepository {



    /**
     * 获取所有用户的列表
     * @return
     */
    List<User> listUser();

    User saveupdateuser(User user);
}
