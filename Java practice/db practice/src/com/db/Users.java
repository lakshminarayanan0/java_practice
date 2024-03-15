package com.db;

public class Users {

    private String user_name;
    private int user_id;
    private String mail_id;

    public Users(String user_name, String mail_id) {
        this.user_name = user_name;
        this.mail_id = mail_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public Users(int id, String user_name, String mail_id) {
        this.user_id=id;
        this.user_name = user_name;
        this.mail_id = mail_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getMail_id() {
        return mail_id;
    }

}
