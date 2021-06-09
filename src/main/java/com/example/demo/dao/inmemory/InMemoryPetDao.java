package com.example.demo.dao.inmemory;

import com.example.demo.dao.PetDao;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryPetDao implements PetDao {
    private List<Pet> petList = new ArrayList<>();


    @Override
    public void add(Pet pet) {
        petList.add(pet);
    }

    @Override
    public void delete(Pet pet) {
        petList.remove(pet);
    }

    @Override
    public void update(Pet pet) {
        for (Pet p : petList) {
            if (p.getId() == pet.getId()){
                p = pet;
            }
        }
    }

    @Override
    public void update(int petId, String name, PetStatus status) {
        for (Pet pet : petList) {
            if (pet.getId() == petId){
                pet.setName(name);
                pet.setStatus(status);
            }
        }
    }

    @Override
    public List<Pet> getByStatus(String[] status) {
        List<Pet> pets = new ArrayList<>();
        for (Pet pet : petList) {
            for (String s : status) {
                if (pet.getStatus().toString().equalsIgnoreCase(s)){
                    pets.add(pet);
                }
            }
        }
        return pets;
    }

    @Override
    public Optional<Pet> getById(int id) {
        for (Pet pet : petList) {
            if (pet.getId() == id){
                return Optional.of(pet);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean contains(int id) {
        return petList.stream().anyMatch(pet -> pet.getId() == id);
    }
}
