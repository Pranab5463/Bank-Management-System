package com.collection.cts;

public abstract class Human {
	String name;
	Integer age;
	public Human(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	abstract void displayHuman();
}
