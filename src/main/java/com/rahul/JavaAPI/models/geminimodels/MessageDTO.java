package com.rahul.JavaAPI.models.geminimodels;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
public class MessageDTO {
    private String userMessage;
    private String botResponse;
    private String sessionId;
    private Date timestamp;
    @MongoId
    private String messageId;
    private String user;
}
