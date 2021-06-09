package com.example.demo.controller;

import com.example.demo.model.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @PostMapping
    public void put(@RequestBody Pet pet){

    }

    @PostMapping
    public void update(@RequestBody Pet pet){

    }

    @GetMapping("/findByStatus")
    public ResponseEntity<List<Pet>> getByStatus(@RequestBody String[] status){
        return null;
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getById(@PathVariable String petId){
        return null;
    }

    @PostMapping("/{petId}")
    public void update(@PathVariable String petId, String name, String status){

    }

    @DeleteMapping("/{petId}")
    public void delete(@PathVariable String petId){

    }
}
