import java.util.ArrayList;
import java.util.List;

class Edge {
	public int to;
	public int weigth;

	public Edge(int to, int weigth) {
		this.to = to;
		this.weigth = weigth;
	}

}

public class WeightedAdjacencyList {

	public static void main(String[] args) {
		Edge[][] graph = {
				{ new Edge(1, 1), new Edge(2, 4), new Edge(3, 5) },
				{},
				{ new Edge(3, 2) },
				{ new Edge(4, 5) },
				{}
		};
		System.out.println(depthFirstSearch(graph, 0, 2));
	}

	public static List<Integer> depthFirstSearch(Edge[][] graph, int source, int needle) {
		boolean[] seen = new boolean[graph.length];
		for (int i = 0; i < seen.length; i++) {
			seen[i] = false;
		}
		List<Integer> path = new ArrayList<>();
		walk(graph, source, needle, path, seen);
		return path;
	}

	public static boolean walk(Edge[][] graph, int curr, int needle, List<Integer> path, boolean[] seen) {

		if (seen[curr]) {
			return false;
		}
		seen[curr] = true;

		// pre
		if (curr == needle) {
			path.add(curr);
			return true;
		}
		// recurse
		Edge[] list = graph[curr];
		for (Edge edge : list) {
			if (walk(graph, edge.to, needle, path, seen)) {
				path.add(0, curr);
				return true;
			}
		}
		// post
		return false;
	}
}
