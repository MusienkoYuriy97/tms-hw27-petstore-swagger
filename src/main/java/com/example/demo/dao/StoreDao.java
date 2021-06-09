package com.example.demo.dao;

import com.example.demo.model.Order;

import java.util.Optional;

public interface StoreDao {
    void save(Order order);
    Optional<Order> getById(int id);
    boolean contains(int id);
    void delete(Order order);
}
