package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private long accountNumber = 10000;
	public Bank() {
		// complete the function
		accounts = new LinkedHashMap<>();
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		return this.accounts.containsKey(accountNumber) ? this.accounts.get(accountNumber) : null;
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		accountNumber++;
		Account account = new CommercialAccount(company, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
        return accountNumber;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		accountNumber++;
		Account account = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
		accounts.put(accountNumber, account);
		
		return accountNumber;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		Account account = this.getAccount(accountNumber);
		
        return account != null ? account.validatePin(pin) : false;
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account = this.getAccount(accountNumber);
		
        return account != null ? account.getBalance() : -1l;
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account = this.getAccount(accountNumber);
		if(account != null) {
			account.creditAccount(amount);
		}
		
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account = this.getAccount(accountNumber);
		if(account != null) {
			return account.debitAccount(amount);
		}
		return false;
	}
}
