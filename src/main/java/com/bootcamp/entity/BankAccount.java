package com.bootcamp.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;

@Data
@Document
public class BankAccount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;	
	private String nameAccount;
	private Long  cardNumber;
	private Holder holder;
	private  Signatory signatory;
	private String dniCustomer;
	private double balance;
	private String idBank;
		
}