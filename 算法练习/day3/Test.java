package com.google.javase.day3;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<MyClass> set=new HashSet<MyClass>();
		
		set.add(new MyClass(5));
		set.add(new MyClass(2));
		set.add(new MyClass(6));
		System.out.println(set.size());
		
	}

}
class MyClass{
	Integer i;
	public MyClass(Integer y) {
		i=y;
	}
	public boolean equals(MyClass o) {
		return false;
	}
	public boolean equals(Object o) {
		return true;
	}
	public int hashCode() {
		return 32;
	}
}