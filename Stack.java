class Node<T> {
	T value;
	Node<T> prev;

	public Node(T value) {
		this.value = value;
		this.prev = null;
	}
}

public class Stack<T> {
	int length;
	Node<T> head;

	public Stack() {
		this.length = 0;
		this.head = null;
	}

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("hello");
		stack.push("world");
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
	}

	public T pop() {
		if (this.length == 0) {
			return null;
		}
		--this.length;
		Node<T> head = this.head;
		this.head = this.head.prev;
		head.prev = null;
		return head.value;
	}

	public void push(T value) {
		Node<T> node = new Node<>(value);
		++this.length;
		node.prev = this.head;
		this.head = node;
	}

	public T peek() {
		return this.head.value;
	}

}
