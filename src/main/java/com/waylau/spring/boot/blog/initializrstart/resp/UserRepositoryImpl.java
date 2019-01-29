package com.waylau.spring.boot.blog.initializrstart.resp;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@
public class UserRepositoryImpl     {
    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<Long, User>();


    public  UserRepositoryImpl(){
        User user=new User();
        user.setAge(18);
        user.setName("heliangdong");
        this.saveupdateuser(user);
    }


    public User saveupdateuser(User user) {
        Long id=user.getId();
        if(id<0){
            id=counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;

    }


    public List<User> listUser() {
        List<User> userList=new ArrayList<User>(this.userMap.values());
        return userList;
    }
}
