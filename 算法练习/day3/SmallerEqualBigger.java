package com.google.javase.day3;

/*
 * ����������ĳֵ���ֳ����С���м���ȡ��ұߴ����ʽ
 *����Ŀ�� ����һ�����������ͷ�ڵ�head���ڵ��ֵ���������ͣ��ٸ���һ��
 *�� ��pivot��ʵ��һ����������ĺ��������������Ϊ�󲿷ֶ���ֵС�� pivot
 *�Ľڵ㣬�м䲿�ֶ���ֵ����pivot�Ľڵ㣬�Ҳ��ֶ���ֵ���� pivot�Ľڵ㡣
 *�����Ҫ���⣬�Ե�����Ľڵ�˳��û�и����Ҫ�� ���磺����9->0->4->5-
 *>1��pivot=3�� ���������������1->0->4->9->5��Ҳ������0->1->9->5->4����
 *֮���� ���󲿷ֶ���С��3�Ľڵ㣬�м䲿�ֶ��ǵ���3�Ľڵ㣨�����������
 *��Ϊ�գ����Ҳ��ֶ��Ǵ���3�Ľڵ㼴�ɡ���ĳ�����ڲ��Ľڵ�˳����Ҫ��
 *���ף� ��ԭ�����Ҫ��֮����������������Ҫ��
 *�����С����������ֵ��ڲ�Ҳ��˳��Ҫ��Ҫ��ÿ������Ľڵ���� ���ҵ�
 *˳����ԭ�����нڵ���Ⱥ����һ�¡� ���磺����9->0->4->5->1��pivot=3��
 *�������������0->1->9->4->5�� ������ԭ����Ҫ���ͬʱ���󲿷ֽڵ����
 *��Ϊ0��1����ԭ������Ҳ ���ȳ���0�������1���м䲿���ڱ�����Ϊ�գ�����
 *���ۣ��Ҳ��ֽڵ� ������Ϊ9��4��5����ԭ������Ҳ���ȳ���9��Ȼ�����4��
 *������5��
 *���������ΪN��ʱ�临�Ӷ���ﵽO(N)������ռ临�Ӷ���ﵽO(1)��
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
