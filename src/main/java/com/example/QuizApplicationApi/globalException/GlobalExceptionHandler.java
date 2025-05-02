package com.example.QuizApplicationApi.globalException;

import com.example.QuizApplicationApi.Exception.QuestionNotFoundException;
import com.example.QuizApplicationApi.Exception.QuizNotFoundException;
import com.example.QuizApplicationApi.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(QuizNotFoundException.class)
//    public ResponseEntity<String> handleQuizNotFoundException(QuizNotFoundException ex){
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler(QuizNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleQuizNotFoundException(QuizNotFoundException ex) {

        ErrorResponse response=new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleQuestionNotFoundException(QuestionNotFoundException ex){
        ErrorResponse errorResponse=new ErrorResponse(
                LocalDateTime.now(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
