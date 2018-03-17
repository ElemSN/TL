package com.google.javase.day2andday3;

import java.util.Comparator;

public class IdComparator implements Comparator<Students>{

	@Override
	public int compare(Students arg0, Students arg1) {
		// TODO Auto-generated method stub
		return arg0.id-arg1.id;
	}

}
