package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

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
	
	@Test
	public void get_client_history_when_empty() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(0, history.size());
	}
	
	@Test
	public void get_client_history_when_1_deposit() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", "56.79");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(1, history.size());
		
		checkTransaction(history.get(0), "DEPOSIT", "56.79", "56.79");
	}
	
	@Test
	public void get_client_history_when_multiple_deposits() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", "56.79");
		bank.depositClient("client1", "2000.00");
		bank.depositClient("client1", "1200.00");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(3, history.size());
		
		checkTransaction(history.get(0), "DEPOSIT", "56.79", "56.79");
		checkTransaction(history.get(1), "DEPOSIT", "2000.00", "2056.79");
		checkTransaction(history.get(2), "DEPOSIT", "1200.00", "3256.79");
	}
	
	
	@Test
	public void get_client_history_when_1_withdrawal() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", "56.79");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(1, history.size());
		
		checkTransaction(history.get(0), "WITHDRAWAL", "56.79", "-56.79");
	}
	
	@Test
	public void get_client_history_when_multiple_withdrawals() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.withdrawalClient("client1", "56.79");
		bank.withdrawalClient("client1", "2000.00");
		bank.withdrawalClient("client1", "1200.00");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(3, history.size());
		
		checkTransaction(history.get(0), "WITHDRAWAL", "56.79", "-56.79");
		checkTransaction(history.get(1), "WITHDRAWAL", "2000.00", "-2056.79");
		checkTransaction(history.get(2), "WITHDRAWAL", "1200.00", "-3256.79");
	}
	
	@Test
	public void get_client_history_when_multiple_transactions() throws Exception {
		Bank bank = Bank.getInstance();
		bank.createClientAccount("client1");
		
		bank.depositClient("client1", "100.00");
		bank.withdrawalClient("client1", "2000.00");
		bank.depositClient("client1", "400.00");
		bank.withdrawalClient("client1", "1200.00");
		bank.depositClient("client1", "4700.00");
		
		List<Transaction> history = bank.getClientHistory("client1");
		assertEquals(5, history.size());
		
		checkTransaction(history.get(0), "DEPOSIT", "100.00", "100.00");
		checkTransaction(history.get(1), "WITHDRAWAL", "2000.00", "-1900.00");
		checkTransaction(history.get(2), "DEPOSIT", "400.00", "-1500.00");
		checkTransaction(history.get(3), "WITHDRAWAL", "1200.00", "-2700.00");
		checkTransaction(history.get(4), "DEPOSIT", "4700.00", "2000.00");
	}
	
	private void checkTransaction(Transaction transaction, String typeTrancation, String amount, String balance) {
		assertEquals(amount, transaction.getAmount());
		assertTrue(transaction.getBalance().compareTo(new BigDecimal(balance)) == 0);
		assertEquals(typeTrancation, transaction.getTypeTransaction());
	}
	
	
	
	private void checkClientBalace(Bank bank, String client, String expected) {
		assertTrue( bank.getClientBalance(client).compareTo(new BigDecimal(expected)) == 0);
	}
}
