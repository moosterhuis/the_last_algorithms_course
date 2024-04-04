import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	public int length;
	public List<Integer> data;

	public MinHeap() {
		this.length = 0;
		this.data = new ArrayList<>();
	}

	public void insert(int value) {

	}

	public void delete(int index) {

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
			data.set(parentIndex, parentValue);
			heapifyUp(index);
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
			heapifyUp(index);
		}
	}

	private int parent(int index) {
		return index - 1 / 2;
	}

	private int leftChild(int index) {
		return index * 2 + 1;
	}

	private int rightChild(int index) {
		return index * 2 + 2;
	}

}
