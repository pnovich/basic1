package com.example.basic1;

import org.springframework.stereotype.Service;


public interface MainService {
   public String getHashByNumber(int phoneNumber);
   public String getNumberByHash(String hashNumber);
   public Iterable<MainTable> getListFromTable();
   public MainTable createNewNumber(int number);
    public  String getNumberByHash2(String hashNumber);
}
