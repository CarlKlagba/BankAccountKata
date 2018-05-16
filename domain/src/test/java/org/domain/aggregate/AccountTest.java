package org.domain.aggregate;

import static org.junit.Assert.assertEquals;

import org.domain.Currency;
import org.junit.Test;

public class AccountTest {
	private Account sut;
	
	@Test
	public void should_increase_the_balance_when_a_deposit_is_made() {
		//GIVEN
		sut = new Account();
		
		//WHEN
		
		//THEN
		assertEquals(sut.balance(), new SpyCurrency());
	}
	
	
	
	private class SpyCurrency implements Currency {
		
	}
}
