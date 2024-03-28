class Node<T> {
	T value;
	Node<T> next;

	public Node(T value) {
		this.value = value;
	}
}

class Queue<T> {

	public int length;
	private Node<T> head;
	private Node<T> tail;

	public Queue() {
		this.length = 0;
		this.head = this.tail = null;
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<>();
		queue.enqueue("hello");
		queue.enqueue("world");
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

	public void enqueue(T value) {
		Node<T> node = new Node<T>(value);
		if (length == 0) {
			this.head = this.tail = node;
		}
		this.tail.next = node;
		this.tail = node;
		++length;
	}

	public T dequeue() {
		if (this.head == null) {
			return null;
		}
		--length;
		Node<T> head = this.head;
		this.head = this.head.next;
		if (this.length == 0) {
			this.tail = null;
		}
		head.next = null;
		return head.value;
	}

	public T peek() {
		return head.value;
	}

}
