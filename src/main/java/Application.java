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
		
		doDeposit(bank, client1,5992.98);
		doDeposit(bank, client2,2543.86);
		doDeposit(bank, client2,500.0);
		
		System.out.println("*** The client "+client1+ " as "+ bank.getClientAmount(client1) + " in his bank account.");
		System.out.println("*** The client "+client2+ " as "+ bank.getClientAmount(client2) + " in his bank account.");
		
		/**
		 * 
		 * US 2:
		 * In order to retrieve some or all of my savings
		 *	As a bank client
		 * 
		 */
		doWithdrawl(bank, client1, 100.00);
		doWithdrawl(bank, client1, 200.00);
		doWithdrawl(bank, client2, 500.00);
		
		System.out.println("*** The client "+client1+ " as "+ bank.getClientAmount(client1) + " in his bank account.");
		System.out.println("*** The client "+client2+ " as "+ bank.getClientAmount(client2) + " in his bank account.");
	}

	private static void doWithdrawl(Bank bank, String client1, double amount) throws ForbidenTransaction {
		System.out.println("The client "+client1+ "  do a "+amount +" withdrawl.");
		bank.withdrawalClient(client1, amount);
	}

	private static void doDeposit(Bank bank, String client1, double amount) throws ForbidenTransaction {
		System.out.println("The client "+client1+ "  do a "+amount +" deposite.");
		bank.depositClient(client1, amount);
	}
	

}
