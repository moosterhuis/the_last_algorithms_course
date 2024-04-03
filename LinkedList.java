class Node<T> {
	public T value;
	public Node<T> previous;
	public Node<T> next;

	public Node(T value, Node<T> previous, Node<T> next) {
		this.value = value;
		this.previous = previous;
		this.next = next;
	}

}

public class LinkedList<T> {

	public int length;
	public Node<T> head;
	public Node<T> tail;

	public LinkedList() {
		this.length = 0;
		this.head = null;
		this.tail = null;
	}

	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.append("test1");
		linkedList.print();
		linkedList.append("test2");
		linkedList.print();
		linkedList.prepend("prepend");
		linkedList.print();
		linkedList.append("append");
		linkedList.print();
		linkedList.remove("test1");
		linkedList.print();
		linkedList.insertAt("insert", 2);
		linkedList.print();
		linkedList.removeAt(1);
		linkedList.print();
		System.out.println("get: " + linkedList.get(2));
	}

	public void print() {
		Node<T> node = head;

		for (int i = 0; i < length; i++) {
			if (i == 0) {
				System.out.println("---");
			}
			System.out.println(node.value);
			node = node.next;
		}
	}

	public void insertAt(T value, int index) {
		if (index > length || index < 0) {
			throw new IllegalArgumentException("Index '" + index + "' is out of bounds.");
		}
		Node<T> currentNode = head;
		for (int i = 0; i < length; i++) {
			if (i == index) {
				if (currentNode == head) {
					prepend(value);
					break;
				}
				Node<T> node = new Node<>(value, null, null);
				if (currentNode == tail) {
					node.previous = currentNode.previous;
					node.next = currentNode;
					currentNode.previous.next = node;
					currentNode.previous = node;
					tail = node;
					this.length++;
					break;
				}
				node.next = currentNode;
				node.previous = currentNode.previous;
				currentNode.previous.next = node;
				currentNode.previous = node;
				this.length++;
				break;
			}
			currentNode = currentNode.next;
		}
	}

	public void remove(T value) {
		Node<T> currentNode = head;
		for (int i = 0; i < length; i++) {
			if (currentNode.value == value) {
				if (currentNode == head) {
					currentNode.next.previous = null;
					currentNode.next = head;
					currentNode = null;
					this.length--;
					break;
				}
				if (currentNode == tail) {
					currentNode.previous.next = null;
					currentNode.previous = tail;
					currentNode = null;
					this.length--;
					break;
				}
				currentNode.next.previous = currentNode.previous;
				currentNode.previous.next = currentNode.next;
				currentNode = null;
				this.length--;
				break;
			}
			currentNode = currentNode.next;
		}
	}

	public void removeAt(int index) {
		if (index > length || index < 0) {
			throw new IllegalArgumentException("Index '" + index + "' is out of bounds.");
		}
		Node<T> currentNode = head;
		for (int i = 0; i < length; i++) {
			if (i == index) {
				this.length--;
				if (currentNode == head) {
					currentNode.next.previous = null;
					currentNode.next = head;
					currentNode = null;
					break;
				}
				if (currentNode == tail) {
					currentNode.previous.next = null;
					currentNode.previous = tail;
					currentNode = null;
					break;
				}
				currentNode.next.previous = currentNode.previous;
				currentNode.previous.next = currentNode.next;
				currentNode = null;
				break;
			}
			currentNode = currentNode.next;
		}
	}

	public void append(T value) {
		this.length++;
		Node<T> node = new Node<>(value, null, null);
		if (tail == null) {
			tail = head = node;
			return;
		}
		node.previous = tail;
		tail.next = node;
		tail = node;
	}

	public void prepend(T value) {
		this.length++;
		Node<T> node = new Node<>(value, null, null);
		if (head == null) {
			head = tail = node;
			return;
		}
		node.next = head;
		head.previous = node;
		head = node;
	}

	public T get(int index) {
		if (index > length || index < 0) {
			throw new IllegalArgumentException("Index '" + index + "' is out of bounds.");
		}
		Node<T> currentNode = head;
		for (int i = 0; i < length; i++) {
			if (i == index) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

}
