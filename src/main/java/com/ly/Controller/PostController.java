package com.ly.controller;

import com.ly.dao.PostMapper;
import com.ly.dao.PostTypeMapper;
import com.ly.dao.UserMapper;
import com.ly.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

/**
 * Created by cilu on 2017/10/26.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostTypeMapper postTypeMapper;

    @RequestMapping("/save")
    public void save(Post post) {
        post.setPostTime(new Date(System.currentTimeMillis()));
        post.setPostType(postTypeMapper.selectByPrimaryKey(11));
        post.setUser(userMapper.selectByPrimaryKey(1));
        System.out.println(post);
        postMapper.insertSelective(post);
    }

    @RequestMapping("/{id}")
    public ModelAndView getPost(@PathVariable("id") int id) {

        Post post = postMapper.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("post", post);
        mav.addObject("blogLeft", "blogDetail.jsp");
        mav.setViewName("index");
        return mav;
    }
}
