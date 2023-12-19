package com.test.teste.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "telephone")
    private String phoneNumber;

    // Empty constructor required by JPA
    public UserEntity() {
    }

    public UserEntity(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long newId) {
    	this.id = newId;
    }

    // No setId method to prevent setting the ID manually

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }
}
