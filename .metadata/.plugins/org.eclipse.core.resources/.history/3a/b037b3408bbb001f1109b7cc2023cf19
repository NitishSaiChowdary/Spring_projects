package com.dl.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dl.Modle.Questions;
import com.dl.Repo.Repo;
import com.dl.exception.ResourceNotFoundException;




@Service
public class QuestionService {
	@Autowired
	private Repo repo;

	public QuestionService(Repo repo) {
		super();
		this.repo = repo;
	}
	
	
	public List<Questions> getAllQuestion() {
		return repo.findAll();
	}

	public List<Questions> getQuestionBySubject(String subject) {
		
		return repo.findBySubject(subject);
	}

	
	public Questions createQuestion(Questions questions) {
		return repo.save(questions);
		
	}


	public Questions updateQuestion(@RequestBody Questions questions) { 	
		return repo.save(questions);
		
	}
	
	public void deleteQuestionById(Integer id) {
		repo.deleteById(id);
		
	}


	public Page<Questions> getByPaginationAndSort(String field, int offSet, int pageSize) {
		return repo.findAll(PageRequest.of(offSet, pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
	}


	public Questions getById(Integer id) {
		
		return repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("question", "Id", id));
	}


	public List<Questions> createListQuestion(List<Questions> questions) {
		
		return repo.saveAll(questions);
	}
	
	

}
