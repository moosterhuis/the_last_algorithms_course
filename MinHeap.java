import java.util.ArrayList;
import java.util.List;

// This is also called a Priority Queue
public class MinHeap {
	public int length;
	public List<Integer> data;

	public MinHeap() {
		this.length = 0;
		this.data = new ArrayList<>();
	}

	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap();

		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(8);
		minHeap.insert(2);
		minHeap.insert(7);

		System.out.println("Deleted elements:");
		System.out.println(minHeap.delete());
		System.out.println(minHeap.delete());
		System.out.println(minHeap.delete());
		System.out.println(minHeap.delete());
		System.out.println(minHeap.delete());

		System.out.println("Deleted element from empty heap:");
		System.out.println(minHeap.delete());
	}

	public void insert(int value) {
		data.add(value);
		heapifyUp(data.size() - 1);
		length++;
	}

	public int delete() {
		if (data.size() == 0) {
			return -1;
		}
		int value = data.get(0);
		length--;
		if (data.size() == 0) {
			data.clear();
			return value;
		}
		data.set(0, data.get(data.size() - 1));
		data.remove(data.size() - 1);
		heapifyDown(0);
		return value;
	}

	private void heapifyUp(int index) {
		if (index == 0) {
			return;
		}

		int parentIndex = parent(index);
		int parentValue = data.get(parentIndex);
		int childValue = data.get(index);

		if (parentValue > childValue) {
			data.set(parentIndex, childValue);
			data.set(index, parentValue);
			heapifyUp(parentIndex);
		}
	}

	private void heapifyDown(int index) {
		if (index >= data.size()) {
			return;
		}
		int leftChildIndex = leftChild(index);
		int rightChildIndex = rightChild(index);
		if (leftChildIndex >= data.size() || rightChildIndex >= data.size()) {
			return;
		}

		int parentValue = data.get(index);
		int leftChildValue = data.get(leftChildIndex);
		int rightChildValue = data.get(rightChildIndex);
		int minChildValueIndex = -1;

		if (rightChildValue > leftChildValue) {
			minChildValueIndex = leftChildIndex;
		} else {
			minChildValueIndex = rightChildIndex;
		}
		int minChildValue = data.get(minChildValueIndex);

		if (parentValue > leftChildValue && parentValue > rightChildValue) {
			data.set(minChildValueIndex, parentValue);
			data.set(index, minChildValue);
			heapifyDown(minChildValueIndex);
		}
	}

	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return index * 2 + 1;
	}

	private int rightChild(int index) {
		return index * 2 + 2;
	}

}
