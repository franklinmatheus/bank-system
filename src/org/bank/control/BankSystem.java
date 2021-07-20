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
}
