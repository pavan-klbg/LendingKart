package com.lendingkart.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MessageModel {
    private String userId;
    private String userName;
    private String message;

    public MessageModel(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public MessageModel(String userId, String userName, String message) {
        this.userId = userId;
        this.userName = userName;
        this.message = message;
    }

    public MessageModel() {
    }
}
