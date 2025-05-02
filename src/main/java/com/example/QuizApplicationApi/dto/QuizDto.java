package com.example.QuizApplicationApi.dto;

import com.example.QuizApplicationApi.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface   QuizDto  extends JpaRepository<Quiz,Integer>{
}
