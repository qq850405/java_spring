package com.example.demo.service;

import com.example.demo.entity.Wanted;
import com.example.demo.repo.UserRepository;
import com.example.demo.repo.WantedRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
@Service
public class WantedServiceImpl implements WantedService{

    private final WantedRepository wantedRepository;

    public WantedServiceImpl(WantedRepository wantedRepository) {
        this.wantedRepository = wantedRepository;
    }

    public void createWanted(Wanted wanted){
        wantedRepository.save(wanted);
    }
}
