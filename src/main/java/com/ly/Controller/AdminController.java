package com.ly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liangyong on 2017/10/15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {


    public String login(){
        return "login";
    }
}
