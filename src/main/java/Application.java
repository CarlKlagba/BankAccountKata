import bank.Bank;
import bank.exception.ForbidenTransaction;

public class Application {

	public static void main(String[] args) throws ForbidenTransaction {
		/**
		 * US 1:
		 *	In order to save money
		 *	As a bank client
		 *	I want to make a deposit in my account 
		 */
		Bank bank = Bank.getInstance();
		String client1 = "client1";
		String client2 = "client2";
		
		bank.createClientAccount(client1);
		bank.createClientAccount(client2);
		
		bank.depositClient(client1, 5992.98);
		bank.depositClient(client2, 2543.86);
		
		System.out.println("*** The client "+client1+ " as "+ bank.getClientAmount(client1) + " in his bank account.");
		System.out.println("*** The client "+client2+ " as "+ bank.getClientAmount(client2) + " in his bank account.");
		
		
		

	}

}
