package com.pet.cool.dao;

import com.pet.cool.entity.Pet;
import com.pet.cool.entity.User;

import java.util.List;

public interface UserDao {

    User findByName(String userName);

    void save(User theUser);

    // 透過ID找尋使用者
    User findById(int userId);

    // 重置密碼
    boolean updatePwd(int userId, String newPwd);

    // 搜尋會員的全部寵物
    List<Pet> getPetsByUserId(int userId);

    // 找到全部會員
   List<User> findAll();

    // 透過會員編號 刪除會員
    boolean delete(int userId);
}
