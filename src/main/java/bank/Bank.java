package bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import bank.exception.ForbidenTransaction;

public class Bank {
	
	private Bank() {};
	
	Map<String, Account> accounts = new HashMap<>();
	
	private static Bank INSTANCE=new Bank();
	
	public static Bank getInstance() {
		return INSTANCE;
	}

	public void createClientAccount(String client) {
		accounts.put(client, new Account());
	}

	public BigDecimal getClientBalance(String client) {
		return accounts.get(client).getBalance();
	}
	
	public void depositClient(String client, String deposit) throws ForbidenTransaction {
		accounts.get(client).deposit(deposit);
	}
	
	public void withdrawalClient(String client, String withdrawal) throws ForbidenTransaction {
		accounts.get(client).withdrawal(withdrawal);
	}

	public Account getClientAccount(String client) {
		return accounts.get(client);
	}

	
}
