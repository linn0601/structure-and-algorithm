package structure.map;

public class LinkedListMap<K, V> implements Map<K, V> {

	private Node dummyHead;

	private int size;

	public LinkedListMap() {
		this.dummyHead = new Node();
		this.size = 0;
	}

	@Override
	public void add(K key, V value) {
		Node node = getNode(key);

		if (node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size++;
		}
		else {
			node.value = value;
		}
	}

	@Override
	public V remove(K key) {

		Node pre = dummyHead;

		while (pre.next != null) {
			if (pre.next.key.equals(key)) {
				break;
			}
			pre = pre.next;
		}

		if (pre.next != null) {
			Node delNode = pre.next;
			pre.next = delNode.next;
			delNode.next = null;
			size--;
			return delNode.value;
		}

		return null;
	}

	@Override
	public boolean contains(K key) {
		return getNode(key) != null;
	}

	@Override
	public V get(K k) {
		Node node = getNode(k);

		if (node == null) {
			return null;
		}
		return node.value;
	}

	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if (cur.key.equals(key)) {
				return cur;
			}

			cur = cur.next;
		}
		return null;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(key);
		if (node == null) {
			throw new IllegalArgumentException();
		}
		node.value = value;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	class Node {

		K key;

		V value;

		Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Node(K key) {
			this.key = key;
			this.value = null;
			this.next = null;
		}

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		public Node() {
		}
	}
}
