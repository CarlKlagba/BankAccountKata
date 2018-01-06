package bank;

import java.math.BigDecimal;

import bank.exception.ForbidenTransaction;

public class Account {
	
	BigDecimal balance;
	
	
	
	public Account() {
		this.balance = new BigDecimal("0.00");
	}
	
	public Account(BigDecimal amount) {
		this.balance = amount;
	}


	public void deposit(String amount) throws ForbidenTransaction {
		BigDecimal amountBd=new BigDecimal(amount); 
		if(amountBd.signum()<0) {
			throw new ForbidenTransaction();
		}
		balance = balance.add(amountBd);
	}



	public BigDecimal getBalance() {
		return balance;
	}

	public void withdrawal(String amount) throws ForbidenTransaction {
		BigDecimal amountBd=new BigDecimal(amount); 
		if(amountBd.signum()<0) {
			throw new ForbidenTransaction();
		}
		balance = balance.subtract(amountBd);
	}
	

}
