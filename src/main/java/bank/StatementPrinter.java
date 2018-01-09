package bank;

import java.util.List;

public class StatementPrinter {

	private Printer printer;
	
	private static final String HEADER = "DATE | AMOUNT | BALANCE";
	
	public StatementPrinter(Printer printer) {
		this.printer = printer;
	}

	public void printStatement(List<Transaction> transactions) {
		printer.printLine(HEADER);
		//transactions.stream().forEach(action);
	}

}
