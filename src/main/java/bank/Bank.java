package bank;

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

	public double getClientAmount(String client) {
		return accounts.get(client).getAmount();
	}
	
	public void depositClient(String client, double deposit) throws ForbidenTransaction {
		accounts.get(client).deposit(deposit);
	}
	
	public void withdrawalClient(String client, double withdrawal) throws ForbidenTransaction {
		accounts.get(client).withdrawal(withdrawal);
	}

	public Account getClientAccount(String client) {
		return accounts.get(client);
	}

	
}
