package com.collection.cts;

import java.util.Comparator;

public class sortByAge implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		return o1.GetCustomer().age.compareTo(o2.GetCustomer().age);
	}

}
