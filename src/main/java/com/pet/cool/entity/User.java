package com.pet.cool.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @Column(name="birthday")
    private LocalDate birthday;

    @Column(name="email")
    private String email;

    @Column(name="gender")
    private String gender;

    @Column(name="address")
    private String address;

    @Column(name="enabled")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private Collection<Role> roles;


    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Pet> pets;

    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Publish> publishes;

    public User() {
    }

    public User(String userName, String password, String name, String phone, LocalDate birthday, String email, String gender, String address, boolean enabled, Collection<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Publish> getPublishes() {
        return publishes;
    }

    public void setPublishes(List<Publish> publishes) {
        this.publishes = publishes;
    }

    public void addPet(Pet pet){
        if(pets == null){
            pets = new ArrayList<>();
        }

        pets.add(pet);
        pet.setUser(this);
    }

    public void addPublish(Publish publish){
        if(publishes == null){
            publishes = new ArrayList<>();
        }

        publishes.add(publish);
        publish.setUser(this);
    }

    @Override
    public String toString() {
        return "Member{" +
                "userId=" + userId +
                ", username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", enabled='" + enabled + '\'' +
                '}';
    }
}
