package structure.tree;

/**
 * 二分搜索树 1. 是一个二叉树 2. 每个节点的值大于左子树的值，小于右子树的值 3. 每一颗子树也是二分搜索树
 */
public class BST<E extends Comparable<E>> {

	// 跟节点
	private Node root;

	private int size;

	public BST() {
		this.root = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		add(root, e);
	}

	// 向以node为根的二分搜索树中插入元素
	private Node add(Node node, E e) {

		if (node == null) {
			size++;
			return new Node(e);
		}

		if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}
		else { // e.compareTo(node.e) > 0
			node.right = add(node.right, e);
		}

		return null;
	}

	private class Node {

		E e;
		Node left;
		Node right;

		public Node(E e) {
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}
}
