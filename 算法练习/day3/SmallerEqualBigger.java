package com.google.javase.day3;

/*
 * 将单向链表按某值划分成左边小、中间相等、右边大的形式
 *【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
 *整 数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
 *的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
 *除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5-
 *>1，pivot=3。 调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总
 *之，满 足左部分都是小于3的节点，中间部分都是等于3的节点（本例中这个部
 *分为空），右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。
 *进阶： 在原问题的要求之上再增加如下两个要求。
 *在左、中、右三个部分的内部也做顺序要求，要求每部分里的节点从左 到右的
 *顺序与原链表中节点的先后次序一致。 例如：链表9->0->4->5->1，pivot=3。
 *调整后的链表是0->1->9->4->5。 在满足原问题要求的同时，左部分节点从左到
 *右为0、1。在原链表中也 是先出现0，后出现1；中间部分在本例中为空，不再
 *讨论；右部分节点 从左到右为9、4、5。在原链表中也是先出现9，然后出现4，
 *最后出现5。
 *如果链表长度为N，时间复杂度请达到O(N)，额外空间复杂度请达到O(1)。
 */
public class SmallerEqualBigger {

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		printLinkedList(head1);
		head1 = listPartition2(head1, 4);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);

	}

	private static Node listPartition2(Node head1, int num) {
		Node lessH = null, eqH = null, moreH = null;
		Node less = null, eq = null, more = null;
		Node p = head1, q;
		while (p != null) {
			q = p.next;
			if (p.value < num) {
				if (lessH == null) {
					lessH = less = p;
				} else {
					less.next = p;
					less = less.next;
				}
				less.next = null;
			} else if (p.value == num) {
				if (eqH == null) {
					eqH = eq = p;
				} else {
					eq.next = p;
					eq = eq.next;
				}
				eq.next = null;
			} else if (p.value > num) {
				if (moreH == null) {
					moreH = more = p;
				} else {
					more.next = p;
					more = more.next;
				}
				more.next = null;
			}
			p=q;
		}
		if (less != null) {
			less.next = eqH;
			eq = eq == null ? less : eq;
		}
		if (more != null) {
			eq.next = moreH;
		}
		return lessH;
	}

	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
