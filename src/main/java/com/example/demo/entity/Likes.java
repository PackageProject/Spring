package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Likes {


    @Id
    private Long likesid;

    @Column(unique = false) // 중복값 허용
    private Long storesid;
    private Long usersid;
    private String likesstatus;


    public Likes(){
        this.likesid = null;

    }

    public Likes(Long likesid, Long storesid, Long usersid, String likesstatus) {
        this.likesid = likesid;
        this.storesid = storesid;
        this.usersid = usersid;
        this.likesstatus = likesstatus;
    }

    public Long getLikesid() {
        return likesid;
    }

    public void setLikesid(Long likesid) {
        this.likesid = likesid;
    }

    public Long getStoresid() {
        return storesid;
    }

    public void setStoresid(Long storesid) {
        this.storesid = storesid;
    }

    public Long getUsersid() {
        return usersid;
    }

    public void setUsersid(Long usersid) {
        this.usersid = usersid;
    }

    public String getLikesstatus() {
        return likesstatus;
    }

    public void setLikesstatus(String likesstatus) {
        this.likesstatus = likesstatus;
    }





    @Override
    public String toString() {
        return "Like{" +
                "likesid=" + likesid +
                ", storesid=" + storesid +
                ", usersid=" + usersid +
                ", likesstatus='" + likesstatus + '\'' +
                '}';
    }


}
