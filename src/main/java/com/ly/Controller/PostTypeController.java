package com.ly.controller;

import com.ly.dao.PostTypeMapper;
import com.ly.pojo.PostType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cilu on 2017/10/26.
 */
@Controller
@RequestMapping("/postType")
public class PostTypeController {

    @Autowired
    private PostTypeMapper postTypeMapper;

    @ResponseBody
    @RequestMapping("/listAll")
    public List<PostType> listPostType() {
        return postTypeMapper.getAllPostType();
    }
}
