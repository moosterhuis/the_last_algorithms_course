public class ChrystalBalls {

	public static void main(String[] args) {

		boolean[] breaks = new boolean[] { false, true, true, true, true, true, true, true };
		System.out.println(search(breaks));
	}

	public static int search(boolean[] breaks) {
		int subHeight = (int) Math.sqrt(breaks.length);
		int i = subHeight;
		for (; i < breaks.length; i += subHeight) {
			if (breaks[i]) {
				break;
			}
		}

		i -= subHeight;
		for (int j = 0; j <= subHeight && i < breaks.length; i++, j++) {
			if (breaks[i]) {
				return i;
			}
		}
		return -1;

	}
}
