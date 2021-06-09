package com.example.demo.dao.inmemory;

import com.example.demo.dao.StoreDao;
import com.example.demo.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryStoreDao implements StoreDao {
    private List<Order> storeList = new ArrayList<>();

    @Override
    public void save(Order order) {
        storeList.add(order);
    }

    @Override
    public Optional<Order> getById(int id) {
        for (Order order : storeList) {
            if (order.getId() == id){
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean contains(int id) {
        return storeList.stream().anyMatch(order -> order.getId() == id);
    }

    @Override
    public void delete(Order order) {
        storeList.remove(order);
    }
}
