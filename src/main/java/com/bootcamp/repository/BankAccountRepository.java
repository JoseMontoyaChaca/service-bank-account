package com.bootcamp.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.entity.BankAccount;

import reactor.core.publisher.Mono;


@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, Integer> {

	@Query("{dniCustomer:?0}")
	Mono<BankAccount> findDNI(String dniCustomer);

	
}
