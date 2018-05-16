package org.domain;

import java.time.LocalDate;

public class DepositMoneyIntoAccount {

	private Currency amount;
	private LocalDate date;
	
	public DepositMoneyIntoAccount(Currency amount, LocalDate date) {
		this.amount = amount;
		this.date = date;
		
	}
	
	public Currency getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}
}
