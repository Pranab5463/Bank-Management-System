package com.collection.cts;

public class Customer extends Human{

	public Customer(String name, int age) {
		super(name, age);
	}

	@Override
	void displayHuman() {
		System.out.println("Customer Name: "+name+ " Age " + age);
		
	}

}
