import java.util.List;

public class Main {

    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();

        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);

        graph.addEdge(v1, v2, 10.0);
        graph.addEdge(v2, v3, 5.0);
        graph.addEdge(v3, v4, 2.5);
        graph.addEdge(v1, v4, 100.0);

        System.out.println("BFS:");
        BreadthFirstSearch<Integer> bfs = new BreadthFirstSearch<>(graph, v1);
        List<Vertex<Integer>> pathBFS = bfs.pathTo(v4);
        System.out.println(pathBFS);

        System.out.println("Dijkstra:");
        DijkstraSearch<Integer> dijkstra = new DijkstraSearch<>(graph, v1);
        List<Vertex<Integer>> pathDijkstra = dijkstra.pathTo(v4);
        System.out.println(pathDijkstra);
        System.out.println("Distance: " + dijkstra.getDistance(v4));
    }
}