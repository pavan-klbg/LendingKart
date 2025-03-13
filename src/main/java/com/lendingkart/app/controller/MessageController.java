package com.lendingkart.app.controller;

import com.lendingkart.app.model.MessageModel;
import com.lendingkart.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    public MessageService messageService;

    @GetMapping("/{clientId}/{userName}")
    public MessageModel acceptMessage(@PathVariable String clientId ,@PathVariable String userName){
return messageService.readTerms(clientId,userName);


    }
}
