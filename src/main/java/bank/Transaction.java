package bank;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {
	private TransactionType type;
	private Instant date;
	private String amount;
	private BigDecimal balance;
	
	public Transaction(TransactionType type, Instant date, String amount, BigDecimal balance) {
		this.type = type;
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public TransactionType getTypeTransaction() {
		return type;
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
		return "Transaction [typeTransaction=" + type + ", date=" + date.toString() + ", amount=" + amount
				+ ", balance=" + balance.toString() + "]";
	}

	
}
