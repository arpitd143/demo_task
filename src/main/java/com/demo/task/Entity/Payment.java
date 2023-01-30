package com.demo.task.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class Payment {
	private Long transactionId;
	private Double amount;
	private String status; // status code : processing, pending, completed, rejected
	private String username;
	private String password;
	private String description;
	private Long customerId;
	private String currency;
	private String mobileNumber;
	private String country;
}
