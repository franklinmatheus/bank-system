package org.bank.control;

import org.bank.data.Database;
import org.bank.entity.Account;
import org.bank.entity.BonusAccount;

public class BankSystem {
	
	private Database database;
	
	public BankSystem () {
		this.database = new Database();
	}
	
	public boolean register(int _code) {
		return this.database.insert(_code);
	}
	
	public boolean register(Account _account) {
		return this.database.insert(_account);
	}
	
	public Account getAccount(int _code) {
		return this.database.select(_code);
	}
	
	public String credit(int _code, double _value) {
		if (_value <= 0) return "> Value must be higher than 0!";
		
		String message = "";
		Account account = this.getAccount(_code);
		if (account != null) {
			account.setBalance(account.getBalance() + _value);
			message = "> Credited value!";
			
			if (account instanceof BonusAccount)
				computeBonus(_code, _value, 1);
				
			
		} else message = "> Account doesn't exist!";
		return message;
	}
	
	public String debit(int _code, double _value) {
		if (_value <= 0) return "> Value must be higher than 0!";
		
		String message = "";
		Account account = this.getAccount(_code);
		
		if (account != null) {
			account.setBalance(account.getBalance() - _value);
			message = "> Debited value!";
		} else message = "> Account doesn't exist!";
		return message;
	}
	
	public String transfer(int _codeSource, int _codeDestination, double _value) {
		if (_value <= 0) return "> Value must be higher than 0!";
		
		String message = "";
		Account account_source = this.getAccount(_codeSource);
		Account account_destination = this.getAccount(_codeDestination);
		if (account_source != null && account_destination != null) {
			account_destination.setBalance(account_destination.getBalance() + _value);
			account_source.setBalance(account_source.getBalance() - _value);
			message = "> Transfered value!";
			
			if (account_destination instanceof BonusAccount)
				computeBonus(_codeDestination, _value, 2);
			
		} else if (account_source == null) message = "> Source account doesn't exist!";
		else if (account_destination == null) message = "> Destination account doesn't exist!";
		return message;
	}
	
	public void computeBonus(int _code, double _value, int _factor) {
		BonusAccount account  = (BonusAccount) this.getAccount(_code);
		if (account != null) {
			account.setScoring(account.getScoring() + (((int) _value)/(_factor*100)));
			System.out.println("> Bonus computed! Scoring: " + account.getScoring());
		} else System.out.println("> Account doesn't exist!");
	}
}
