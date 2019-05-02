package com.example.basic1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Qualifier(value = "TableHelper")
public class TableHelper {
    @Value("${sha_type}")
    String sha_type;
    @Value("${salt_value}")
    String salt;
    public String toHash(int number){
        String s = String.valueOf(number);
        s = s + salt;
        byte[] bytes = s.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(sha_type);
        }
        catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md.digest(bytes).toString();
    }
}
