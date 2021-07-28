package org.bank.control;

import org.bank.data.Database;
import org.bank.entity.Account;
import org.bank.entity.SavingsAccount;

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
			this.credit(_codeDestination, _value);
			this.debit(_codeSource, _value);
			message = "> Transfered value!";
		} else if (account_source == null) message = "> Source account doesn't exist!";
		else if (account_destination == null) message = "> Destination account doesn't exist!";
		return message;
	}
	
	public String earnInterest(int _code, double _ratio) {
		String message = "";
		Account account = this.getAccount(_code);
		
		if (account != null) {
			if (account instanceof SavingsAccount) {
				((SavingsAccount) account).earnInterest(_ratio);
				message = "> Interest earned!";
			} else message = "> Account is not a savings account!";
			
			
		} else message = "> Account doesn't exist!";
		return message;
	}
}
