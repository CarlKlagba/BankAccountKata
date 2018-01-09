package bank;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {
	private static final LocalDate DATE = LocalDate.of(2000, 1, 1);
	@Mock
	private TransactionRepository transactionRepository;
	@Mock
	private StatementPrinter statementPrinter;
	
	
	private Account account;
	
	@Before
	public void initialize() {
		account = new Account(transactionRepository, statementPrinter);
	}
	
	@Test
	public void deposit_should_store_a_transaction() throws Exception {
		
		account.deposit("100", DATE);
		
		verify(transactionRepository).addDeposit("100", DATE);
	}
	
	@Test
	public void withdrawal_should_store_a_transaction() throws Exception {
		
		account.withdrawal("100", DATE);
		
		verify(transactionRepository).addWithdrawal("100", DATE);
	}
	
	@Test
	public void printStatement_should_print_the_list_account_transactions() throws Exception {
		List<Transaction> transactions = Arrays.asList(new Transaction("100", DATE));
		when(transactionRepository.getAllTransactions()).thenReturn(transactions);
		
		account.deposit("100", DATE);
		
		account.printStatement();
		
		verify(statementPrinter).printStatement(transactions);
	}
	
}
