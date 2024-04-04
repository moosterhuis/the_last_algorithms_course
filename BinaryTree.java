import java.util.ArrayList;
import java.util.List;

class Node<T> {
	public T value;
	public Node<T> left;
	public Node<T> right;

	public Node() {
	}

	public Node(T value, Node<T> left, Node<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}

public class BinaryTree<T> {
	public Node<T> head;
	public List<Node<T>> nodes;

	public BinaryTree() {
		this.head = null;
		this.nodes = new ArrayList<>();
	}

	public static void main(String[] args) {
		Node<String> a = new Node<>("a", null, null);
		Node<String> b = new Node<>("b", null, null);
		Node<String> c = new Node<>("c", null, null);
		Node<String> d = new Node<>("d", null, null);
		Node<String> e = new Node<>("e", null, null);
		Node<String> f = new Node<>("f", null, null);
		Node<String> g = new Node<>("g", null, null);
		Node<String> h = new Node<>("h", null, null);

		a.left = b;
		a.right = e;
		b.left = c;
		b.right = d;
		e.left = f;
		e.right = g;
		g.left = h;

		BinaryTree<String> binaryTree = new BinaryTree<>();
		binaryTree.nodes.addAll(List.of(a, b, c, d, e, f, g, h));
		binaryTree.head = a;
		System.out.println(binaryTree.preOrderedSearch(binaryTree.head));
	}

	public List<T> preOrderedSearch(Node<T> head) {
		List<T> path = new ArrayList<>();
		preOrderedWalk(head, path);
		return path;
	}

	public List<T> preOrderedWalk(Node<T> curr, List<T> path) {
		if (curr == null) {
			return path;
		}
		path.add(curr.value);
		preOrderedWalk(curr.left, path);
		preOrderedWalk(curr.right, path);
		return path;
	}

	public List<T> breadthFirstSearch(Node<T> head) {
		List<T> path = new ArrayList<>();
		breadthFirstWalk(head, path);
		return path;
	}

	public List<T> breadthFirstWalk(Node<T> curr, List<T> path) {
		Queue<T> queue = new Queue<>();
		queue.enqueue(curr.value);
		while (queue.length != 0) {

		}

		return path;
	}

}
