package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Test;

public class TransactionTest {
	@Test
	public void intialisation_Transaction() throws Exception {
	}
	
	@Test
	public void test_toString() throws Exception {
		Transaction transaction = new Transaction("DEPOSIT", Instant.now(), "1000", new BigDecimal("100"));
		
		System.out.println(transaction.toString());
		assertEquals("Transaction [typeTransaction=DEPOSIT, date=2018-01-06T17:50:48.953Z, amount=1000, balance=100]",
				transaction.toString());
	}
}
