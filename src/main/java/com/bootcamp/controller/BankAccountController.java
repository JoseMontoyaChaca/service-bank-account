package com.bootcamp.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	
	//Check the available balance 
	@GetMapping("/checkBalance/{dniCustomer}/{accountNumber}")
	public Mono<BankAccount> checkAvailablebalance (@PathVariable String dniCustomer,@PathVariable String accountNumber){
		return bankAccountService.checkAvailableBalance(dniCustomer, accountNumber);
	}

	//CRUD	
	@PostMapping("/addBankAccount")
	public Mono<BankAccount> saveBankAccount (@RequestBody BankAccount bk){		
		return bankAccountService.save(bk);
	}
	
	@PutMapping("/updateBankAccount")
	public Mono<Void> update	(@Valid @RequestBody final BankAccount bank){
		return bankAccountService.update(bank);
	}
	
	@DeleteMapping( "{id}")
	public Mono<Void> delete	(@PathVariable int id){
		return bankAccountService.delete(id);
	}
	
	@GetMapping("/{id}")
	public Mono<BankAccount> findById (@PathVariable int id){
		return bankAccountService.findById(id);
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

	@GetMapping("/{dniCustomer}")
	public Mono<BankAccount> findByDNICustomerAccountNumber(@PathVariable String dniCustomer){
		return bankAccountService.findByDNICustomerAccountNumber(dniCustomer);	
	}
	
	
	

}
