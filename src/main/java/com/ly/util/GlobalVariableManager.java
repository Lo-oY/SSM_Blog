package com.ly.util;

import com.ly.dao.PostTypeMapper;
import com.ly.pojo.PostType;
import org.codehaus.jackson.map.ObjectMapper;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cilu on 2017/10/24.
 */
public class GlobalVariableManager {

    private static GlobalVariableManager instance = new GlobalVariableManager();

    public static GlobalVariableManager getInstance() {
        return instance;
    }

    public String getInfo() throws IOException {

        PostTypeMapper postTypeMapper = SpringUtils.getBeanOfType(PostTypeMapper.class);
        List<PostType> postTypeList = postTypeMapper.getAllPostType();
        System.out.println(postTypeList);
        StringBuilder sb = new StringBuilder();
//        Map<String, String> map = new HashMap<String, String>();
        sb.append("var g_blogTypeMap=").append(new ObjectMapper().writeValueAsString(postTypeList));
        return sb.toString();
    }
}
