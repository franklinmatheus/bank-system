package org.bank.data;

import java.util.ArrayList;
import java.util.List;

import org.bank.entity.Account;

public class Database {
	
	private List<Account> accounts;
	
	public Database() {
		this.accounts = new ArrayList<Account>();
	}
	
	public boolean insert(Account _account) {
		if (select(_account.getCode()) == null) {
			this.accounts.add(_account);
			return true;
		}
			
		return false;
	}
	
	public boolean insert(int _code) {
		return this.insert(new Account(_code));
	}
	
	public Account select(int _code) {
		Account account = null;
		for(Account temp : this.accounts) {
			if (temp.getCode() == _code) 
				account = temp;
				break;
		}
		return account;
	}
}
