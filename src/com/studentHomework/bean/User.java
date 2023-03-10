package com.studentHomework.bean;

public class User {
    private String u_id;
    private String u_name;
    private String u_pwd;
    private String u_phone;
    private int u_role;
    private int u_isdelete;

    public User(){}

    public User(String u_id, String u_name, String u_pwd, String u_phone, int u_role, int u_isdelete) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.u_phone = u_phone;
        this.u_role = u_role;
        this.u_isdelete = u_isdelete;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }


    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }

    public int getU_role() {
        return u_role;
    }

    public void setU_role(int u_role) {
        this.u_role = u_role;
    }

    public int getU_isdelete() {
        return u_isdelete;
    }

    public void setU_isdelete(int u_isdelete) {
        this.u_isdelete = u_isdelete;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", u_name='" + u_name + '\'' +
                ", u_pwd='" + u_pwd + '\'' +
                ", u_phone='" + u_phone + '\'' +
                ", u_role=" + u_role +
                ", u_isdelete=" + u_isdelete +
                '}';
    }
}
