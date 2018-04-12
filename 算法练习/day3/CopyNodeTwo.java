package com.google.javase.day3;

import java.util.HashMap;

/*
 * 复制含有随机指针节点的链表【题目】 一种特殊的链表节点类描述如下：
 * public class Node {
 *  public int value; 
 *  public Node next; 
 *  publicNode rand;
 *  public Node(int data) {
 *   this.value = data;
 *    }}
 *    Node类中的value是节点值，
 *    next指针和正常单链表中next指针的意义一 样，都指向下一个节点，
 *    rand指针是Node类中新增的指针，这个指针可 能指向链表中的任意一个节点，也可能指向null。
 *    给定一个由Node节点类型组成的无环单链表的头节点head，
 *    请实现一个 函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 *    进阶：不使用额外的数据结构，只用有限几个变量，
 *    且在时间复杂度为 O(N)内完成原问题要实现的函数
 */
public class CopyNodeTwo {
	public static void main(String[] args) {
		NodeTwo p; 
		NodeTwo head2;
		NodeTwo head1 = new NodeTwo(7);
		head1.next = new NodeTwo(9);
		head1.next.next = new NodeTwo(1);
		head1.next.next.next = new NodeTwo(8);
		head1.next.next.next.next = new NodeTwo(5);
		head1.next.next.next.next.next = new NodeTwo(2);
		head1.next.next.next.next.next =new NodeTwo(5);
		p=head1;
		while(p.next!=null) {
			p.rand=p.next.next;
			p=p.next;
		}
		printLinkedList(head1);
		head2=copyNodeTwo(head1);
		printLinkedList(head2);
		head2=copNodeTwo2(head1);
		printLinkedList(head2);
	}
	//额外空间复杂度O(1)
	private static NodeTwo copNodeTwo2(NodeTwo head1) {
		NodeTwo cur=head1;
		NodeTwo help;
		NodeTwo q;
		while(cur!=null) {
			help=new NodeTwo(cur.value);
			help.next=cur.next;
			cur.next=help;
			cur=help.next;
		}
		cur=head1;
		head1=cur.next;
		help=null;
		q=null;
		while(cur!=null) {
			if(cur.rand!=null)
				cur.next.rand=cur.rand.next;
			if(q!=null)
				q.next=cur.next;
			help=cur;
			q=help.next;
			cur=cur.next.next;
			help.next=null;
			
		}
		return head1;
	}
	//额外空间复杂度O(n)
	private static NodeTwo copyNodeTwo(NodeTwo head1) {
		NodeTwo head=head1;
		HashMap<NodeTwo,NodeTwo> help=new HashMap<NodeTwo,NodeTwo>();
		while(head!=null) {
			help.put(head, new NodeTwo(head.value));
			head=head.next;
		}
		head=head1;
		while(head!=null) {
			help.get(head).next=head.next;
			help.get(head).rand=head.rand;
			head=head.next;
		}
		return help.get(head1);
	}
	public static void printLinkedList(NodeTwo node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			if(node.rand!=null)
				System.out.print(node.rand.value);
			System.out.println();
			node = node.next;
		}
		System.out.println();
	}		
}
