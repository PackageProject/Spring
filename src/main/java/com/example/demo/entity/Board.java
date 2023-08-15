package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long boardid;
    private String title;
    private String writer;
    public Board() {
    }
    public Board(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }


}