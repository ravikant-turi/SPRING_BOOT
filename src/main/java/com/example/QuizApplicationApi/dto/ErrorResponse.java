package com.example.QuizApplicationApi.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    public LocalDateTime timestamp;
    public String message;
    public int status;

    // Constructor
    public ErrorResponse(LocalDateTime timestamp, String message, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }


}
