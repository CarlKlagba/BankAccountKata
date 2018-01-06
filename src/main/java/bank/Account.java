package bank;

import bank.exception.ForbidenTransaction;

public class Account {
	
	double amount;
	
	
	
	public Account() {
		this.amount = 0.0;
	}
	
	public Account(double amount) {
		this.amount = amount;
	}


	public void deposit(double d) throws ForbidenTransaction {
		if(d<0.0) {
			throw new ForbidenTransaction();
		}
		amount +=  d;
	}



	public double getAmount() {
		return amount;
	}

	public void withdrawal(double d) throws ForbidenTransaction {
		if(d<0.0) {
			throw new ForbidenTransaction();
		}
		amount -=  d;
	}
	

}
