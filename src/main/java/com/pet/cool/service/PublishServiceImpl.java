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
import java.util.ArrayList;
import java.util.List;

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

        return publishDao.findPublishByPet(petId);
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

    @Override
    public List<Publish> getUserPublishByUserId(int userId) {
        return publishDao.getUserPublishByUserId(userId);
    }

    @Override
    public List<Publish> getAllPublishes(int userId) {

        // 找到全部刊登
        List<Publish> allPublishes = publishDao.getAllPublishes();
        List<Publish> result = new ArrayList<>();

        for(Publish publish : allPublishes){
            if(publish.getUser().getUserId() != userId){
                result.add(publish);
            }
        }

        return result;
    }

    @Override
    public List<Publish> sortAllPublishes(String sort) {

        String sortData = "";

        if (sort.equals("最新發布")) {
            sortData = "desc";
        } else if (sort.equals("默認排序")) {
            sortData = "asc";
        }

        return publishDao.sortAllPublishes(sortData);
    }

    @Override
    public void deletePublish(int petId) {

        Publish publish = publishDao.findPublishByPet(petId);

        publishDao.deletePublish(publish.getPublishId());
    }
}
