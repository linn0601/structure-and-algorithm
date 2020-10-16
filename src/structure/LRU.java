package structure;

/**
 * 我的思路是这样的：我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表。
 *
 * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 *
 * 2. 如果此数据没有在缓存链表中，又可以分为两种情况： 如果此时缓存未满，则将此结点直接插入到链表的头部；
 *
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 * <p>
 * 1.设计一个单链表
 * <p>
 * 2.编写 在头部插入元素，删除尾部元素的方法
 */
public class LRU<E> {

	private final int capacity;

	private Node dumpHead;

	private int size;

	public LRU(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.dumpHead = new Node(null, null);
	}

	//添加元素
	public void add(E e) {
		Node pre = contain(e);
		//不在
		if (pre != null) {
			remove(e);
		}
		addHead(e);
	}

	private void remove(E e) {
		Node pre = contain(e);
		if (pre != null) {
			//存在，删除元素
			Node removeNode = pre.next;
			pre.next = removeNode.next;
			size--;
		}
	}

	//添加到头部
	private void addHead(E e) {
		if (size < capacity) {
			//添加到头部
			dumpHead.e = e;
			dumpHead = new Node(null, dumpHead);
			size++;
		}
		else {
			removeTail();
			addHead(e);
		}
	}

	//删除尾部元素
	private void removeTail() {
		Node pre = dumpHead;
		//index 从0开始
		for (int i = 0; i < size - 1; i++) {
			pre = pre.next;
		}

		Node delNode = pre.next;
		pre.next = delNode.next;
		delNode.next = null;
		size--;
	}

	//查找元素所在的结点
	private Node contain(E e) {
		Node cur = dumpHead;

		while (cur.next != null) {
			if (cur.next.e == e) {
				return cur; //当前元素的前一个结点
			}
			cur = cur.next;
		}
		return null;
	}

	public String item() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		Node cur = dumpHead.next;
		while (cur != null) {
			s.append(cur.e).append("->");
			cur = cur.next;
		}
		s.append(" null]");
		return s.toString();
	}

	private class Node {
		E e;
		Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}
}
