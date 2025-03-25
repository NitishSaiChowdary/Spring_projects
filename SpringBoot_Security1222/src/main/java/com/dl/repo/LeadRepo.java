package com.dl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.model.LeadModel;


public interface LeadRepo extends JpaRepository<LeadModel,Integer>{

}
