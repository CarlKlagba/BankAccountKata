package bank;

import static org.junit.Assert.*;

import org.junit.Test;

import bank.exception.ForbidenTransaction;

public class AccountTest {
	@Test
	public void deposit1_in_emptyAccount() throws Exception {
		Account account = new Account();
		
		account.deposit(1.0);
		
		assertEquals(1.0, account.getAmount(), 0.009);
	}
	
	@Test
	public void deposit_in_Account_with_existing_Money() throws Exception {
		Account account = new Account(5512.34);
		
		account.deposit(47.12);
		
		assertEquals(5559.46, account.getAmount(), 0.009);
	}
	
	@Test
	public void deposit_in_deficitAccount() throws Exception {
		Account account = new Account(-70.0);
		
		account.deposit(90.9);
		
		assertEquals(20.9, account.getAmount(), 0.009);
	}
	
	@Test
	public void multiple_deposit() throws Exception{
		Account account = new Account();
		
		account.deposit(90.9);
		account.deposit(10.10);
		account.deposit(22.17);
		
		assertEquals(123.17, account.getAmount(), 0.009);
	}
	
	@Test(expected = ForbidenTransaction.class)
	public void negatif_deposits_are_forbiden() throws Exception {
		Account account = new Account();
		
		account.deposit(-199.0);
	}
	
	
	@Test
	public void withdrawal_in_empty_account() throws Exception {
		Account account = new Account();
		
		account.withdrawal(555.55);
		
		assertEquals(-555.55, account.getAmount(), 0.009);
	}
	
	@Test
	public void withdrawal_in_account_with_existing_Money() throws Exception {
		Account account = new Account(1555.55);
		
		account.withdrawal(555.55);
		
		assertEquals(1000.00, account.getAmount(), 0.009);
	}
	
	@Test
	public void multiple_withdrawal_in_account() throws Exception {
		Account account = new Account(1555.55);
		
		account.withdrawal(555.55);
		account.withdrawal(150.00);
		account.withdrawal(20.50);
		
		assertEquals(829.50, account.getAmount(), 0.009);
	}
	
	@Test(expected = ForbidenTransaction.class)
	public void  negatif_withdrawal_are_forbiden() throws Exception {
		Account account = new Account();
		
		account.withdrawal(-555.55);
	}
	
}
