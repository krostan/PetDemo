package com.pet.cool.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="publish")
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="publish_id")
    private int publishId;

    @Column(name="publish_date")
    private LocalDateTime publishDate;

    @Column(name="enabled")
    private boolean enabled;

    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="pet_id")
    private Pet pet;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public Publish() {
    }

    public Publish(LocalDateTime publishDate, boolean enabled) {
        this.publishDate = publishDate;
        this.enabled = enabled;
    }

    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Publish{" +
                "publishId=" + publishId +
                ", publishDate=" + publishDate +
                ", enabled=" + enabled +
                '}';
    }
}
