package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int petId;
    private int quantity;
    private LocalDateTime shipDate;
    private OrderStatus status;
    private boolean complete;
}
