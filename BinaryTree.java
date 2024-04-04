import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

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
		// System.out.println(binaryTree.preOrderedSearch(binaryTree.head));
		// System.out.println(binaryTree.breadthFirstWalk(binaryTree.head));
		System.out.println(binaryTree.breadthFirstSearch(binaryTree.head, "h"));
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

	public List<T> breadthFirstWalk(Node<T> head) {
		List<T> path = new ArrayList<>();
		Queue<Node<T>> queue = new ConcurrentLinkedQueue<>();
		queue.add(head);
		while (queue.size() != 0) {
			Node<T> node = queue.poll();
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			path.add(node.value);
		}
		return path;
	}

	public boolean breadthFirstSearch(Node<T> head, T value) {
		Queue<Node<T>> queue = new ConcurrentLinkedQueue<>();
		queue.add(head);
		while (queue.size() != 0) {
			Node<T> node = queue.poll();
			if (node.value == value) {
				return true;
			}
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return false;
	}

}
