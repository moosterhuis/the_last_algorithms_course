/**
 * BubbleSort
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 3, 7, 4, 2 };
		bubbleSort(array);
	}

	public static void bubbleSort(int[] array) {
		int upTo = array.length - 1;

		boolean isSorted;
		for (int i = 0; i < array.length; i++) {
			isSorted = true;
			for (int j = 0; j < upTo; j++) {
				int temp = array[j];
				if (array[j] > array[j + 1]) {
					array[j] = array[j + 1];
					array[j + 1] = temp;
					isSorted = false;
				}
			}
			--upTo;
			printArray(array);
			if (isSorted) {
				break;
			}
		}
	}

	public static void printArray(int[] array) {
		String printLine = "";
		for (int i : array) {
			printLine += i;
		}
		System.out.println(printLine);
	}
}
