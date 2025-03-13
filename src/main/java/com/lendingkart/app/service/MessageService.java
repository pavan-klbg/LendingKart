package com.lendingkart.app.service;

import com.lendingkart.app.model.MessageModel;
import com.lendingkart.app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;


    // read terms and conditions
    public MessageModel readTerms(String clientId, String userName) {
        try {
            String template = messageRepository.getClientMessageTemplate(clientId);
            if (template == null) {
                throw new IllegalArgumentException("No message found for client " + clientId);
            }
            String processedMessage = template.replace("{userName}", userName)
                    .replace("{timestamp}", LocalDateTime.now().toString());
            return new MessageModel(clientId, userName, processedMessage);

        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException("error processing message");
        }

    }

    // accept the terms and acknowledgment
    public MessageModel acceptTerms(String clientId, String userName) {
        return new MessageModel();
    }
}
