package com.pet.cool.service;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;
import com.pet.cool.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);

    // 搜尋會員的全部寵物
    public List<Pet> getPetsByUserId(int userId);
}
