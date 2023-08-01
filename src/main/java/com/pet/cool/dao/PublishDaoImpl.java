package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PublishDaoImpl implements PublishDao{

    private EntityManager entityManager;

    @Autowired
    public PublishDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public Publish findPublishByPet(Pet pet) {
        TypedQuery<Publish> query = entityManager.createQuery(
                "FROM Publish WHERE pet = :pet", Publish.class);

        query.setParameter("pet",pet);

        Publish publish = null;

        try {
            publish = query.getSingleResult();
        }catch(Exception e){
            // 錯誤訊息 待處理
            publish = null;
        }
        return publish;
    }

    @Override
    @Transactional
    public void save(Publish thePublish) {
        entityManager.merge(thePublish);
    }
}
