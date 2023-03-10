package com.studentHomework.servlet;

import com.studentHomework.bean.Course;
import com.studentHomework.bean.User;
import com.studentHomework.service.FileService;
import com.studentHomework.service.FileServiceImpl;
import com.studentHomework.service.loginService;
import com.studentHomework.service.loginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_id=req.getParameter("u_id"); //获取账号
        String u_pwd=req.getParameter("u_pwd"); //获取密码
        User u = new User();
        u.setU_id(u_id);
        u.setU_pwd(u_pwd);
        //实现登录服务层的业务逻辑层
        loginService l = new loginServiceImpl();
        User user = l.loginService(u);
        FileService fl = new FileServiceImpl();
        if(user!=null) {
            req.setAttribute("user", user);
            if(user.getU_role()==1){
                ArrayList<Course> arr = fl.getAllcourses();
                req.setAttribute("arr", arr);
                req.getRequestDispatcher("stu_mainPage.jsp").forward(req, resp);
            }else{
                ArrayList<User> arr = fl.getAllstudents();
                req.setAttribute("arr", arr);
                req.getRequestDispatcher("tea_mainPage.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("error", "账号密码不一致！");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        System.out.println("账号："+u.getU_id()+"   密码"+u.getU_pwd());
    }
}
