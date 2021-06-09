package com.example.demo.service;

import com.example.demo.dao.StoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoreService {
    @Autowired
    private StoreDao storeDao;

}
