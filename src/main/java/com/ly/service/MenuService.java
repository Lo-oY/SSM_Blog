package com.ly.service;

import com.ly.dao.MenuMapper;
import com.ly.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by liangyong on 2017/10/19.
 */
@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> listMenu() {
        List<Menu> menuList = menuMapper.getAllMenu();
        return menuList;

    }
}
