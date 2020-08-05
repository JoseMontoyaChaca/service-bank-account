package com.bootcamp.service;

import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.entity.BankAccount;
import com.bootcamp.repository.BankAccountRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountRepository repository;

	
	//check the available balance
	public Mono<BankAccount> checkAvailableBalance (String dniCustomer, String accountNumber) {
		return repository.findByDNIAndAccountNumberCustomer(dniCustomer, accountNumber);
	}
	
	
		
	//Deposit
	public Mono<Void> depositBankAccount ( String dniCustomer, String accountNumber, double amount) {
		Mono<BankAccount> mono = repository.findByDNIAndAccountNumberCustomer(dniCustomer, accountNumber)
				.switchIfEmpty(Mono.error(new NotFound()))
				.map(document -> {
					document.setBalance(document.getBalance() + amount);
					return document;
				});
		return repository.saveAll(mono).then();
	}
	
	
	//Withdrawal
	public Mono<Void> withdrawaltBankAccount ( String dniCustomer, String accountNumber, double AmountToWithdraw) {
		Mono<BankAccount> mono = repository.findByDNIAndAccountNumberCustomer(dniCustomer, accountNumber)
				.switchIfEmpty(Mono.error(new NotFound()))
				.map(document -> {
						if (document.getBalance() < AmountToWithdraw) {
							return null;
						}
						document.setBalance(document.getBalance() - AmountToWithdraw);
							return document;
					});
							return repository.saveAll(mono).then();
	}
	


	//CRUD
	public Mono<BankAccount> save( BankAccount bk) {
		return repository.save(bk);
	}
	
	public Mono<Void> update  ( final BankAccount bank)	{
		return findById(bank.getId())
				.flatMap(repository::save)
				.thenEmpty(Mono.empty());
	}

	public Mono<Void> delete	(int id){
		return findById(id)
				.flatMap(repository::delete);
	}
	
	
	public Mono<BankAccount> findById (final int id){
		return repository.findById(id);
	}

	public Flux<BankAccount> allBankAccount() {
		return repository.findAll();			
	}

	public Flux<BankAccount> findDNI(String dniCustomer){
		return repository.findDNI(dniCustomer);
	}
	
	public Mono<BankAccount> findByDNICustomerAccountNumber (String dniCustomer) {
		return repository.findByDNICustomer(dniCustomer);
		
	}
	
	public Mono<BankAccount> findbyHolder(String holder){
		 Flux<BankAccount> bank = repository.findAll().filter(h -> h.getHolder().equals(holder));
		 return Mono.from(bank);
	}
	
	

	
}
