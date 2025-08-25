package com.collection.cts;

import java.util.Comparator;

public class sortByName implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		return o1.GetCustomer().name.compareTo(o2.GetCustomer().name);
	}

}
