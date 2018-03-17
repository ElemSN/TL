package com.google.javase.day2andday3;
//仅用队列结构实现栈结构

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
	public Queue <Integer> stack;
	public Queue <Integer> heap;
	public QueueToStack(){
		stack=new LinkedList<Integer>();
		heap=new LinkedList<Integer>();
	}
	public void push(int i){
		stack.add(i);
	}
	public int pop(){
		if(stack.isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		for(int i=stack.size();i>1;--i) {
			heap.add(stack.poll());
		}
		swp();
		return heap.poll();
		
	}
	public int peek(){
		if(stack.isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		int res = 0;
		while(stack.size()>0) {
			if(stack.size()==1) {
				res=stack.peek();
			}
			heap.add(stack.poll());
			
		}
		swp();
		return res;
	}
	private void swp() {
		Queue<Integer> res;
		res=heap;
		heap=stack;
		stack=res;
	}
}
