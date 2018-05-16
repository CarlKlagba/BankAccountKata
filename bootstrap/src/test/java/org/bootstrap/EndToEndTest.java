package org.bootstrap;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.domain.DepositMoneyIntoAccount;
import org.domain.Handler;
import org.domain.PrintAccountStatement;
import org.domain.aggregate.Account;
import org.infrastructure.MyCurrency;
import org.junit.Test;

public class EndToEndTest {
	
	@Test
	public void acceptenceTest() {
		/*
		 * Step 1 - Test printing the account statement when only one deposit happened with NO CQRS concept
		 * */
		//Given
		Handler handler = new Handler(new Account());
		Statement expectedStatement = new Statement("01/01/2000 || +500.00 || 2500.00");
		
		
		DepositMoneyIntoAccount deposit1 = new DepositMoneyIntoAccount(new MyCurrency("2500.00"), LocalDate.of(2000, 1, 1));
		PrintAccountStatement print = new PrintAccountStatement();
		
		handler.handle(deposit1);
		
		//WHEN
		Statement statement = handler.handle(print);
		
		//THEN
		assertEquals(expectedStatement, statement);
		
	}
}
