package bank;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.anyString;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterTest {
	private static final LocalDate DATE = LocalDate.of(2000, 1, 1);
	
	@Mock
	private Printer printer;
	
	private StatementPrinter statementPrinter;
	
	@Before
	public void initialize() {
		statementPrinter = new StatementPrinter(printer);
	}
	
	@Test
	public void printStatement_should_print_each_transaction() throws Exception {
		doNothing().when(printer).printLine(anyString());
		
		List<Transaction> transactions = Arrays.asList(new Transaction("100", DATE));
		statementPrinter.printStatement(transactions);
		
		verify(printer).printLine("DATE | AMOUNT | BALANCE");
		verify(printer).printLine("01/01/2000 | 100 | BALANCE");
	}
}
