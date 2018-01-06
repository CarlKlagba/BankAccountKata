package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;

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
		checkClientBalace(bank, "client1", "0.0");
	}
	
	@Test
	public void deposit_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", "56.79");
		
		checkClientBalace(bank, "client1", "56.79");
	}
	
	@Test
	public void multiple_deposits_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", "90.9");
		bank.depositClient("client1", "10.10");
		bank.depositClient("client1", "22.17");
		
		checkClientBalace(bank, "client1", "123.17");
	}
	
	@Test
	public void deposit_amount_for_multiple_clients() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		bank.createClientAccount("client2");
		
		bank.depositClient("client1", "56.79");
		bank.depositClient("client2", "2560.00");
		
		checkClientBalace(bank, "client1", "56.79");
		checkClientBalace(bank, "client2", "2560.00");
	}
	
	@Test
	public void withdrawal_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", "555.55");
		
		checkClientBalace(bank, "client1", "-555.55");
	}
	
	@Test
	public void multiple_withdrawals_amount_for_client() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", "90.9");
		bank.withdrawalClient("client1", "10.10");
		bank.withdrawalClient("client1", "22.17");
		
		checkClientBalace(bank, "client1", "-123.17");
	}
	
	@Test
	public void withdrawals_amount_for_multiple_clients() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		bank.createClientAccount("client2");
		
		bank.withdrawalClient("client1", "56.79");
		bank.withdrawalClient("client2", "2560.00");
		
		checkClientBalace(bank, "client1", "-56.79");
		checkClientBalace(bank, "client2", "-2560.00");
	}
	
	
	private void checkClientBalace(Bank bank, String client, String expected) {
		assertTrue( bank.getClientBalance(client).compareTo(new BigDecimal(expected)) == 0);
	}
}
