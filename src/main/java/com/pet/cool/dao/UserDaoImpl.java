package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public User findByName(String userName) {

        TypedQuery<User> query = entityManager.createQuery(
                "FROM User WHERE userName = :userName", User.class);
        query.setParameter("userName", userName);

        User theUser = null;

        try{
            theUser = query.getSingleResult();
        }catch (Exception e){
            theUser = null;
        }
        return theUser;
    }

    @Override
    @Transactional
    public void save(User theUser) {

        entityManager.merge(theUser);
    }

    @Override
    public User findById(int userId) {
        TypedQuery<User> query = entityManager.createQuery(
                "FROM User WHERE userId = :userId", User.class);
        query.setParameter("userId", userId);

        User theUser = null;

        try{
            theUser = query.getSingleResult();
        }catch (Exception e){
            theUser = null;
        }
        return theUser;
    }

    @Override
    public boolean updatePwd(int userId, String newPwd) {

        boolean isSuccess = false;
        TypedQuery<User> query = entityManager.createQuery(
                "FROM User WHERE userId = :userId", User.class);

        query.setParameter("userId",userId);

        User theUser = null;

        try{
            theUser = query.getSingleResult();

            if(theUser != null){
                theUser.setPassword(newPwd);
                entityManager.merge(theUser);
                isSuccess =  true;
            }

        }catch (NoResultException e){
            isSuccess = false;
        }

        return isSuccess;
    }

    @Override
    public List<Pet> getPetsByUserId(int userId) {

        TypedQuery<User> query = entityManager.createQuery(
                "FROM User WHERE userId = :userId", User.class);

        query.setParameter("userId",userId);

        User theUser = query.getResultList().stream().findFirst().orElse(null);

        // 當找不到該會員時, 透過Collections.emptyList() 返回一個空的且不可變動的List
        // 這樣在跑for迴圈時 也不會發生錯誤
        return (theUser != null)?theUser.getPets(): Collections.emptyList();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }
}
