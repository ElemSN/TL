package com.google.javase.day3;

public class FindFirstIntersectNode {
	/*
	 * �����������ཻ��һϵ�����⡾��Ŀ�� �ڱ����У�����������л���Ҳ�����޻��� ���������������ͷ�ڵ�
	 * head1��head2����������������ཻ��Ҳ���ܲ��ཻ�� ��ʵ��һ�������� ������������ཻ���뷵���ཻ�ĵ�һ���ڵ㣻������ཻ������null ���ɡ�
	 * Ҫ�� �������1�ĳ���ΪN������2�ĳ���ΪM��ʱ�临�Ӷ���ﵽ O(N+M)������ռ临�Ӷ���ﵽO(1)
	 */
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

	private static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node Loop1, Loop2;
		Loop1 = getLoopNode(head1);
		Loop2 = getLoopNode(head2);
		if (Loop1 == null && Loop2 == null) {
			return noLoop(head1, head2);
		}
		if (Loop1 != null && Loop2 != null) {
			return bothLoop(head1, Loop1, head2, Loop2);
		}
		return null;
	}

	private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (loop1 == loop2) {
			Node cur1 = head1;
			Node cur2 = head2;
			int cnt = 0;
			for (; cur1 != loop1; cnt++, cur1 = cur1.next)
				;
			for (; cur2 != loop2; cnt--, cur2 = cur2.next)
				;
			cur1 = cnt > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			cnt=Math.abs(cnt);
			for (; cnt != 0; cnt--, cur1 = cur1.next)
				;
			for (; cur1 != cur2; cur1 = cur1.next, cur2 = cur2.next)
				;
			return cur1;
		} 
		else {
			Node cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}

			return null;
		}
	}

	private static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int cnt = 0;
		while (cur1.next != null) {
			cnt++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			cnt--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = cnt > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		cnt = Math.abs(cnt);
		while (cnt != 0) {
			cur1 = cur1.next;
			cnt--;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	private static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node h1 = head.next;
		Node h2 = h1.next;
		while (h2 != h1) {
			if (h2.next == null || h2.next.next == null) {
				return null;
			}
			h1 = h1.next;
			h2 = h2.next.next;
		}
		h1 = head;
		while (h1 != h2) {
			h1 = h1.next;
			h2 = h2.next;
		}
		return h1;
	}
}
