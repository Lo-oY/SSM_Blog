package com.ly.controller;

import com.ly.dao.PostMapper;
import com.ly.pojo.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

//    private Log log = LogFactory.getLog(getClass());
//private Logger log = LoggerFactory.getLogger(getClass());


    public IndexController() {
        System.out.println("super index controller");
    }

    private Log log = LogFactory.getLog(getClass());
    @Autowired
    private PostMapper postMapper;

    @RequestMapping("/index")
    public ModelAndView index() {
        log.debug("route to index  debug");
        log.info("route to index  info");


        System.out.println("debug enable" + log.isDebugEnabled());
        System.out.println("info enable" + log.isInfoEnabled());
        System.out.println("error enable" + log.isErrorEnabled());
        System.out.println("trace enable" + log.isTraceEnabled());
        System.out.println("warn enable" + log.isWarnEnabled());

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("start", 0);
        map.put("end", 10);
        List<Post> postList = postMapper.listPost(map);
        System.out.println(postList);
        ModelAndView mav = new ModelAndView();
        mav.addObject("postList", postList);
        mav.addObject("blogLeft", "blogList.jsp");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/image")
    public String getImage(){
        System.out.println("Image");
        return "image";
    }
}
