package com.google.javase.day2andday3;

public class Test {

	public static void main(String[] args) {
		int []num= {9,3,5,65,54,98,7,2/*,100,200,321,222,345,256*/};
		/*GapTowNumbersMax ctm=new GapTowNumbersMax();
		System.out.println(ctm.gapTowNumbersMax(num));
		MinStack s=new MinStack();
		for(int i=0;i<num.length;++i) {
			s.push(num[i]);
		}
		System.out.println(s.getMin());
		for(int i=0;i<num.length-6;++i) {
			System.out.println(s.pop());
		}
		System.out.println(s.getMin());*/
		QueueToStack stack=new QueueToStack();
		for(int i=0;i<num.length;++i) {
			stack.push(num[i]);
		}
	//	System.out.println(s.getMin());
		
		for(int i=0;i<num.length;++i) {
			System.out.println(stack.peek());
			System.out.println(stack.pop());
		}
	}

}
