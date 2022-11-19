package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.Account;

public class AccountRepository {

	// gets an account from the "db" by account number
	public static Account getAccountByAccountNumber(int accountNumber, String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath));
		
		Account account = new Account();
		
		account.setAccountNumber(scanner.nextInt());
		account.setBalance(scanner.nextDouble());
		
		return account;
	}
	
	// update an account's balance by account number
	public static Account updateAccountBalanceByAccount(Account account, double depositAmount, String filePath) throws IOException {
		try (PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								new File(filePath))))) {
			
			double newBalance = account.getBalance() + depositAmount;
			account.setBalance(newBalance);
			
			out.print(account.getAccountNumber() + " " + newBalance);
			out.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return account;
		
	}
}