package org.bank.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.bank.control.BankSystem;
import org.bank.entity.Account;

public class Console {
	
	public static void main(String[] args) {
		BankSystem bankSystem = new BankSystem();
		Scanner input = new Scanner(System.in);
		int option = -1;
		
		System.out.println("Welcome!");
		do {
			System.out.println("\n\n1- Register account");
			System.out.println("2- Consult balance");
			System.out.println("0- Exit");
			System.out.println("-------------------------");
			System.out.print("Input the number of desired option: ");
			try {
				option = input.nextInt();
				
				switch (option) {
				case 1: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					if (bankSystem.register(code) == true)
						System.out.println("> Account registred!");
					else System.out.println("> Account already exists!");
					break;
				}
				case 2: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					Account account = bankSystem.getAccount(code);
					if (account != null) {
						System.out.println("> Balance: " + account.getBalance());
					} else System.out.println("> Account doesn't exist!");
					break;
				}
				default:
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("[please, input a integer]");
				input.nextLine();
			} catch (IllegalArgumentException e) {
				System.out.println("[please, input a valid option]");
			}
			
			
		} while(option != 0);
		System.out.println("Goodbye!");
		input.close();
	}
}
