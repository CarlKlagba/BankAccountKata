package bank;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AcceptanceTest {
	@Mock
	private Printer printer;
	
	private Account account;
	private TransactionRepository transactionRepository;
	private StatementPrinter statementPrinter;
	
	@Before
	public void initialize() {
		transactionRepository = new TransactionRepository();
		statementPrinter = new StatementPrinter(printer);
		account = new Account(transactionRepository, statementPrinter);
	}
	
	@Test
	public void print_statement_should_print_all_the_operations_when_called() {
		
		account.deposit(new BigDecimal("2500.00"), LocalDate.of(2000, 1, 1));
		account.withdrawal(new BigDecimal("1000.00"), LocalDate.of(2000, 1, 2));
		account.deposit(new BigDecimal("500.00"), LocalDate.of(2000, 1, 10));
		
		account.printStatement();
		
		verify(printer).printLine("DATE | AMOUNT | BALANCE");
		verify(printer).printLine("01/01/2000 | 2500.00 | 2500.00");
		verify(printer).printLine("02/01/2000 | -1000.00 | 1500.00");
		verify(printer).printLine("10/01/2000 | 500.00 | 2000.00");
	}
}
