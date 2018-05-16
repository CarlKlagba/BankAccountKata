package org.domain;

import java.time.LocalDate;

import org.domain.aggregate.Account;
import org.domain.event.MoneyDepositedIntoAccount;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class HandlerTest {
	private Handler sut;
	private Account account = mock(Account.class);
	private Currency amount = mock(Currency.class);
	
	@Test
	public void should_deposit_money_when_the_client_ask_for_a_deposit() {
		sut = new Handler(account);
		DepositMoneyIntoAccount depositMoneyIntoAccount = new DepositMoneyIntoAccount(amount, LocalDate.of(2000, 1, 1));
		
		sut.handle(depositMoneyIntoAccount);
		
		verify(account).apply( any(MoneyDepositedIntoAccount.class));
	}
	
	
}
