package bank;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TransactionRepositoryTest {
	private static final BigDecimal AMOUNT = new BigDecimal("100");
	private static final LocalDate DATE = LocalDate.of(2000, 1, 1);
	TransactionRepository transactionRepository;
	
	@Before
	public void initialize() {
		transactionRepository = new TransactionRepository();
	}
	
	@Test
	public void addDeposit_should_add_a_deposit_transaction(){
		transactionRepository.addDeposit(AMOUNT, DATE);
		
		List<Transaction> allTransactions = transactionRepository.getAllTransactions();
		assertThat(allTransactions.size(), equalTo(1) );
		assertThat(allTransactions.get(0), CoreMatchers.is(transaction(AMOUNT, DATE)) );
	}
	
	
	@Test
	public void addWithdrawal_should_add_a_withdrawal_transaction(){
		transactionRepository.addWithdrawal(AMOUNT, DATE);
		
		List<Transaction> allTransactions = transactionRepository.getAllTransactions();
		assertThat(allTransactions.size(), equalTo(1) );
		assertThat(allTransactions.get(0), CoreMatchers.is(transaction(AMOUNT.negate(), DATE)) );
	}
	
	private Transaction transaction(BigDecimal amount, LocalDate localDate) {
		return new Transaction(amount, localDate);
	}
	

}
