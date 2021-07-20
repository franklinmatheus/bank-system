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
			System.out.println("3- Credit");
			System.out.println("4- Debit");
			System.out.println("5- Transfer");
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
				case 3: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					System.out.print("> Input value to credit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.credit(code, value);
					System.out.println(message);
					break;
				}
				case 4: {
					System.out.print("> Input the code account (integer): ");
					int code = input.nextInt();
					System.out.print("> Input value to debit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.debit(code, value);
					System.out.println(message);
					break;
				}
				case 5: {
					System.out.print("> Input the SOURCE account code (integer): ");
					int code_source = input.nextInt();
					System.out.print("> Input the DESTINATION account code (integer): ");
					int code_destination = input.nextInt();
					System.out.print("> Input value to debit (integer): ");
					double value = input.nextDouble();
					String message = bankSystem.transfer(code_source, code_destination, value);
					System.out.println(message);
					break;
				}
				default:
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("[please, input a valid value]");
				input.nextLine();
			}
			
			
		} while(option != 0);
		System.out.println("Goodbye!");
		input.close();
	}
}
