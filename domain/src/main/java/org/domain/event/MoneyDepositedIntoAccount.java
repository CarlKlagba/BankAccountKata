package org.domain.event;

import java.time.LocalDate;

import org.domain.Currency;

public class MoneyDepositedIntoAccount {

	private Currency amount;
	private LocalDate localDate;

	public MoneyDepositedIntoAccount(Currency amount, LocalDate localDate) {
		this.amount = amount;
		this.localDate = localDate;
	}

}
