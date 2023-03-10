package com.studentHomework.dao;

import com.studentHomework.bean.Course;
import com.studentHomework.bean.User;

import java.sql.*;
import java.util.ArrayList;

public class FiledaoImpl implements Filedao{


    @Override
    public ArrayList<User> getAllStudent() {
        ArrayList<User> arr =new ArrayList<>();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8";

        String root = "root";
        String password="root123";

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,root,password);
            if(!con.isClosed()){
                System.out.println("数据库连接成功");
                Statement stmt = con.createStatement();
                //sql语句
                String sql = "SELECT * FROM `homework_database`.`users` WHERE `u_role` = 1 AND `u_isdelete` = 1";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    User user = new User();
                    user.setU_id(rs.getString("u_id"));
                    user.setU_name(rs.getString("u_name"));
                    user.setU_pwd(rs.getString("u_pwd"));
                    user.setU_phone(rs.getString("u_phone"));
                    user.setU_role(rs.getInt("u_role"));
                    user.setU_isdelete(rs.getInt("u_isdelete"));
                    arr.add(user);
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("数据库连接驱动加载失败");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查找失败");
        }

        return arr;
    }

    @Override
    public ArrayList<Course> getAllcourses() {
        ArrayList<Course> arr =new ArrayList<>();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8";

        String root = "root";
        String password="root123";

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,root,password);
            if(!con.isClosed()){
                System.out.println("数据库连接成功");
                Statement stmt = con.createStatement();
                //sql语句
                String sql = "SELECT * FROM `homework_database`.`course`";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    Course course = new Course();
                    course.setC_id(rs.getString("c_id"));
                    course.setC_name(rs.getString("c_name"));
                    course.setC_teacher(rs.getString("c_teacher"));
                    arr.add(course);
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("数据库连接驱动加载失败");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查找失败");
        }
        return arr;
    }

    @Override
    public ArrayList<User> getFileByNameOrId(String v) {
        //查找特定对象
        ArrayList<User> arr =new ArrayList<>();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8";

        String root = "root";
        String password="root123";

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,root,password);
            if(!con.isClosed()){
                System.out.println("数据库连接成功");
                Statement stmt = con.createStatement();
                //sql语句
                String sql = "SELECT * FROM `homework_database`.`users` WHERE `u_id` LIKE "+v+" OR `u_name` LIKE "+v;
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    User user = new User();
                    user.setU_id(rs.getString("u_id"));
                    user.setU_name(rs.getString("u_name"));
                    user.setU_pwd(rs.getString("u_pwd"));
                    user.setU_phone(rs.getString("u_phone"));
                    user.setU_role(rs.getInt("u_role"));
                    user.setU_isdelete(rs.getInt("u_isdelete"));
                    arr.add(user);
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("数据库连接驱动加载失败");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查找失败");
        }
        return arr;
    }

    @Override
    public ArrayList<Course> getCourseByNameOrId(String v) {
        ArrayList<Course> arr =new ArrayList<>();
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=UTF-8";

        String root = "root";
        String password="root123";

        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,root,password);
            if(!con.isClosed()){
                System.out.println("数据库连接成功");
                Statement stmt = con.createStatement();
                //sql语句
                String sql = "SELECT * FROM `homework_database`.`course` WHERE `c_id` LIKE "+v+" OR `c_name` LIKE "+v;
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    Course course = new Course();
                    course.setC_id(rs.getString("c_id"));
                    course.setC_name(rs.getString("c_name"));
                    course.setC_teacher(rs.getString("c_teacher"));
                    arr.add(course);
                }
            }
        }
        catch (ClassNotFoundException e){
            System.out.println("数据库连接驱动加载失败");
        }catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据查找失败");
        }
        return arr;
    }
}
