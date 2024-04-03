public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[] { 9, 3, 7, 4, 69, 420, 42 };
		sort(array, 0, array.length - 1);
		print(array);
	}

	private static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				System.out.print(array[i]);
			} else {
				System.out.print("," + array[i]);
			}
		}
	}

	public static void sort(int[] array, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int pivot_index = partition(array, lo, hi);
		sort(array, lo, pivot_index - 1);
		sort(array, pivot_index + 1, hi);

	}

	public static int partition(int[] array, int lo, int hi) {
		int pivot = array[hi];
		int pivot_index = lo - 1;
		for (int i = lo; i < hi; i++) {
			if (array[i] <= pivot) {
				pivot_index++;
				int tmp = array[i];
				array[i] = array[pivot_index];
				array[pivot_index] = tmp;
			}
		}
		pivot_index++;
		array[hi] = array[pivot_index];
		array[pivot_index] = pivot;
		return pivot_index;
	}

}
