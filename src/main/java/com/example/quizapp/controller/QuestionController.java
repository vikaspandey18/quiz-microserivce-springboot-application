package com.example.quizapp.controller;

import com.example.quizapp.entity.Question;
import com.example.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return ResponseEntity.status(HttpEntity.OK).body(questionService.getQuestionsByCategory(category));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.addQuestion(question));
    }

}
