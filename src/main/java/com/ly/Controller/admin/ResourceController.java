package com.ly.controller.admin;

import com.ly.dao.ResourceMapper;
import com.ly.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by cilu on 2017/10/19.
 */
@Controller
@RequestMapping("/admin/resource")
public class ResourceController {

    @Autowired
    private ResourceMapper resourceMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView resource() {

        List<Resource> resourceList = resourceMapper.selectAllResource();
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/admin/resource");
        return mav;
    }
    @ResponseBody
    @RequestMapping("/listResource")
    public List<Resource> listResource() {
        List<Resource> resourceList = resourceMapper.selectAllResource();
        return resourceList;
    }
}
