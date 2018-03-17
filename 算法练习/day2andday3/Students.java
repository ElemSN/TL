package com.google.javase.day2andday3;

import java.util.Arrays;
//比较器的应用
public class Students {
	public String name;
	public int id;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static void main(String[] args) {
		Students s1=new Students();
		Students s2=new Students();
		Students s3=new Students();
		Students s4=new Students();
		s1.setAge(22);
		s1.setId(1);
		s1.setName("s1");
		s2.setAge(22);
		s2.setId(9);
		s2.setName("s2");
		s3.setAge(20);
		s3.setId(1);
		s3.setName("s3");
		s4.setAge(23);
		s4.setId(3);
		s4.setName("s4");
		Students []s= {s1,s2,s3,s4};
		for(int i=0;i<s.length;++i) {
			System.out.println("name:"+s[i].name+"    ID:"+s[i].id+"    Age"+s[i].age);
		}
		System.out.println("===========================");
		Arrays.sort(s,new IdComparator());
		for(int i=0;i<s.length;++i) {
			System.out.println("name:"+s[i].name+"    ID:"+s[i].id+"    Age"+s[i].age);
		}
		System.out.println("==========================");
		Arrays.sort(s,new AgeComparator());
		for(int i=0;i<s.length;++i) {
			System.out.println("name:"+s[i].name+"    ID:"+s[i].id+"    Age"+s[i].age);
		}
		
	}
}
