package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import model.Account;
import data.AccountRepository;

public class AccountService {
	private static Scanner scanner = new Scanner(System.in);
	
	// deposit money
	public static void depositMoney(int accountNumber, double depositAmount, String filePath) throws IOException {
		
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber, filePath);
		account = AccountRepository.updateAccountBalanceByAccount(account, depositAmount, filePath);
		displayBalance(account.getBalance());
		
	}
	
	// withdraw money
	public static void withdrawMoney(int accountNumber, double withdrawAmount, String filePath) throws IOException {
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber, filePath);
		account = AccountRepository.updateAccountBalanceByAccount(account, - withdrawAmount, filePath);
		displayBalance(account.getBalance());
	}
	
	public static double getBalance(int accountNumber, String filePath) throws FileNotFoundException {
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber, filePath);
		displayBalance(account.getBalance());
		
		return account.getBalance();
	}
	
	private static void displayBalance(double balance) {
		// display the new balance
		System.out.println("Account Balance: " + balance);
	}
}
