package com.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.entity.BankAccount;
import com.bootcamp.service.BankAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping("/addBA")
	public Mono<BankAccount> saveBA (@RequestBody BankAccount bk){
		return bankAccountService.save(bk);
	}
	
	@GetMapping("/allBA")
	public Flux<BankAccount> allBA (){
		return  bankAccountService.allBankAccount();
	}
	
	@GetMapping("/getDNI/{dniCustomer}")
		public Mono<BankAccount> findDNI(@PathVariable String dniCustomer){
		return bankAccountService.findDNI(dniCustomer);
	
	}
	

}
