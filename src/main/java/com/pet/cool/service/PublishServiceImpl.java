package com.pet.cool.service;

import com.pet.cool.dao.PetDao;
import com.pet.cool.dao.PublishDao;
import com.pet.cool.dao.UserDao;
import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;
import com.pet.cool.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PublishServiceImpl implements PublishService{

    private PublishDao publishDao;
    private PetDao petDao;

    private UserDao userDao;

    @Autowired
    public PublishServiceImpl(PublishDao thePublishDao, PetDao thePetDao, UserDao theUserDao){
        this.publishDao = thePublishDao;
        this.petDao = thePetDao;
        this.userDao = theUserDao;
    }

    @Override
    public Publish findByPetId(int petId) {

        Pet pet = petDao.findById(petId);

        return publishDao.findPublishByPet(pet);
    }

    @Override
    public void save(LocalDateTime curDate, int petId, int userId) {
        Publish publish = new Publish();

        Pet pet = petDao.findById(petId);

        User user = userDao.findById(userId);

        publish.setPublishDate(curDate);
        publish.setEnabled(true);
        publish.setPet(pet);
        publish.setUser(user);

        publishDao.save(publish);
    }
}
