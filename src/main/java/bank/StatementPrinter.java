package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static java.time.format.DateTimeFormatter.ofPattern;

public class StatementPrinter {

	private Printer printer;
	
	private static final String HEADER = "DATE | AMOUNT | BALANCE";
	
	public StatementPrinter(Printer printer) {
		this.printer = printer;
	}

	public void printStatement(List<Transaction> transactions) {
		printer.printLine(HEADER);
		BigDecimal balance = new BigDecimal("0.00");
		for (Transaction transaction : transactions) {
			balance = balance.add(transaction.getAmount());
			printer.printLine( 
				transaction.getLocalDate().format(ofPattern("dd/MM/yyyy")) 
				+ " | " + transaction.getAmount() 
				+ " | " + balance.toString());
		}
		
//		transactions.stream()
//			.map(t -> new StatementLine(t.getLocalDate(), new BigDecimal(t.getAmount())))
//			.reduce((acc, sl) -> {
//				
//				StatementLine sl
//				return 
//			});
		
	}
	
	
	public class StatementLine{
		
		private LocalDate localDate;
		private BigDecimal amount;
		private BigDecimal balance;
		
		
		public StatementLine(LocalDate localDate, BigDecimal amount ) {
			this.localDate = localDate;
			this.amount = amount;			
		}
		public StatementLine(LocalDate localDate, BigDecimal amount, BigDecimal balance ) {
			this.localDate = localDate;
			this.amount = amount;
			this.balance = balance;
		}
		@Override
		public String toString() {
			return localDate.format(ofPattern("dd/MM/yyyy")) 
					+ " | " + amount.toString() 
					+ " | " + balance.toString();
		}
		public BigDecimal getBalance() {
			return balance;
		}
		
	}
}
