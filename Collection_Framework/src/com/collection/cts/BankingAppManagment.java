package com.collection.cts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BankingAppManagment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<BankAccount> acc = new ArrayList<>();
		Set<Integer> accNos = new HashSet<Integer>();
		Map<Integer, BankAccount> accs = new HashMap<>();

		System.out.println("############~~~~~~~Banking menu~~~~~~~###########");
		int choice;

		do {

			System.out.println("1.Show All account");
			System.out.println("2.Create Acoount");
			System.out.println("3.Deposit");
			System.out.println("4.Withdraw");
			System.out.println("5.Sort by balance");
			System.out.println("6.Sort by Account");
			System.out.println("7.Sort by Age");
			System.out.println("8.Sort by Name");
			System.out.println("9.Transaction details");
			System.out.println("0.Exit");

			System.out.println("############~~~~~~~~~~~~~~###########");
			System.out.println("Enter Your Choice: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("ALL ACCOUNT: ");
				for (BankAccount ac : acc) {
					ac.showInfo();
				}
				break;
			case 2:
				String name;
				int age;
				double bl;
				System.out.println("Enter your Name:");
				name = sc.next();
				System.out.println("Enter your Age:");
				age = sc.nextInt();
				System.out.println("Enter Entry (Balance minimum >= 500):");
				bl = sc.nextDouble();

				BankAccount bc = new BankAccount(new Customer(name, age), bl);
				acc.add(bc);
				accNos.add(bc.GetAccNo());
				accs.put(bc.GetAccNo(), bc);
				break;
			case 3:
				int idDep;
				double amtDep;
				System.out.println("Enter AccountNo: ");
				idDep = sc.nextInt();
				System.out.println("Enter amount to deposit: ");
				amtDep = sc.nextDouble();
				if (accs.containsKey(idDep)) {
					accs.get(idDep).deposite(amtDep);
					System.out.println("Amount deposited");
				} else {
					System.out.println("Account No not Found!!! Please Enter correct account Number");
				}
				break;
			case 4:
				int idw;
				double amtw;
				System.out.println("Enter AccountNo: ");
				idw = sc.nextInt();
				System.out.println("Enter amount to withdraw: ");
				amtw = sc.nextDouble();
				if (accs.containsKey(idw))
				{
					accs.get(idw).withdraw(amtw);
				}else {
					System.out.println("Account Not Found!!!Please Enter correct account no.");
				}
				break;
			case 5:
				Collections.sort(acc);
				System.out.println("Sort By Balance: ");
				for (BankAccount ac:acc)
				{
					System.out.println(ac);
				}
				break;
			case 6:
				Collections.sort(acc,new sortByAccNo());
				System.out.println("Sort By Account No: ");
				for (BankAccount ac:acc)
				{
					System.out.println(ac);
				}
				break;
			case 7:
				Collections.sort(acc,new sortByAge());
				System.out.println("Sort By Age: ");
				for (BankAccount ac:acc)
				{
					System.out.println(ac);
				}
				break;
			case 8:
				Collections.sort(acc,new sortByName());
				System.out.println("Sort By Name: ");
				for (BankAccount ac:acc)
				{
					System.out.println(ac);
				}
				break;
			case 9:
				int idT;
				System.out.println("Enter the Account No: ");
				idT = sc.nextInt();
				if(accs.containsKey(idT))
				{
					System.out.println("Tansactions: ");
					for(String T : accs.get(idT).transaction)
					{
						System.out.println(T);
					}
				}
				break;
			}
		} while (choice != 0);
		System.out.println("Exit");
		sc.close();
	}

}
