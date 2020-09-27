package com.learn.pojo;

import java.util.Comparator;

public class Interfaces {
	public static void main(String[] args) {
		Employee mike = new Employee("Mike", 1000);
		Employee louis = new Employee("Louis", 2000);

		//Traditional way of comparing
		Comparator<Employee> byName = new Comparator<Employee>() {
			@Override
			public int compare(Employee a, Employee b) {
				return a.getName().compareTo(b.getName());
			}
		};

		System.out.println(byName.compare(mike, louis));

		try {
			System.out.println(byName.compare(mike, null));
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		// a static method in comparator
		Comparator<Employee> byNameThenNull = Comparator.nullsLast(byName);
		System.out.println("By Name then Null ->");
		System.out.println(byNameThenNull.compare(mike, louis));
		System.out.println(byNameThenNull.compare(mike, null));

		//a default method in comparator
		Comparator<Employee> nullThenByDescName = byNameThenNull.reversed();
		System.out.println("Null then by Desc Name ->");
		System.out.println(nullThenByDescName.compare(mike, louis));
		System.out.println(nullThenByDescName.compare(mike, null));

	}
}
