package bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankTest {
	@Test
	public void create_emptyAccount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		Account account = bank.getClientAccount("client1");
		assertNotNull(account);
	}
	
	@Test
	public void get_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		assertEquals(0.0, bank.getClientAmount("client1"), 0.0);
	}
	
	@Test
	public void deposit_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", 56.79);
		
		assertEquals(56.79, bank.getClientAmount("client1"), 0.0);
	}
	
	@Test
	public void multiple_deposits_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", 90.9);
		bank.depositClient("client1", 10.10);
		bank.depositClient("client1", 22.17);
		
		assertEquals(123.17, bank.getClientAmount("client1"), 0.0);
	}
	
	@Test
	public void deposit_amount_for_multiple_clients() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		bank.createClientAccount("client2");
		
		bank.depositClient("client1", 56.79);
		bank.depositClient("client2", 2560.00);
		
		assertEquals(56.79, bank.getClientAmount("client1"), 0.0);
		assertEquals(2560.00, bank.getClientAmount("client2"), 0.0);
	}
	
	@Test
	public void withdrawal_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", 555.55);
		
		assertEquals(-555.55, bank.getClientAmount("client1"), 0.0);
	}
	
	@Test
	public void multiple_withdrawals_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", 90.9);
		bank.withdrawalClient("client1", 10.10);
		bank.withdrawalClient("client1", 22.17);
		
		assertEquals(-123.17, bank.getClientAmount("client1"), 0.0);
	}
	
	@Test
	public void withdrawals_amount_for_multiple_clients() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		bank.createClientAccount("client2");
		
		bank.withdrawalClient("client1", 56.79);
		bank.withdrawalClient("client2", 2560.00);
		
		assertEquals(-56.79, bank.getClientAmount("client1"), 0.0);
		assertEquals(-2560.00, bank.getClientAmount("client2"), 0.0);
	}
	
}
