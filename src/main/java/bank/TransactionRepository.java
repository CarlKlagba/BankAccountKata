package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	
	List<Transaction> transactions = new ArrayList<>();
	
	public void addDeposit(BigDecimal amount, LocalDate date) {
		transactions.add(new Transaction(amount, date));
	}

	public void addWithdrawal(BigDecimal amount, LocalDate date) {
		transactions.add(new Transaction(amount.negate(), date));
	}

	public List<Transaction> getAllTransactions() {
		return transactions;
	}

}
