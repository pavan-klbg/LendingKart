package com.lendingkart.app.controller;

import com.lendingkart.app.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    public MessageService messageService;


    // Get message by based on type of client
    @GetMapping("/{clientId}/{userName}")
    public ResponseEntity<String> readMessage(@PathVariable String clientId, @PathVariable String userName) {

        log.info("Fetching message for client: {}, user: {} ", clientId, userName);
        return ResponseEntity.ok(messageService.readTerms(clientId, userName));


    }

    // basic post operation by any user

    @PostMapping("/{clientId}/{userName}")
    public Map<String, String> acknowledge(@PathVariable String clientId, @PathVariable String userName) {
        return messageService.postTerms(clientId, userName);
    }
}
