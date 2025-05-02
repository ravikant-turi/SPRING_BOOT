package com.example.QuizApplicationApi.Exception;

public class QuizNotFoundException extends RuntimeException{

    public  QuizNotFoundException(String message){
        super(message);
    }
}
