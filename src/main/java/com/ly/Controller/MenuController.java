package com.ly.controller;

import com.ly.dao.MenuMapper;
import com.ly.pojo.Menu;
import com.ly.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by liangyong on 2017/10/19.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/listMenu")
    public ModelAndView listMenu() {

        List<Menu> menuList = menuService.listMenu();
        ModelAndView mav = new ModelAndView();
        mav.addObject("menuList", menuList);
        mav.setViewName("/admin/index");
        return mav;

    }
}
