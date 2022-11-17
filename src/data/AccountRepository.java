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
	public static Account getAccountByAccountNumber(int accountNumber) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("C:\\Users\\kaita\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\AtmAppV2\\src\\data\\account1.txt"));
		
		Account account = new Account();
		
		account.setAccountNumber(scanner.nextInt());
		account.setBalance(scanner.nextDouble());
		
		return account;
	}
	
	// update an account's balance by account number
	public static Account updateAccountBalanceByAccount(Account account, double depositAmount) throws IOException {
		try (PrintWriter out = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								new File("C:\\Users\\kaita\\Documents\\workspace-spring-tool-suite-4-4.16.1.RELEASE\\AtmAppV2\\src\\data\\account1.txt"))))) {
			
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

// PAGE 289
// under the saveAll method
// use the same from scanner above: new File(filePAth) from getAccountByAcountNumber^^^
// import all my imports