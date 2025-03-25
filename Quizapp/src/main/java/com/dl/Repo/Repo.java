package com.dl.Repo;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dl.Modle.Questions;
@Repository
public interface Repo extends JpaRepository<Questions,Integer>{

	List<Questions> findBySubject(String subject);
	
	@Query(value = "SELECT * FROM questions q WHERE q.subject = :subject ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	//@Query(value = "SELECT * FROM questions q WHERE q.subject = :subject ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Questions> findRamdomQuestionsBySubject(String subject, int numQ);

}
 