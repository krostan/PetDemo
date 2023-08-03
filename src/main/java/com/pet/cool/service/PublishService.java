package com.pet.cool.service;

import com.pet.cool.entity.Publish;

import java.time.LocalDateTime;
import java.util.List;

public interface PublishService {

    public Publish findByPetId(int petId);

    void save(LocalDateTime curDate, int petId, int userId);

    // 取得自己的刊登資料
    public List<Publish> getUserPublishByUserId(int userId);

    // 取得 (除了自己)的全部寵物刊登資料
    public List<Publish> getAllPublishes(int userId);

    // 根據參數 排序刊登時間 (ASC or DESC)
    public List<Publish> sortAllPublishes(String sort);

    // 根據 寵物編號 刪除該寵物的刊登資料
    void deletePublish(int petId);
}
