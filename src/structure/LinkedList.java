package structure;

/**
 * 真正动态的数据结构 最简单 二分搜索树，平衡二叉树 avl 红黑树 丧失了随机访问
 *
 * 虚拟头节点  dummyHead
 */
public class LinkedList<E> {

	//虚拟头节点
	private final Node dummyHead;

	private int size;

	public LinkedList() {
		dummyHead = new Node();
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size - 1);
	}

	public E remove(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException();
		}
		// 待删除节点
		Node prev = dummyHead;

		for (int i = 0; i < index; i++) {
			//删除点
			prev = prev.next;
		}

		Node delNode = prev.next;
		prev.next = delNode.next;
		delNode.next = null;

		size--;

		return delNode.e;
	}

	public E removeTail() {
		return remove(size - 1);
	}

	public E removeHead() {
		return remove(0);
	}

	public void remove(E e) {
		//删除位置的上一个节点
		Node prev = dummyHead;

		while (prev.next != null) {
			if (prev.e.equals(e)) {
				break;
			}
			prev = prev.next;
		}

		// 如果下一个节点不为null，表示存在需要删除的对象e
		if (prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
		}
		size--;
	}

	//update
	public void set(int index, E e) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}

		Node cur = dummyHead.next;

		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}

		cur.e = e;
	}

	//find
	public boolean contains(E e) {
		Node cur = dummyHead.next;

		while (cur != null) {

			if (cur.e == e) {
				return true;
			}
			cur = cur.next;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Node cur = dummyHead.next;
		while (cur != null) {

			builder.append(cur).append(" -> ");
			cur = cur.next;
		}

		builder.append(" Null ");

		return builder.toString();
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
	 */
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}

		Node cur = dummyHead.next;

		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}

		return cur.e;
	}

	public void addAtHead(E e) {
		add(0, e);
	}

	public void add(int index, E e) {
		if (index > size || index < 0) {
			throw new IllegalArgumentException();
		}

		Node prev = dummyHead;
		//插入的上一个节点
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		prev.next = new Node(e, prev.next);
		size++;
	}

	public void addAtTail(E e) {
		add(size, e);
	}

	// 数据结构
	private class Node {
		E e;

		Node next;

		public Node(E e, Node node) {
			this.e = e;
			next = node;
		}

		public Node(E e) {
			this(e, null);
		}

		public Node() {
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}
}
