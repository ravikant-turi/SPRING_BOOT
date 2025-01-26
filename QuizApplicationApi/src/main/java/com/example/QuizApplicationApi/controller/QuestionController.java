package com.example.QuizApplicationApi.controller;

import com.example.QuizApplicationApi.entity.Question;
import com.example.QuizApplicationApi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @GetMapping("/getAllQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>>getAllQuestionByCategory(@PathVariable String category){
        return this.questionService.getQuestionByCategory(category);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<Question> addQuestion(@RequestBody  Question question){
       return this.questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Integer questionId){
        this.questionService.deleteQuestionById(questionId);
        return new ResponseEntity<>("successfully Deleted", HttpStatus.OK);

    }
    @PutMapping("/update/{questionId}")
    private ResponseEntity<Question>updateQuestion(@RequestBody Question question,
                                                   @PathVariable Integer questionId){
        return new  ResponseEntity<>(this.questionService.updateQuestion(question,questionId),HttpStatus.OK);
    }

}
