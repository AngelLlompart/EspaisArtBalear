/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdvi.models;

/**
 *
 * @author angel
 */
public class User {

    public User(String userName, String email, String password, boolean admin) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }
    
    public User(String password) {
        
    }
    
    public User() {
        
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    private String userName;
    private String email;
    private String password;
    private boolean admin;

    @Override
    public String toString() {
        return userName + ", " + email + ", " + password ;
    }
    
}
