import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import business.AccountService;
import data.AccountRepository;
import model.Account;

public class AtmAppV2 {
	
	private static Scanner scanner = new Scanner(System.in); // moved this to global so I can use across multiple methods

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		
		final int DEPOSIT = 1;
		final int WITHDRAW = 2;
		final int BALANCE = 3;
		final int EXIT = 4;
		
		boolean moreActions = true;
		
		System.out.print("Welcome to the Bank of Bootcamp!");
		int accountNumber = getAccountNumberFromUser();
		
		while (moreActions) {
			System.out.printf("%n%nSelect from the following menu options: "
					+ "%n%-3d %17s " // deposit
					+ "%n%-3d %17s " // withdraw
					+ "%n%-3d %17s " // balance
					+ "%n%-3d %17s " // exit
					+ "%n%nMake your selection: ", 
						DEPOSIT, "Deposit", 
						WITHDRAW, "Withdraw", 
						BALANCE, "Balance", 
						EXIT, "Exit");
			
			int userInput = scanner.nextInt();
			scanner.nextLine(); // move cursor to next line for next prompt
			System.out.println(); // line space between selection and next prompt
			
			switch(userInput) {
				case DEPOSIT:
				{
					AccountService.depositMoney(accountNumber, askHowMuchForWhatAction("deposit"), filePath);
					continue;
				}
				case WITHDRAW:
				{
					while(true) // keep running forever until we break out (they enter valid amount)
					{
						double withdrawAmount =  askHowMuchForWhatAction("withdraw");
						
						if (AccountService.getBalance(accountNumber, filePath) > withdrawAmount) {
							AccountService.withdrawMoney(accountNumber, withdrawAmount, filePath);
							break;
						} else {
							System.out.println("Insufficient funds");
						}
					}
					continue;
				}
				case BALANCE:
				{
					AccountService.getBalance(accountNumber, filePath);
					continue;
				}
				case EXIT:
				{
					System.out.println("Thanks for using the ATM!");
					moreActions = false;
					break;
				}
				default:
				{
					System.out.println("Not a valid choice!");
					continue;
				}
			}
		}
	}
	
	// Moving interaction with the user to the Presentation Tier
	private static int getAccountNumberFromUser() {
		System.out.printf("%n%nEnter Account Number: ");
		
		int accountNumber = scanner.nextInt();
		scanner.nextLine();
		
		return accountNumber;
	}
	
	private static double askHowMuchForWhatAction(String action) {
		System.out.printf("How much would you like to %s?: ", action);
		
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
				System.out.print("Re-enter amount: ");
			}
		}
		
		return number;
	}
}
