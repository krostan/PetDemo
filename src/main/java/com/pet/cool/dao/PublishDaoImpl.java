package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Publish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

@Repository
public class PublishDaoImpl implements PublishDao{

    private EntityManager entityManager;

    @Autowired
    public PublishDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public Publish findPublishByPet(int petId) {
        TypedQuery<Publish> query = entityManager.createQuery(
                "FROM Publish WHERE pet.petId = :petId", Publish.class);

        query.setParameter("petId",petId);

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

    @Override
    public List<Publish> getUserPublishByUserId(int userId) {
        TypedQuery<Publish> query = entityManager.createQuery(
                "FROM Publish WHERE user.userId = :userId", Publish.class);

        query.setParameter("userId", userId);

        List<Publish> result = null;

        try{
            result = query.getResultList();
        }catch(Exception e){
            result = null;
        }

        return result;
    }

    @Override
    public List<Publish> getAllPublishes() {

        TypedQuery<Publish> query = entityManager.createQuery(
                "FROM Publish", Publish.class);

        List<Publish> result = null;

        try{
            result = query.getResultList();
        }catch(Exception e){
            result = null;
        }

        return result;
    }

    @Override
    public List<Publish> sortAllPublishes(String sort) {

        String queryStr = "SELECT p FROM Publish p LEFT JOIN FETCH p.pet ORDER BY p.publishDate " + sort;

        TypedQuery<Publish> query = entityManager.createQuery(queryStr,Publish.class);

        List<Publish> result = null;

        try{
            result = query.getResultList();
        }catch(Exception e){
            result = null;
        }

        return result;
    }

    @Override
    @Transactional
    public void deletePublish(int publishId) {

        // 找到該物件
        Publish publish = entityManager.find(Publish.class, publishId);

        // 將關聯取消
        publish.getUser().setPublishes(null);
        publish.getPet().setPublish(null);

        // 刪除
        entityManager.remove(publish);
    }
}
