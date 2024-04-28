package com.example.navigationdrawer;

public class UserHelperClass {
    String username,email,phoneno;

    public UserHelperClass(){

    }

    public UserHelperClass(String username, String email, String phoneno) {
        this.username = username;
        this.email = email;
        this.phoneno = phoneno;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

}
