package com.pet.cool.dao;

import com.pet.cool.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);
}
