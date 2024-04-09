import java.util.List;

class Edge {
	int to;
	int weigth;

	public Edge(int to, int weigth) {
		this.to = to;
		this.weigth = weigth;
	}

}

public class WeightedAdjacencyList {

	public static void main(String[] args) {
		Edge[][] graph = {
				{ new Edge(1, 1), new Edge(2, 4), new Edge(3, 5) },
				{ new Edge(0, 1) },
				{ new Edge(2, 1) },
		};
	}

	public List<Integer> depthFirstSearch(Edge[][] graph, int source, int needle) {
		return null;
	}
}
