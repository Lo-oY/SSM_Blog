package com.ly.dao;

import com.ly.pojo.PostType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PostType record);

    int insertSelective(PostType record);

    PostType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostType record);

    int updateByPrimaryKey(PostType record);

    Integer addBlogType(PostType blogType);

    List<PostType> getAllPostType();
}