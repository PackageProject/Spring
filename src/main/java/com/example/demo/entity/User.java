package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    @Id
    private Long usersid;

    @Column(unique = false) // 중복값 허용
    private String usersnickname;
    private String userspwd;
    private String usersphone;
    private String usersrole;
    private String usersaddress;
    private String usersstatus;

    @Override
    public String toString() {
        return "User{" +
                "usersid=" + usersid +
                ", usersnickname='" + usersnickname + '\'' +
                ", userspwd='" + userspwd + '\'' +
                ", usersphone='" + usersphone + '\'' +
                ", usersrole='" + usersrole + '\'' +
                ", usersaddress='" + usersaddress + '\'' +
                ", usersstatus='" + usersstatus + '\'' +
                '}';
    }

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public String getUsersnickname() {
        return usersnickname;
    }

    public void setUsersnickname(String usersnickname) {
        this.usersnickname = usersnickname;
    }

    public String getUserspwd() {
        return userspwd;
    }

    public void setUserspwd(String userspwd) {
        this.userspwd = userspwd;
    }

    public String getUsersphone() {
        return usersphone;
    }

    public void setUsersphone(String usersphone) {
        this.usersphone = usersphone;
    }

    public String getUsersrole() {
        return usersrole;
    }

    public void setUsersrole(String usersrole) {
        this.usersrole = usersrole;
    }

    public String getUsersaddress() {
        return usersaddress;
    }

    public void setUsersaddress(String usersaddress) {
        this.usersaddress = usersaddress;
    }

    public String getUsersstatus() {
        return usersstatus;
    }

    public void setUsersstatus(String usersstatus) {
        this.usersstatus = usersstatus;
    }

    public User(Long usersid, String usersnickname, String userspwd, String usersphone, String usersrole, String usersaddress, String usersstatus) {
        this.usersid = usersid;
        this.usersnickname = usersnickname;
        this.userspwd = userspwd;
        this.usersphone = usersphone;
        this.usersrole = usersrole;
        this.usersaddress = usersaddress;
        this.usersstatus = usersstatus;
    }

    public User(){
        this.usersid = null;

    }


}
