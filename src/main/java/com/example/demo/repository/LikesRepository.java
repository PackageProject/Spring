package com.example.demo.repository;

import com.example.demo.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LikesRepository extends JpaRepository<Likes, Long> {
    List<Likes> findByusersid(Long usersid);
}
