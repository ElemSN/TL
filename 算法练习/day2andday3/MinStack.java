package com.google.javase.day2andday3;

import java.util.Stack;
/*
 * 实现一个特殊的栈，
 * 在实现栈的基本功能的基础上，
 * 再实现返回栈中最小元素的
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 */
public class MinStack {
	private Stack <Integer> min=new Stack<Integer>();
	private Stack <Integer> stack=new Stack<Integer>();
	public void push(int i) {
		stack.push(i);
		min.push(min.isEmpty()||i<min.peek()?i:min.peek());

	}
	public int pop() {
		min.pop();
		return stack.pop();
	}
	public int getMin() {
		return min.pop();
	}
	
}
