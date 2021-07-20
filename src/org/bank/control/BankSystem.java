package org.bank.control;

import org.bank.data.Database;
import org.bank.entity.Account;

public class BankSystem {
	
	private Database database;
	
	public BankSystem () {
		this.database = new Database();
	}
	
	public boolean register(int _code) {
		return this.database.insert(_code);
	}
	
	public Account getAccount(int _code) {
		return this.database.select(_code);
	}
	
	public String credit(int _code, double value) {
		String message = "";
		Account account = this.getAccount(_code);
		if (account != null) {
			account.setBalance(account.getBalance() + value);
			message = "> Credited value!";
		} else message = "> Account doesn't exist!";
		return message;
	}
}
