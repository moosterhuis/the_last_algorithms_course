class Node<T> {
	T value;
	Node<T> left;
	Node<T> right;

	public Node(T value, Node<T> left, Node<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}

public class BinarySearchTree<T> {

	public int height;
	public Node<T> root;

	public BinarySearchTree() {
		this.height = 0;
		this.root = null;
	}

	public static void main(String[] args) {
		Node<Integer> a = new Node<>(17, null, null);
		Node<Integer> b = new Node<>(15, null, null);
		Node<Integer> c = new Node<>(4, null, null);
		Node<Integer> d = new Node<>(16, null, null);
		Node<Integer> e = new Node<>(50, null, null);
		Node<Integer> f = new Node<>(25, null, null);

		a.left = b;
		a.right = e;
		b.left = c;
		b.right = d;
		e.left = f;

		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
		binarySearchTree.root = a;
		System.out.println(binarySearchTree.binarySearch(binarySearchTree.root, 4));
		System.out.println(binarySearchTree.binarySearch(binarySearchTree.root, 42));
	}

	public boolean binarySearch(Node<Integer> node, Integer needle) {

		// Base case
		if (node == null) {
			return false;
		}
		if (node.value == needle) {
			return true;
		}

		// Recurse
		if (node.value < needle) {
			return binarySearch(node.right, needle);
		}
		return binarySearch(node.left, needle);
	}

}
