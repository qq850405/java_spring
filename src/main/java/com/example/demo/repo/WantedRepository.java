package com.example.demo.repo;

import com.example.demo.entity.Wanted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantedRepository extends JpaRepository<Wanted, Long> {
    // 可添加自定义的查询方法

    //get all wanted
    List<Wanted> findAll();

}