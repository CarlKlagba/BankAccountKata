package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.Instant;

import org.junit.Test;

public class TransactionTest {
	
	@Test
	public void test_toString() throws Exception {
		Transaction transaction = new Transaction(TransactionType.DEPOSIT, Instant.now(), "1000", new BigDecimal("100"));
		
		System.out.println(transaction.toString());
	}
}
