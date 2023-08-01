package com.pet.cool.pet;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;

public class WebPet {

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String petName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String breed;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String gender;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String coatColor;

    @NotNull(message = "is required")
    @Min(value = 0, message = "不足1歲, 請填0")
    @Max(value = 99, message = "最大年齡為99")
    private String age;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String location;

    @NotNull(message = "is required")
    private String species;

    @NotNull(message = "is required")
    private String size;

    private String quest;

    private MultipartFile image;

    private boolean enabled;

    public WebPet() {
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
