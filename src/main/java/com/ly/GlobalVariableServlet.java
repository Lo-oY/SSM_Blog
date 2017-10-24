package com.ly;

import com.ly.util.GlobalVariableManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cilu on 2017/10/24.
 */
@WebServlet(value = "/admin/globalVariableServlet")
public class GlobalVariableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GlobalVariableManager globalVariableManager = GlobalVariableManager.getInstance();
        String info = globalVariableManager.getInfo();
        resp.getWriter().print(info);
    }
}
