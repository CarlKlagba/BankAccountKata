package org.domain.aggregate;

import java.time.LocalDate;

import org.domain.event.MoneyDepositedIntoAccount;

public class Account {

	public void apply(MoneyDepositedIntoAccount event) {
		throw new UnsupportedOperationException();
	}

}
