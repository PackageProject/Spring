package com.example.demo.repository;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoresRepository extends JpaRepository<Store, Long> {

    List<Store> findByfoodcategory(String foodcategory);

    List<Store> findBystoresname(String storesname);

    List<Store> findBycategoryid(Long categoryid);
}
