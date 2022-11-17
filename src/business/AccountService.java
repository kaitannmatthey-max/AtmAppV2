package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Account;
import data.AccountRepository;

public class AccountService {
	private static Scanner scanner = new Scanner(System.in);
	
	// deposit money
	public static void depositMoney() throws IOException {
		// ask the user what account they want to deposit into
		System.out.print("Which account number would you like to deposit money into?: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();
		
		// prompt the user to deposit money
		System.out.print("How much would you like to deposit?: ");
		
		// get a valid number entry from the user
		boolean isValid = false;
		double number = 0;
		
		while (!isValid) {
			try {
				number = Double.parseDouble(scanner.nextLine());
				number = Math.floor(number * 100) / 100;
				isValid = true;
			}
			catch(NumberFormatException numberFormatException) {
				System.out.println("Invalid value. Please enter a number.");
				System.out.println();
				System.out.print("Re-enter ammount: ");
			}
		}
		
		// update the account balance
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber);
		account = AccountRepository.updateAccountBalanceByAccount(account, number);
		
		// display the new balance
		System.out.println("Account Balance: " + account.getBalance());
	}
	
	// withdraw money
	
	// check balance

}
