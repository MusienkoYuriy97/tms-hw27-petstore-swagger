package com.example.demo.service;

import com.example.demo.dao.PetDao;
import com.example.demo.dao.StoreDao;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StoreService {
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private PetDao petDao;

    public Optional<Order> save(Order order) {
        if (!storeDao.contains(order.getId()) && petDao.contains(order.getPetId())){
            storeDao.save(order);
        }
        return storeDao.getById(order.getId());
    }

    public Optional<Order> getOrder(int orderId) {
        return storeDao.getById(orderId);
    }

    public void delete(int orderId) {
        Optional<Order> byId = storeDao.getById(orderId);
        if (byId.isPresent()) {
            storeDao.delete(byId.get());
        }
    }
}
