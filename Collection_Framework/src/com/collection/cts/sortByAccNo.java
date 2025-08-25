package com.collection.cts;

import java.util.Comparator;

public class sortByAccNo implements Comparator<BankAccount> {

	@Override
	public int compare(BankAccount o1, BankAccount o2) {
		return o1.GetAccNo().compareTo(o2.GetAccNo());
	}

}
