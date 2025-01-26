package com.example.QuizApplicationApi.dto;

import com.example.QuizApplicationApi.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDto extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);


//    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY  LIMIT =:noOfQuestion",nativeQuery = true)
//    List<Question> findRandomQuestionsByCategory(String category, Integer noOfQuestion);@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY q.id LIMIT :noOfQuestion", nativeQuery = true)
//List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("noOfQuestion") Integer noOfQuestion);



    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY q.id LIMIT :noOfQuestion", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("noOfQuestion") Integer noOfQuestion);


}
