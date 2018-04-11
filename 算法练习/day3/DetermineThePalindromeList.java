package com.google.javase.day3;

import java.util.Stack;

/*
 * �ж�һ�������Ƿ�Ϊ���Ľṹ����Ŀ�� ����һ�������ͷ�ڵ�head��
 * ���жϸ������Ƿ�Ϊ���Ľṹ�� ���磺 1->2->1������true��
 *  1->2->2->1������true��15->6->15������true��
 *  1->2->3������false��
 *  ���ף� ���������ΪN��ʱ�临�ӶȴﵽO(N)��
 *  ����ռ临�ӶȴﵽO(1)
 */
public class DetermineThePalindromeList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		head.next.next.next = new Node(1);
		head.next.next.next.next = new Node(1);
		System.out.println(Determine1(head));
		System.out.println(Determine2(head));
		System.out.println(Determine3(head));
	}

	// �ռ临�Ӷ�O(1)
	private static boolean Determine3(Node head) {
		Node head1 = head, head2 = head;
		Node p, q;
		for (; head2.next != null && head2.next.next != null; head1 = head1.next, head2 = head2.next.next)
			;
		p = head1;
		head1 = head1.next;
		p.next = null;
		for (; head1 != null; p = head1, head1 = head2) {
			head2 = head1.next;
			head1.next = p;
		}
		while (p != null && head != null) {
			if (p.value != head.value) {
				return false;
			}
			p = p.next;
			head = head.next;
		}
		return true;
	}

	// �ռ临�Ӷ�o((1/2)n)
	private static boolean Determine2(Node head) {
		Stack<Integer> st = new Stack<Integer>();
		Node head1 = head, head2 = head;
		for (; head2.next != null && head2.next.next != null; head1 = head1.next, head2 = head2.next.next) {
			st.add(head1.value);
		}
		if (head2.next != null && head2.next.next == null) {
			st.add(head1.value);
		}
		head1 = head1.next;
		for (; head1 != null && st.peek() == head1.value; head1 = head1.next, st.pop())
			;
		return st.isEmpty();
	}

	// �ռ临�Ӷ�o(n)
	private static boolean Determine1(Node head) {
		Stack<Integer> st = new Stack<Integer>();
		for (Node p = head; p != null; p = p.next) {
			st.add(p.value);
		}
		for (Node p = head; p != null && p.value == st.peek(); p = p.next, st.pop())
			;
		return st.isEmpty();
	}
}
