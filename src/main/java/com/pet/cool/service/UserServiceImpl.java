package com.pet.cool.service;

import com.pet.cool.dao.RoleDao;
import com.pet.cool.dao.UserDao;
import com.pet.cool.entity.Pet;
import com.pet.cool.entity.Role;
import com.pet.cool.entity.User;
import com.pet.cool.user.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    private RoleDao roleDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findByUserName(String userName) {
        return userDao.findByName(userName);
    }

    @Override
    public void save(WebUser webUser) {
        User user = new User();

        user.setUserName(webUser.getUserName());
        user.setPassword(bCryptPasswordEncoder.encode(webUser.getPassword()));
        user.setName(webUser.getName());
        user.setPhone(webUser.getPhone());
        user.setBirthday(webUser.getBirthday());
        user.setEmail(webUser.getEmail());
        user.setGender(webUser.getGender());
        user.setAddress(webUser.getAddress());
        user.setEnabled(true);

        user.setRoles(Arrays.asList(roleDao.findRoleByName("ROLE_MEMBER")));

        userDao.save(user);
    }

    @Override
    public List<Pet> getPetsByUserId(int userId) {
        return userDao.getPetsByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findByName(username);

        if( user == null){
            throw new UsernameNotFoundException("帳號或密碼輸入錯誤");
        }

        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(user.getRoles());
		
		// 建立 User物件 (取得使用者名稱, 密碼, 使用者的授權集合)
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
	
	// 將role的名稱 新增到授權集合裡面
    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role tempRole : roles){
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }


}
