package com.collection.cts;

import java.util.LinkedList;
import java.util.Queue;

public class BankAccount implements BankingSystem , Comparable<BankAccount>{
	private static int dommyAccNo = 56743;
	private Integer accNo;
	private double balance;
	private Customer cus;
	
	Queue<String> transaction = new LinkedList<>(); // for transaction history
	
	BankAccount(Customer cus , double balance)
	{
		this.cus = cus;
		this.accNo = dommyAccNo++;
		this.balance = balance;
		transaction.add("Account Created with balance: " + balance);
	}

	@Override
	public void deposite(double amount) {
		balance = balance + amount;
		transaction.add("Deposited : " + amount);
		
	}

	@Override
	public void withdraw(double amount) {
		if(amount <= balance)
		{
			balance = balance - amount;
			transaction.add("Withdrawn: "+ amount);
		}else {
			System.out.println("Insufficient Balance");
		}
		
	}

	@Override
	public void showInfo() {
		
		System.out.println(this);
	}
	@Override
	public String toString()
	{
		return "Account NO : "+ accNo +
				" | Name : " + cus.name +
				" | Age : " + cus.age +
				" | Balance :" + balance;
	}
	
	public Integer GetAccNo()
	{
		return accNo;
	}
	public double GetBalance()
	{
		return balance;
	}
	public Customer GetCustomer()
	{
		return cus;
	}

	@Override
	public int compareTo(BankAccount o) {
		return Double.compare(this.balance,o.balance);
	}

}
