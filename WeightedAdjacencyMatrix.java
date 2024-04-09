import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeightedAdjacencyMatrix {

	public static void main(String[] args) {
		int[][] graph = new int[][] {
				{ 0, 1, 4, 10, 0 },
				{ 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0 },
				{ 0, 0, 0, 0, 5 },
				{ 0, 0, 0, 0, 0 }
		};
		WeightedAdjacencyMatrix weightedAdjacencyMatrix = new WeightedAdjacencyMatrix();

		System.out.println(weightedAdjacencyMatrix.breadthFirstSearch(graph, 0, 4));
	}

	public List<Integer> breadthFirstSearch(int[][] graph, int source, int needle) {
		Queue<Integer> queue = new LinkedList<>();
		int length = graph.length;
		boolean[] seen = new boolean[length];
		int[] prev = new int[length];
		for (int i = 0; i < length; i++) {
			prev[i] = -1;
			seen[i] = false;
		}

		queue.add(source);
		seen[source] = true;
		while (!queue.isEmpty()) {
			int curr = queue.remove();
			if (curr == needle) {
				break;
			}
			for (int i = 0; i < graph[curr].length; i++) {
				if (graph[curr][i] == 0 || seen[i]) {
					continue;
				}
				seen[i] = true;
				prev[i] = curr;
				queue.add(i);
			}
		}
		List<Integer> out = new ArrayList<>();
		int curr = needle;
		while (prev[curr] != -1) {
			out.add(curr);
			curr = prev[curr];
		}
		if (!out.isEmpty()) {
			out.add(source);
			Collections.reverse(out);
		}
		return out;
	}

}
