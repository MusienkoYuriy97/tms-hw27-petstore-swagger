package com.example.demo.dao;

import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;

import java.util.List;
import java.util.Optional;

public interface PetDao {
    void add(Pet pet);
    void delete(Pet pet);
    void update(Pet pet);
    void update(int petId, String name, PetStatus status);
    List<Pet> getByStatus(String[] status);
    Optional<Pet> getById(int id);
    boolean contains(int id);
}
