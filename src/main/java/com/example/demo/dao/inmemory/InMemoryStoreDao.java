package com.example.demo.dao.inmemory;

import com.example.demo.dao.StoreDao;
import org.apache.catalina.Store;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryStoreDao implements StoreDao {
    private List<Store> storeList = new ArrayList<>();
}
