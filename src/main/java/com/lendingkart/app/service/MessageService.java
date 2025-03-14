package com.lendingkart.app.service;

import com.lendingkart.app.model.MessageModel;
import com.lendingkart.app.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Service
public class MessageService {
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);
    @Autowired
    MessageRepository messageRepository;


    // read terms and conditions
    public String readTerms(String clientId, String userName) {


        try {
            String template = messageRepository.getClientMessageTemplate(clientId);
            if (template == null|| userName.isEmpty()) {
                throw new IllegalArgumentException(" No message found for client " + clientId);
            }

            String timeStamp = new SimpleDateFormat("dd-MM-yyyy hh:mm a z").format(new Date());


             log.info("Generating message{} for ",template);
            return String.format(template, userName, timeStamp);

        } catch (Exception e) {
            log.error("error fetching message{} ", e.getMessage());
            throw new RuntimeException("error processing message");
        }


    }

    //  basic post acknowledgment
    public Map<String,String> postTerms(String clientId, String userName){
        return  Map.of("Status","success","message","acknowledged by user");
    }
}
