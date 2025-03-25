package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.Modle.QuestionWapper;
import com.dl.Modle.Response;
import com.dl.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String subject,@RequestParam int numQ,@RequestParam String title){
		return quizService.createQuiz(subject,numQ,title);
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWapper>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestion(id);
		
		
	} 
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> sumbitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizService.getScore(id,responses);
		
	}
	

}
