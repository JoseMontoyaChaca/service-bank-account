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
	
	@PostMapping("/addBankAaccount")
	public Mono<BankAccount> save (@RequestBody BankAccount bk){
		
		
		return bankAccountService.save(bk);
	}
	
	@GetMapping("/findByHolder/{holder}")
	public Mono<BankAccount> findByHolder(@PathVariable String holder){
		return bankAccountService.findbyHolder(holder);
	}
	
	@GetMapping("/getAllBankAccount")
	public Flux<BankAccount> getAllBankAccount (){
		return  bankAccountService.allBankAccount();
	}
	
	@GetMapping("/getDNI/{dniCustomer}")
		public Flux<BankAccount> findDNI(@PathVariable String dniCustomer){
		return bankAccountService.findDNI(dniCustomer);
	
	}
	

}
