package org.bank.control;

import org.bank.data.Database;

public class BankSystem {
	
	private Database database;
	
	public BankSystem () {
		this.database = new Database();
	}
	
	public boolean register(int _code) {
		return this.database.insert(_code);
	}
}
