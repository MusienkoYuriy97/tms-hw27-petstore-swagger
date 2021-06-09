package com.example.demo.service;

import com.example.demo.dao.PetDao;
import com.example.demo.model.Pet;
import com.example.demo.model.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetService {
    @Autowired
    private PetDao petDao;

    public void save(Pet pet) {
        if (!petDao.contains(pet.getId())){
            petDao.add(pet);
        }
    }

    public void update(Pet pet) {
        if (petDao.contains(pet.getId())){
            petDao.update(pet);
        }
    }

    public List<Pet> listByStatus(String[] status){
        return petDao.getByStatus(status);
    }

    public Pet getById(int petId){
        Optional<Pet> byId = petDao.getById(petId);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public void update(int petId, String name, String status) {
        if (petDao.contains(petId)){
            petDao.update(petId,name, PetStatus.valueOf(status));
        }
    }

    public void delete(int petId) {
        if (petDao.contains(petId)){
            Pet pet = petDao.getById(petId).get();
            petDao.delete(pet);
        }

    }
}
