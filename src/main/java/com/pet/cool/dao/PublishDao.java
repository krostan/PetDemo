package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;

import java.util.List;

public interface PublishDao {

    Publish findPublishByPet(int petId);

    void save(Publish thePublish);

    // 取得自己刊登資料
    List<Publish> getUserPublishByUserId(int userId);

    // 取得全部寵物刊登資料
    List<Publish> getAllPublishes();

    // 根據參數 排序刊登時間 (ASC or DESC)
    List<Publish> sortAllPublishes(String sort);

    // 根據 寵物編號 刪除該寵物的刊登資料
    void deletePublish(int publishId);
}
