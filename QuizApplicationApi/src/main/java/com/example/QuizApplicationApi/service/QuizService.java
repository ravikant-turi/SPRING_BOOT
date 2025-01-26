package com.example.QuizApplicationApi.service;

import com.example.QuizApplicationApi.dto.QuestionDto;
import com.example.QuizApplicationApi.dto.QuizDto;
import com.example.QuizApplicationApi.entity.Question;
import com.example.QuizApplicationApi.entity.QuestionWrapper;
import com.example.QuizApplicationApi.entity.Quiz;
import com.example.QuizApplicationApi.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private QuestionDto questionDto;


     @Autowired
     private QuizDto quizDto;
    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestion, String title) {
        List<Question>questionList=this.questionDto.findRandomQuestionsByCategory(category,noOfQuestion);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionList(questionList);
        quizDto.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }
    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer quizId){

        Optional<Quiz>quiz=quizDto.findById(quizId);
        List<Question> questionFromDb=quiz.get().getQuestionList();
        List<QuestionWrapper> questionForUser=new ArrayList<>();

        for (Question q:questionFromDb){
            QuestionWrapper qw=new QuestionWrapper(q.getQuestionId(),q.getTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(qw);
        }

        return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        Quiz quiz=this.quizDto.findById(id).get();
        List<Question>questions=quiz.getQuestionList();
        int right=0;
        int i=0;
        for (Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRight_answer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
