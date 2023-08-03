package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PetDaoImpl implements PetDao {

    private EntityManager entityManager;

    @Autowired
    public PetDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Pet thePet) {
        entityManager.merge(thePet);
    }

    @Override
    public Pet findById(int petId) {

        TypedQuery<Pet> query = entityManager.createQuery(
                "FROM Pet WHERE petId = :petId", Pet.class);

        query.setParameter("petId", petId);

        Pet pet = null;

        try{
            pet = query.getSingleResult();
        }catch(Exception e){
            pet = null;
        }

        return pet;
    }

    @Override
    @Transactional
    public void disablePet(Pet pet) {
        entityManager.merge(pet);
    }

    @Override
    public List<Pet> findAllByUserId(int userId) {

        TypedQuery<Pet> query =entityManager.createQuery(
                "FROM Pet WHERE user.id = :userId", Pet.class);
        query.setParameter("userId", userId);

        List<Pet> result = null;
        try{
            result = query.getResultList();
        }catch(Exception e){
            // 待處理
            result = null;
        }

        return result;
    }
}
