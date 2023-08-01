package com.pet.cool.user;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WebUser {

    @NotNull(message = "is required")
    @Pattern(regexp = "^[0-9a-z]{8,12}$", message = "長度必須為8~12")
    private String userName;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[0-9a-z]{8,12}$", message = "長度必須為8~12")
    private String password;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String name;

    @NotNull(message = "is required")
    @Pattern(regexp="^09\\d{2}?\\d{3}?\\d{3}$", message = "格式應為0988777555")
    private String phone;

    @NotNull(message = "is required")
    @Past(message = "不正確的生日日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String gender;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String address;

    private int enabled;

    public WebUser() {

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
