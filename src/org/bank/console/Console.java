package org.bank.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.bank.control.BankSystem;

public class Console {
	
	public static void main(String[] args) {
		BankSystem bankSystem = new BankSystem();
		Scanner input = new Scanner(System.in);
		int option = -1;
		do {
			System.out.println("Welcome!");
			System.out.println("Input the number of desired option below:");
			try {
				option = input.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("[please, input a valid option]");
				input.nextLine();
			}
			
			
		} while(option != 0);
		System.out.println("Goodbye!");
		input.close();
	}
}
