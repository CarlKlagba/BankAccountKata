package bank;

import java.time.LocalDate;


public class Account {
	
	
	
	private TransactionRepository transactionRepository;
	private StatementPrinter statementPrinter;

	public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter) {
		this.transactionRepository = transactionRepository;
		this.statementPrinter = statementPrinter;
	}
	



	public void deposit(String amount, LocalDate date) {
		transactionRepository.addDeposit(amount, date);
	}

	public void withdrawal(String amount, LocalDate date){
		transactionRepository.addWithdrawal(amount, date);
	}

	public void printStatement() {
		statementPrinter.printStatement(transactionRepository.getAllTransactions());
	}
	

}
