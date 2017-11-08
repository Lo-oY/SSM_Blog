package com.ly.controller;

import com.ly.dao.CommentMapper;
import com.ly.dao.PostMapper;
import com.ly.dao.PostTypeMapper;
import com.ly.dao.UserMapper;
import com.ly.pojo.Comment;
import com.ly.pojo.Post;
import com.ly.util.PageUtils;
import com.ly.util.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private CommentMapper commentMapper;

    @RequestMapping("/save")
    public void save(Post post) {
        post.setPostTime(new Date(System.currentTimeMillis()));
        post.setPostType(postTypeMapper.selectByPrimaryKey(11));
        post.setUser(userMapper.selectByPrimaryKey(1));
        System.out.println(post);
        postMapper.insertSelective(post);
    }

    @RequestMapping("/{id}")
    public ModelAndView getPost(@PathVariable("id") Integer id, HttpServletRequest request) {

        Post post = postMapper.selectByPrimaryKey(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("post", post);
        mav.addObject("blogLeft", "blogDetail.jsp");
        mav.addObject("pageCode", PageUtils.getPreAndNext(postMapper.getPrevBlog(id), postMapper.getNextBlog(id), "/"));
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/saveComment")
    public ResponseDto saveComment(String content, String imageCode, int postId, HttpSession session, HttpServletRequest request) {

        ResponseDto dto = new ResponseDto();
        if (session.getAttribute("sRand").equals(imageCode)) {
            Comment comment = new Comment();
            comment.setCommentDate(new Date(System.currentTimeMillis()));
            comment.setCommentContent(content);
            comment.setPostId(postId);
            comment.setUserIp(request.getRemoteAddr());
            commentMapper.insertSelective(comment);
            dto.setCode(0);
        } else {
            dto.setCode(-1);
        }
        return dto;
    }
}
