import java.util.LinkedList;
import java.util.Queue;

public class WeightedAdjacencyMatrix {

	public static void main(String[] args) {
		int[][] weightedAdjacencyMatrix = new int[][] {
				{ 0, 1, 4, 5, 0 },
				{ 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0 },
				{ 0, 0, 0, 0, 5 },
				{ 0, 0, 0, 0, 0 }
		};
	}

	public int breadthFirstSearch(int[][] weightedAdjacencyMatrix, int source, int needle) {
		Queue<Integer> queue = new LinkedList<>();
		int length = weightedAdjacencyMatrix.length;
		boolean[] seen = new boolean[length];
		int[] prev = new int[length];
		for (int i = 0; i < length; i++) {
			prev[i] = -1;
			if (i != 0) {
				seen[i] = true;
			} else {
				seen[i] = false;
			}
		}
		queue.add(weightedAdjacencyMatrix[source][0]);
		do {
			int[] curr = queue.remove();
			if (curr == needle) {
				break;
			}
		} while (queue.size() > 0);

		return -1;
	}
}
