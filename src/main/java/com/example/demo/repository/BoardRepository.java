package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.repository.CrudRepository;
public interface BoardRepository extends CrudRepository<Board, Long>{

}