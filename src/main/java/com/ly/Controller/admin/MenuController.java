package com.ly.controller.admin;

import com.ly.dao.MenuMapper;
import com.ly.pojo.Menu;
import com.ly.pojo.Resource;
import com.ly.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by liangyong on 2017/10/19.
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuMapper menuMapper;


    @RequestMapping(method = RequestMethod.GET)
    public String resource() {
        return "/admin/menu";
    }

    @ResponseBody
    @RequestMapping("/listMenu")
    public List<Menu> listMenu() {
        return menuService.listMenu();

    }


    @RequestMapping("addMenu")
    public void main(Menu menu) {

        menuMapper.insertSelective(menu);
    }
}
