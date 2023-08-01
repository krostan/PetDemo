package com.pet.cool.service;

import com.pet.cool.entity.Publish;

import java.time.LocalDateTime;

public interface PublishService {

    public Publish findByPetId(int petId);

    void save(LocalDateTime curDate, int petId, int userId);
}
