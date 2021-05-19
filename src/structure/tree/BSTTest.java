package structure.tree;

public class BSTTest {

	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();

		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);

		/*bst.preorderTraversal();

		System.out.println("非递归");

		bst.preOrder();

		System.out.println("广度优先的层序遍历");

		bst.sequenceTraversal();*/
	}
}
