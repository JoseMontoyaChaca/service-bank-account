package com.bootcamp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.bootcamp.entity.BankAccount;
import com.bootcamp.repository.BankAccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository repository;
	
	public Mono<BankAccount> save(@RequestBody BankAccount bk) {
		return repository.save(bk);
	}
	
	
	public Flux<BankAccount> allBankAccount() {
		return repository.findAll();
			
	}

	
	public Mono<BankAccount> findDNI(String dniCustomer){
		return repository.findDNI(dniCustomer);
	}
}
