package com.example.QuizApplicationApi.service;
import com.example.QuizApplicationApi.dto.QuestionDto;
import com.example.QuizApplicationApi.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDto questionDto;
    public ResponseEntity<List<Question>> getAllQuestion() {

        return new ResponseEntity<>(this.questionDto.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Question>>getQuestionByCategory(String category) {
       try {
        return new ResponseEntity<>(this.questionDto.findByCategory(category),HttpStatus.OK);

       }
       catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(this.questionDto.findByCategory(category),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
       Question question1= this.questionDto.save(question);
        return new ResponseEntity<>(question1,HttpStatus.CREATED);
    }

    public void deleteQuestionById(Integer questionId) {
        Question question=this.questionDto.findById(questionId).orElseThrow(()-> new RuntimeException("not Found by this question"+questionId));
        this.questionDto.delete(question);

    }

    public Question updateQuestion(Question question,Integer questionId) {

        Question toupdatequestion=questionDto.findById(questionId).orElseThrow(()->new RuntimeException("Not Found at Id" + questionId));
//        toupdatequestion.setQuestionId(question.getQuestionId());
        toupdatequestion.setCategory(question.getCategory());
        toupdatequestion.setDifficulty_level(question.getDifficulty_level());
        toupdatequestion.setOption1(question.getOption1());
        toupdatequestion.setOption2(question.getOption2());
        toupdatequestion.setOption3(question.getOption3());
        toupdatequestion.setOption4(question.getOption4());
        toupdatequestion.setRight_answer(question.getRight_answer());
        toupdatequestion.setTitle(question.getTitle());

//
        return this.questionDto.save(toupdatequestion);


    }
}
