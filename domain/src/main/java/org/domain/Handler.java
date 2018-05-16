package org.domain;

import org.bootstrap.Statement;
import org.domain.aggregate.Account;
import org.domain.event.MoneyDepositedIntoAccount;

public class Handler {

	private Account account;

	public Handler(Account account) {
		this.account = account;
	}

	public void handle(DepositMoneyIntoAccount deposit) {
		account.apply(new MoneyDepositedIntoAccount(deposit.getAmount(), deposit.getDate()));
	}

	public Statement handle(PrintAccountStatement print) {
		throw new UnsupportedOperationException();
	}

}
