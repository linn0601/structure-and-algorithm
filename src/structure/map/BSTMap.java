package structure.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	private Node root;

	private int size;

	public BSTMap() {
		root = null;
		this.size = 0;
	}

	@Override
	public void add(K key, V value) {
		root = add(root, key, value);
	}

	private Node add(Node node, K key, V value) {
		if (root == null) {
			size++;
			return new Node(key, value);
		}

		if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		}
		else if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		}
		else {
			node.value = value;
		}

		return node;
	}

	@Override
	public V remove(K key) {

		Node node = getNode(root, key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	// 删除掉以node为根的二分搜索树中的最小节点
	// 返回删除节点后的二分搜索树的根
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;

			node.right = null;

			size--;

			return rightNode;
		}

		node.left = removeMin(node.left);

		return node;
	}

	// 返回以弄的为根的二分搜索树的最小节点
	private Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}

	// 最小值
	private Node remove(Node node, K key) {

		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) < 0) {
			return remove(node.left, key);
		}

		else if (key.compareTo(node.key) > 0) {
			return remove(node.right, key);
		}

		else {
			// 删除当前的node
			if (node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}

			if (node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size--;
				return leftNode;
			}

			// 带删除即诶单左右子树都不为null
			// 找到必带删除节点的最小节点，即带删除节点右子树的最小节点
			// 用这个节点顶替待删除节点的位置
			Node successor = minimum(node.right);

			successor.right = removeMin(node.right);
			successor.left = node.left;

			node.left = node.right = null;

			return successor;
		}
	}

	private Node getNode(Node node, K key) {

		// 终止条件
		if (node == null) {
			return null;
		}

		if (key.compareTo(node.key) == 0) {
			return node;
		}
		// 递归逻辑
		else if (key.compareTo(node.key) < 0) {
			return getNode(node.left, key);
		}
		else {
			return getNode(node.right, key);
		}
	}

	@Override
	public boolean contains(K key) {
		return getNode(root, key) != null;
	}

	@Override
	public V get(K k) {

		Node node = getNode(root, k);

		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node node = getNode(root, key);

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
		Node left;
		Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}
