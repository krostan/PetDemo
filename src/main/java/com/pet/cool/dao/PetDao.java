package com.pet.cool.dao;

import com.pet.cool.entity.Pet;

public interface PetDao {

    void save(Pet thePet);

    Pet findById(int petId);

    void disablePet(Pet pet);
}
