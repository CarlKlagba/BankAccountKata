package bank;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bank.exception.ForbidenTransaction;

public class Bank {
	
	private Bank() {};
	
	Map<String, Account> clientAccounts = new HashMap<>();
	Map<String, List<Transaction>> clientsHistories= new HashMap<>();
	
	private static Bank INSTANCE=new Bank();
	
	public static Bank getInstance() {
		return INSTANCE;
	}

	public void createClientAccount(String client) {
		clientAccounts.put(client, new Account());
		clientsHistories.put(client, new ArrayList<Transaction>());
	}

	public BigDecimal getClientBalance(String client) {
		return clientAccounts.get(client).getBalance();
	}
	
	public void depositClient(String client, String deposit) throws ForbidenTransaction {
		clientAccounts.get(client).deposit(deposit);
		clientsHistories.get(client)
			.add(new Transaction("DEPOSIT", Instant.now(), deposit, getClientAccount(client).getBalance()));
	}
	
	public void withdrawalClient(String client, String withdrawal) throws ForbidenTransaction {
		clientAccounts.get(client).withdrawal(withdrawal);
		clientsHistories.get(client)
			.add(new Transaction("WITHDRAWAL", Instant.now(), withdrawal, getClientAccount(client).getBalance()));
	}

	public Account getClientAccount(String client) {
		return clientAccounts.get(client);
	}

	public List<Transaction> getClientHistory(String client) {
		return clientsHistories.get(client);
	}

	public void printClientHistory(String client1) {
		System.out.println("++++Client "+ client1+" transactions:");
		clientsHistories.get(client1).stream()
			.forEach(transaction -> System.out.println(transaction) );
		System.out.println("current balance: " + clientAccounts.get(client1).balance.toString());
	}

	
}
