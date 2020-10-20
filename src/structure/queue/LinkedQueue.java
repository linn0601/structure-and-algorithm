package structure.queue;

/**
 * 链表队列
 */
public class LinkedQueue<E> {

	private Node head, tail;

	public LinkedQueue() {
		head = null;
		tail = null;
	}

	public void enqueue(E e) {
		Node node = new Node(e, null);

		if (head == null) {
			head = node;
		}
		else {
			tail.next = node;
		}
		tail = node;
	}

	public E dequeue() {

		if (head == null) {
			return null;
		}
		else {
			E e = head.e;
			head = head.next;
			return e;
		}
	}

	private class Node {
		E e;
		Node next;

		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
	}

	public String item() {
		if (head == null) {
			return null;
		}

		Node node = head;
		while (node != null) {
			System.out.println(node.e);
			node = node.next;
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<>();

		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		queue.item();

		System.out.println("---");
		queue.dequeue();

		queue.item();

	}
}
