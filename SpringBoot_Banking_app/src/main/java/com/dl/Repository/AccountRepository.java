package com.dl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.Model.AccountModel;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {

}
