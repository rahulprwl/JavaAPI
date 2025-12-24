package com.rahul.JavaAPI.repository;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.rahul.JavaAPI.models.geminimodels.MessageDTO;

@Document
public interface GeminiRepository extends MongoRepository<MessageDTO, String> {
    List<MessageDTO> findBySessionId(String sessionId);

}
