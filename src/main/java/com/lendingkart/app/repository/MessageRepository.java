package com.lendingkart.app.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MessageRepository {


    static Map<String,String> USER_MESSAGE=new HashMap<>();

    static {
        USER_MESSAGE.put("Client1","I %s do acknowledge to accept the terms at %s");
        USER_MESSAGE.put("Client2","I %s agree that I have read the terms and condition shared at %s");
    }
    public String getClientMessageTemplate(String clientId){
        return USER_MESSAGE.get(clientId);

    }
}
