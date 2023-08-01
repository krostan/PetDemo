package com.pet.cool.service;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import com.pet.cool.pet.WebPet;

public interface PetService {

    // 儲存資料
    void save(Pet pet, WebPet webPet, String imagePath, User user);

    // 刪除資料 disable
    void disablePetByPetId(int petId);


    // 透過寵物ID找到寵物
    public Pet findById(int petId);
}
