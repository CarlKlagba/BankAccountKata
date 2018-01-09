package bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
	
	List<Transaction> transactions = new ArrayList<>();
	
	public void addDeposit(String amount, LocalDate date) {
		transactions.add(new Transaction(amount, date));
	}

	public void addWithdrawal(String amount, LocalDate date) {
		transactions.add(new Transaction("-"+amount, date));
	}

	public List<Transaction> getAllTransactions() {
		return transactions;
	}

}
