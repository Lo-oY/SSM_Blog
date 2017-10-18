package com.ly.service;

import com.ly.dao.UserMapper;
import com.ly.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liangyong on 2017/10/17.
 */
@Service
public class AdminService {


    @Autowired
    private UserMapper userMapper;

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
