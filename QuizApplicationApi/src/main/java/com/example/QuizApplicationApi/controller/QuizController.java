package com.example.QuizApplicationApi.controller;


import com.example.QuizApplicationApi.entity.Question;
import com.example.QuizApplicationApi.entity.QuestionWrapper;
import com.example.QuizApplicationApi.entity.Quiz;
import com.example.QuizApplicationApi.entity.Response;
import com.example.QuizApplicationApi.service.QuestionService;
import com.example.QuizApplicationApi.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;



    //    http://localhost:8080/api/quiz/create?category=java&noOfQuestion=5&title=Jquiz
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Integer noOfQuestion, @RequestParam String title){

        return this.quizService.createQuiz(category,noOfQuestion,title);

    }
    @GetMapping("/get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer quizId){

        return  this.quizService.getQuestions(quizId);

    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> getResult(@PathVariable Integer id,@RequestBody List<Response> responses){
        return this.quizService.calculateResult(id,responses);
    }





}
