package com.google.javase.day3;

import java.util.HashMap;

/*
 * ���ƺ������ָ��ڵ��������Ŀ�� һ�����������ڵ����������£�
 * public class Node {
 *  public int value; 
 *  public Node next; 
 *  publicNode rand;
 *  public Node(int data) {
 *   this.value = data;
 *    }}
 *    Node���е�value�ǽڵ�ֵ��
 *    nextָ���������������nextָ�������һ ������ָ����һ���ڵ㣬
 *    randָ����Node����������ָ�룬���ָ��� ��ָ�������е�����һ���ڵ㣬Ҳ����ָ��null��
 *    ����һ����Node�ڵ�������ɵ��޻��������ͷ�ڵ�head��
 *    ��ʵ��һ�� �������������������нṹ�ĸ��ƣ������ظ��Ƶ��������ͷ�ڵ㡣
 *    ���ף���ʹ�ö�������ݽṹ��ֻ�����޼���������
 *    ����ʱ�临�Ӷ�Ϊ O(N)�����ԭ����Ҫʵ�ֵĺ���
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
	//����ռ临�Ӷ�O(1)
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
	//����ռ临�Ӷ�O(n)
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
