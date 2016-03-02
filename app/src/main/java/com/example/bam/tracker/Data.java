package com.example.bam.tracker;

/**
 * Created by Regis on 12-12-2015.
 */
public class Data {
    private String username,password,email,phone_no;
    public Data() {

    }

    public Data(String username, String password, String email, String phone_no) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_no = phone_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }


}
