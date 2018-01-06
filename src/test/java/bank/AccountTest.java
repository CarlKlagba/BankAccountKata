package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import bank.exception.ForbidenTransaction;

public class AccountTest {
	@Test
	public void deposit1_in_emptyAccount() throws Exception {
		Account account = new Account();
		
		account.deposit("1.00");
		
		String expected = "1.00";
		checkAccountBalace(account, expected);
	}

	
	
	@Test
	public void deposit_in_Account_with_existing_Money() throws Exception {
		Account account = new Account(new BigDecimal("5512.34"));
		
		account.deposit("47.12");
		
		checkAccountBalace(account, "5559.46");
	}
	
	
	@Test
	public void deposit_in_deficitAccount() throws Exception {
		Account account = new Account(new BigDecimal("-70.00"));
		
		account.deposit("90.9");
		
		checkAccountBalace(account, "20.9");
	}
	
	@Test
	public void multiple_deposit() throws Exception{
		Account account = new Account();
		
		account.deposit("90.9");
		account.deposit("10.10");
		account.deposit("22.17");
		
		checkAccountBalace(account, "123.17");
	}
	
	@Test(expected = ForbidenTransaction.class)
	public void negatif_deposits_are_forbiden() throws Exception {
		Account account = new Account();
		
		account.deposit("-199.0");
	}
	
	
	@Test
	public void withdrawal_in_empty_account() throws Exception {
		Account account = new Account();
		
		account.withdrawal("555.55");
		
		checkAccountBalace(account, "-555.55");
	}
	
	@Test
	public void withdrawal_in_account_with_existing_Money() throws Exception {
		Account account = new Account(new BigDecimal("1555.55"));
		
		account.withdrawal("555.55");
		
		checkAccountBalace(account, "1000.00");
	}
	
	@Test
	public void multiple_withdrawal_in_account() throws Exception {
		Account account = new Account(new BigDecimal("1555.55"));
		
		account.withdrawal("555.55");
		account.withdrawal("150.00");
		account.withdrawal("20.50");
		
		checkAccountBalace(account, "829.50");
	}
	
	@Test(expected = ForbidenTransaction.class)
	public void  negatif_withdrawal_are_forbiden() throws Exception {
		Account account = new Account();
		
		account.withdrawal("-555.55");
	}
	
	private void checkAccountBalace(Account account, String expected) {
		assertTrue( account.getBalance().compareTo(new BigDecimal(expected)) == 0);
	}
	
}
