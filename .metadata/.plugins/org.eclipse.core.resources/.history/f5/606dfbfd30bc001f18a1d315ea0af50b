package com.dl.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dl.Modle.QuestionWapper;
import com.dl.Modle.Questions;
import com.dl.Modle.Quiz;
import com.dl.Modle.Response;
import com.dl.Repo.QuizRepo;
import com.dl.Repo.Repo;

@Service
public class QuizService {
	
	@Autowired
	QuizRepo quizRepo;
	
	@Autowired
	Repo repo;


	public ResponseEntity<String> createQuiz(String subject, int numQ, String title) {
		List<Questions> questions = repo.findRamdomQuestionsBySubject(subject,numQ);
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizRepo.save(quiz);
		return new ResponseEntity<String>("success",HttpStatus.CREATED);
	}


	public ResponseEntity<List<QuestionWapper>> getQuizQuestion(Integer id) {
		Optional<Quiz> quiz= quizRepo.findById(id);
		List<Questions> questionForDb = quiz.get().getQuestions();
		List<QuestionWapper> questionsForUser = new ArrayList<>();
		for(Questions q : questionForDb) {
			QuestionWapper qw = new QuestionWapper(q.getId(),q.getQuestion(),q.getOption1(),q.getOption2(),q.getOption3());
			
			questionsForUser.add(qw);
			
		}
		
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}


	public ResponseEntity<Integer> getScore(Integer id, List<Response> responses) {
		Quiz quiz=quizRepo.findById(id).get();
		List<Questions> questions=quiz.getQuestions();
		int right =0;
		int i =0;
		for(Response response: responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer()))
			   right++;
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
