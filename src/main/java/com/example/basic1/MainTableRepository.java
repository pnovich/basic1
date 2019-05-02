package com.example.basic1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainTableRepository extends JpaRepository<MainTable,Integer> {
//    @Query("SELECT u.hash_number FROM User u WHERE u.phone_number = 7")
//    int getHashNumberByPhoneNumber(int phoneNumber);
     MainTable findByPhoneNumber(int phoneNumber);
     List<MainTable> findPhoneNumberByHashNumber(String hashNumber);
    @Query("SELECT t FROM MainTable t")
     List<MainTable> AllTables();

    List<MainTable> findAllByPhoneNumber(int number);
    MainTable findByHashNumber(String hashNumber);

//    @Query("SELECT t FROM MainTable t WHERE t.hashNumber = :#{#hashNumber}")
//    @Query("SELECT t FROM MainTable t WHERE t.hashNumber = '[B@2d5205f'")
//    public List<MainTable> getNumber1(@Param("hashNumber")String hashNumber);

//@Query(value = "SELECT * FROM main_table t WHERE t.hash_number = h",
//        nativeQuery=true
//)
}
