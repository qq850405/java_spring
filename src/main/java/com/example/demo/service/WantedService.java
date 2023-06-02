package com.example.demo.service;

import com.example.demo.entity.Wanted;
import org.springframework.web.bind.annotation.RequestParam;

public interface WantedService {
    void createWanted(Wanted wanted);

    }
