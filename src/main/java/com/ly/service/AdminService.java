package com.ly.service;

import com.ly.dao.UserMapper;
import com.ly.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by liangyong on 2017/10/17.
 */
@Service
public class AdminService {

    public static String NAME="AdminService";

    @Value("${jdbc_url}")
    private String str;


    @Autowired
    private UserMapper userMapper;

    public AdminService() {
        System.out.println("super service");
    }

    public User login(User user) {

        User temp = userMapper.selectByName(user.getName());
        if (temp != null && temp.getPassword().equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    public boolean isExist(User user) {

        User temp = userMapper.selectByName(user.getName());
        if (temp != null && temp.getPassword().equals(user.getPassword())) {
            return true;
        }
        return false;
    }
}
