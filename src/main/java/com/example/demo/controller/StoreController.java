package com.example.demo.controller;

import com.example.demo.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {

    @GetMapping("/inventory")
    public ResponseEntity<String> inventory(){
        return null;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> order(@RequestBody Order order){
        return null;
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable String orderId){
        return null;
    }

    @DeleteMapping("/order/{orderId}")
    public void delete(@PathVariable String orderId){

    }

}
