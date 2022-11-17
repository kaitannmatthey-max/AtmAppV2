package model;

public class Person {

	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Person() {
		firstName = "";
		lastName = "";
		accountNumber = 0;
	}
	
	public Person(String passedInFirstName, String passedInLastName, int passedInAccountNumber) {
		firstName = passedInFirstName;
		lastName = passedInLastName;
		accountNumber = passedInAccountNumber;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String passedInFirstName) {
		this.firstName = passedInFirstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String passedInLastName) {
		this.lastName = passedInLastName;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(int passedInAccountNumber) {
		this.accountNumber = passedInAccountNumber;
	}
}
