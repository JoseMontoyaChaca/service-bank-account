package com.bootcamp.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.entity.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount, Integer> {

	@Query("{dniCustomer:?0}")
	Flux<BankAccount> findDNI(String dniCustomer);
	
	@Query(value =  "{dniCustomer:?0}" )
	Mono<BankAccount> findByDNICustomer (String dniCustomer);

	@Query("{$and:[{dniCustomer:?0},{accountNumber:?1}]}")
	Mono<BankAccount> findByDNIAndAccountNumberCustomer (String dniCustomer,String accountNumber);

	@Query(value =  "{$and:[{dniCustomer:?0},{accountNumber:?1}]}" , fields = "{'id':3 , 'holder':3 }" )
	Mono<BankAccount> checkBalanceByDNIAndAccountNumber (String dniCustomer,String accountNumber);
	
}
