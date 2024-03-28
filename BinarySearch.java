public class BinarySearch {

	public static void main(String[] args) {

		int[] haystack = new int[]{0,2,3,4,5,6,7,8,10};
		int needle = 6;
		System.out.println(search(haystack, needle));
	}

	public static int search(int[] haystack, int needle) {

		int lo = 0;
		int hi = haystack.length;

		while (hi > lo) {
			int m = lo + (hi - lo) / 2;
			if (haystack[m] == needle) {
				return m;
			} else if (needle < haystack[m]) {
				hi = m;
			} else {
				lo = m + 1;
			}
		}
		return -1;
	}
}
