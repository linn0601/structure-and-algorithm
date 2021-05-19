package structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树 1. 是一个二叉树 2. 每个节点的值大于左子树的值，小于右子树的值 3. 每一颗子树也是二分搜索树
 */
public class BST<E extends Comparable<E>> {

	// 根节点
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

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {

		if (node == null) {
			return false;
		}

		if (e.compareTo(node.e) == 0) {
			return true;
		}
		else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		}
		else {
			return contains(node.right, e);
		}
	}

	public void add(E e) {
		root = add(root, e);
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
		else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}

		return node;
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

	public void preorderTraversal() {
		preorderTraversal(root);
	}

	/**
	 * 前序遍历 根 左子树 右子树 List<Integer>
	 */
	private void preorderTraversal(Node node) {

		if (node == null) {
			return;
		}
		System.out.println(node.e);
		//递归先左
		preorderTraversal(node.left);
		//递归先右
		preorderTraversal(node.right);
	}

	/**
	 * 借助栈进行前序遍历
	 */
	public void preOrder() {
		Stack<Node> stack = new Stack<>();

		stack.push(root);
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);

			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	/**
	 * 中序遍历 左子树 根 右子树
	 */
	public void inorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		preorderTraversal(node.left);
		System.out.println(node.e);
		preorderTraversal(node.right);
	}

	/**
	 * 后序遍历 左 右 根
	 */
	public void postorderTraversal(Node node) {
		if (node == null) {
			return;
		}
		preorderTraversal(node.left);
		preorderTraversal(node.right);
		System.out.println(node.e);
	}

	/**
	 * 深度
	 */
	public int maxDepth(Node node) {

		if (root == null) {
			return 0;
		}
		// 找到左边最深，右边最深的 + 1 取最大值
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	/**
	 * 层序遍历 一层一层的遍历,广度优先
	 *
	 * 队列实现 层序遍历
	 */
	public void sequenceTraversal() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node cur = queue.remove();

			System.out.println(cur.e);

			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
		}
	}

	/**
	 * 删除最小值并返回
	 */
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	// 删除搜索树任意值
	public void remove(){
		//todo
	}

	/**
	 * 删除最大值并且返回
	 */
	public E removeMax() {
		E ret = maximum();
		root = removeMax(root);
		return ret;
	}

	private Node removeMax(Node node) {
		if (node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size--;
			return leftNode;
		}

		node.right = removeMax(node.right);
		return node;
	}

	// 删除以node为根的最小节点，返回新的二分搜索树根
	private Node removeMin(Node node) {

		if (node.left == null) {
			Node right = node.right;
			node.right = null;
			size--;
			return right;
		}
		node.left = removeMin(node.left);
		return node;
	}

	/**
	 * 查找最大值
	 */
	public E maximum() {

		if (size == 0) {
			throw new IllegalArgumentException("bst is empty");
		}
		return maximum(root).e;
	}

	private Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}

		return maximum(node.right);
	}

	/**
	 * 寻找最小值
	 */
	public E minimum() {
		if (size == 0) {
			throw new IllegalArgumentException("bst is empty");
		}
		return minimum(root).e;
	}

	private Node minimum(Node node) {

		if (node.left == null) {
			return node;
		}
		return minimum(node.left);
	}
}
