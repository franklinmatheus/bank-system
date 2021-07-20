package org.bank.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.bank.control.BankSystem;

public class Console {
	
	public static void main(String[] args) {
		BankSystem bankSystem = new BankSystem();
		Scanner input = new Scanner(System.in);
		int option = -1;
		
		System.out.println("Welcome!");
		do {
			System.out.println("\n\n1- Register account");
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
				}
				default:
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
