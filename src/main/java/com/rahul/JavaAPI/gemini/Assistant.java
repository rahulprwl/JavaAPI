package com.rahul.JavaAPI.gemini;

import dev.langchain4j.service.SystemMessage;

public interface Assistant {
    @SystemMessage("You are a helpful customer support agent for a Java application.")
    String chat(String userMessage);
}