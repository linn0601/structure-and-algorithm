package structure.stack;

/**
 * 链表实现的栈 -- 链式栈
 */
public class LinkedStack<E> implements Stack<E> {

	private Node dummyHead;

	private int size;

	public LinkedStack() {
		size = 0;
		this.dummyHead = new Node(null, null);
	}

	private class Node {
		E e;
		Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}

	@Override
	public E pop() {
		Node prev = dummyHead;
		if (size == 0) {
			return null;
		}

		Node delNode = dummyHead.next;
		prev.next = new Node(null, delNode.next);
		--size;

		return prev.e;
	}

	@Override
	public boolean push(E e) {
		Node prev = dummyHead;
		prev.next = new Node(e, prev.next);
		++size;
		return false;
	}
}
