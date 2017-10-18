package com.ly.controller;

import com.ly.dao.PostMapper;
import com.ly.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liangyong on 2017/10/11.
 */
@Controller
public class IndexController {

    @Autowired
    private PostMapper postMapper;
    @RequestMapping("/index")
    public ModelAndView index(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("typeId",6);
        map.put("start",0);
        map.put("end",10);
        List<Post> postList = postMapper.listPost(map);
        System.out.println(postList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("postList",postList);
        mav.setViewName("index");
        return mav;
    }
}
