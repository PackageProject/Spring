package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Menu {


    @Id
    private Long menusid;

    @Column // 중복값 허용
    private Long storesid;
    private String menusname;
    private Long prices;
    private Long categoryid;







    public Menu(){
        this.menusid = null;

    }
    public Menu(Long menusid, Long storesid, String menusname, Long prices, Long categoryid) {
        this.menusid = menusid;
        this.storesid = storesid;
        this.menusname = menusname;
        this.prices = prices;
        this.categoryid = categoryid;
    }






    public Long getMenusid() {
        return menusid;
    }

    public void setMenusid(Long menusid) {
        this.menusid = menusid;
    }

    public Long getStoresid() {
        return storesid;
    }

    public void setStoresid(Long storesid) {
        this.storesid = storesid;
    }

    public String getMenusname() {
        return menusname;
    }

    public void setMenusname(String menusname) {
        this.menusname = menusname;
    }

    public Long getPrices() {
        return prices;
    }

    public void setPrices(Long prices) {
        this.prices = prices;
    }


    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }





    @Override
    public String toString() {
        return "Menu{" +
                "menusid=" + menusid +
                ", storesid=" + storesid +
                ", menusname='" + menusname + '\'' +
                ", prices=" + prices +
                ", categoryid=" + categoryid +
                '}';
    }



}
