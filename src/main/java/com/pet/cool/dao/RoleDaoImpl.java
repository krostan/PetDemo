package com.pet.cool.dao;

import com.pet.cool.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao{

    private EntityManager entityManager;

    @Autowired
    public RoleDaoImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    public Role findRoleByName(String theRoleName) {

        TypedQuery<Role> query = entityManager.createQuery(
                "FROM Role WHERE name = :roleName", Role.class);
        query.setParameter("roleName", theRoleName);

        Role theRole = null;

        try{
            theRole = query.getSingleResult();
        }catch(Exception e){
            theRole = null;
        }

        return theRole;
    }
}
