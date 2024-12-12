package com.dl.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dl.Modle.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
