package com.example.demo.service;

import com.example.demo.entity.Wanted;

import java.util.List;

public interface WantedService {
    void createWanted(Wanted wanted);

    List<Wanted> findAll();

//    String getWanted();

    }


