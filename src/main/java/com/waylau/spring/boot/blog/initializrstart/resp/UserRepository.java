package com.waylau.spring.boot.blog.initializrstart.resp;

import com.waylau.spring.boot.blog.initializrstart.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {




}
