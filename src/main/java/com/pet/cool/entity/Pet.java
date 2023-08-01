package com.pet.cool.entity;

import jakarta.persistence.*;

@Entity
@Table(name="pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private int petId;

    @Column(name="petName")
    private String petName;

    @Column(name="breed")
    private String breed;

    @Column(name="gender")
    private String gender;

    @Column(name="coatColor")
    private String coatColor;

    @Column(name="age")
    private String age;

    @Column(name="location")
    private String location;

    @Column(name="species")
    private String species;

    @Column(name="size")
    private String size;

    @Column(name="quest")
    private String quest;

    @Column(name="photos")
    private String photos;

    @Column(name="enabled")
    private boolean enabled;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    // 這個publish是由 Publish 的 pet屬性映射的 (雙向)
    @OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
    private Publish publish;

    public Pet() {
    }

    public Pet(String petName, String breed, String gender, String coatColor, String age, String location, String species, String size, String quest, String photos, boolean enabled) {
        this.petName = petName;
        this.breed = breed;
        this.gender = gender;
        this.coatColor = coatColor;
        this.age = age;
        this.location = location;
        this.species = species;
        this.size = size;
        this.quest = quest;
        this.photos = photos;
        this.enabled = enabled;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String catName) {
        this.petName = catName;
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

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publish getPublish() {
        return publish;
    }

    public void setPublish(Publish publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", coatColor='" + coatColor + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", species='" + species + '\'' +
                ", size='" + size + '\'' +
                ", quest='" + quest + '\'' +
                ", photos='" + photos + '\'' +
                '}';
    }
}
