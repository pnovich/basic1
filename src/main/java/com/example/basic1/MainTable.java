package com.example.basic1;

import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "main_table")
public class MainTable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
   @Column(name = "phone_number")
    int phoneNumber;
   @Column(name = "hash_number")
    String hashNumber;

    public MainTable(int phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public MainTable(String hashNumber) {
        phoneNumber = phoneNumber;
    }

    public MainTable() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHashNumber() {
        return hashNumber;
    }

    public void setHashNumber(String hashNumber) {
        this.hashNumber = hashNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public int getHashNumberByPhoneNumber(int phoneNumber){
//
//    };

    @Override
    public String toString() {
        return "MainTable{" +
                "Id=" + id +
                ", PhoneNumber=" + phoneNumber +
                ", hashNumber=" + hashNumber +
                '}';
    }
}
