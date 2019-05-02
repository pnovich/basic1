package com.example.basic1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

@RestController
//@Validated
public class BasicController {
    @Autowired
    MainTableRepository mainTableRepository;
    @Autowired
    MainService mainService;
    @Autowired
    TableHelper tableHelper;

    @GetMapping("/users")
    public String getAllUsers(){
//        MainTable mt1 = new MainTable();
          Date d1 = new Date();
          for (int i = 1; i < 10; i++) {
              MainTable mt1 = new MainTable();
              mt1.setPhoneNumber(i);
              mt1.setHashNumber(tableHelper.toHash(i));
              mainTableRepository.save(mt1);
          }

        Date d2 = new Date();
        return "all users are here" + "date1=" + d1 + "date2=" + d2;
    }
    @GetMapping("/users/table")
    public Iterable<MainTable> getListFromTable(){
        return mainService.getListFromTable();
    }
    @GetMapping("/users/gethash/{number}")
    public String getHashNumber(@PathVariable ("number") int number){
        return mainService.getHashByNumber(number);
    }
    @RequestMapping(value = "/users/getnumber", method = RequestMethod.POST)
    public String getNumber(@RequestBody String hash){
        try {
            hash = URLDecoder.decode(hash, "UTF-8");
        }catch (Exception e){}
        return  String.valueOf(mainService.getNumberByHash2(hash));
    }

    @GetMapping("users/create/{number}")
    public MainTable createNewNumber(@PathVariable ("number") int number){
//        MainTable mt = new MainTable();
//        mt.setPhoneNumber(number);
//        mt.setHashNumber(tableHelper.toHash(String.valueOf(number)));
//        mainTableRepository.save(mt);
        return mainService.createNewNumber(number);
    }

}
