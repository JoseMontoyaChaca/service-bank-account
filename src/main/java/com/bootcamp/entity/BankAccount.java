package com.bootcamp.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class BankAccount {
	
	@NotNull(message = "The card number can't be empty")
	@Size(min = 16 , max = 16)
	private Long  cardNumber;
//	@NotNull(message = "The holder can't be empty")
	private String holder;
	
	private String dniCustomer;
	
	
	
	
}