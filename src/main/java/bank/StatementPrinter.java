package bank;

import java.math.BigDecimal;
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
	}
}
