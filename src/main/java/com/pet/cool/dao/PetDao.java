package com.pet.cool.dao;

import com.pet.cool.entity.Pet;

import java.util.List;

public interface PetDao {

    // 儲存
    void save(Pet thePet);

    // 透過寵物編號找 該寵物資料
    Pet findById(int petId);

    // 刪除寵物(但不刪除資料)
    void disablePet(Pet pet);

    // 取得該會員的全部寵物
    List<Pet> findAllByUserId(int userId);
}
