package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;

public interface PublishDao {

    Publish findPublishByPet(Pet pet);

    void save(Publish thePublish);
}
