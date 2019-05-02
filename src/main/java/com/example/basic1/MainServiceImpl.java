package com.example.basic1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    MainTableRepository mainTableRepository;
    @Autowired
    @Qualifier(value = "TableHelper")
    TableHelper tableHelper;

    String s = "sha-1";

    public Iterable<MainTable> getListFromTable(){
        return mainTableRepository.findAll();
    }

    public String getHashByNumber(int phoneNumber){

        MainTable test = mainTableRepository.findByPhoneNumber(phoneNumber);
        return test.getHashNumber();
    }
    public  String getNumberByHash2(String hashNumber){
        String stringHash = hashNumber.substring(5,hashNumber.length());
        return String.valueOf(mainTableRepository.findByHashNumber(stringHash).getPhoneNumber());
    }
    public String getNumberByHash(String hashNumber){
//         String s2 = hash;
         String s = "";
//        MainTable test = mainTableRepository.getNumber1(hash);
//        MainTable test = mainTableRepository.findByHashNumber(hash);
//          MainTable test = mainTableRepository.getNumber1(s2).get(0);
//          for (MainTable mt: testList) {
//              if (mt.getHashNumber().equals(s2)){
//                  s = mt.getPhoneNumber();
//              }
//          }
//        return mainTableRepository.getNumber1(hash);


        ArrayList<MainTable> mtl = (ArrayList<MainTable>) mainTableRepository.AllTables();
        ArrayList<MainTable> m = new ArrayList<>();
        for(int i = 0; i < mtl.size(); i++){
            MainTable mtt =  mtl.get(i);
             String sss1 = mtt.getHashNumber();
             String sss2 = hashNumber;
             String fff1 = new String(sss1);
            String fff2 = new String(sss2).substring(5,sss2.length());
             boolean b = (fff1.equals(fff2));
            if (b) {
                MainTable mq = new MainTable();
                mq.setPhoneNumber(mtt.getPhoneNumber());
                m.add(mq);
            }
        }
//        for(MainTable k: mtl){
//            if (k.getHashNumber().equals(hashNumber)){
//                m.add(k);
//            }
//        }
//        MainTable t = mtl.get(0);
        s = "[]";
        if (!(m.size()==0)) s = String.valueOf(m.get(0).getPhoneNumber());

        return s;
    }

//    public String toHash(String s){
//        return s + "12345";
//    }


    public  boolean isValidNumber(int number){
        List<MainTable> list = mainTableRepository.findAllByPhoneNumber(number);
        if (list.size()>0) return false;
        return true;
    }

    public MainTable createNewNumber(int number){
       if (isValidNumber(number)){
           MainTable mainTable = new MainTable();
           mainTable.setPhoneNumber(number);
           mainTable.setHashNumber(tableHelper.toHash(number));
           return  mainTableRepository.save(mainTable);
       }

        return null;
    }
}
