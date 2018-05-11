package org.bootstrap;

import java.time.LocalDate;

import org.domain.Currency;
import org.junit.Test;

public class EndToEndTest {
	
	@Test
	public void acceptenceTest() {
		/*
		 * Step 1 - Test printing the account statement when only one deposit happended with NO CQRS concept
		 * */
		DepositMoneyIntoAccount deposit1 = new DepositMoneyIntoAccount(new MyCurrency("2500.00"), LocalDate.of(2000, 1, 1));
		PrintStatement print = new PrintAccountStatement();
		
		Handler commandHandler = new Handler();
		Handler.handle(deposit1);
		
		
		Statement statement = handler.handle(print);
		
	
		
	}
}
