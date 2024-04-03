import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		
	}

	public void sort(int[] arr) {
		int p = arr.length / 2;
		int lo = 0;
		int hi = arr.length - 1;
		int[] left = Arrays.copyOfRange(arr, lo, p-1);
		int[] right = Arrays.copyOfRange(arr, p+1, hi);

		int[] sorted = new int[arr.length];
		for (int i = 0; i < sorted.length; i++) {
			if (arr[i] <= arr[p]) {
				sorted[i] = arr[i];
			}
		}


		
		
	}
}
