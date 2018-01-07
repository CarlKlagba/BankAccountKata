package bank;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {
	private String typeTransaction;
	private Instant date;
	private String amount;
	private BigDecimal balance;
	
	public Transaction(String typeTransaction, Instant date, String amount, BigDecimal balance) {
		this.typeTransaction = typeTransaction;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public String getTypeTransaction() {
		return typeTransaction;
	}

	public Instant getDate() {
		return date;
	}

	public String getAmount() {
		return amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return "Transaction [typeTransaction=" + typeTransaction + ", date=" + date.toString() + ", amount=" + amount
				+ ", balance=" + balance.toString() + "]";
	}

	
}
