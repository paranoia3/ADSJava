import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {

    private Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private Set<Vertex<V>> marked = new HashSet<>();
    private final Vertex<V> start;

    public BreadthFirstSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;
        bfs(graph, start);
    }

    private void bfs(WeightedGraph<V> graph, Vertex<V> root) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(root);
        marked.add(root);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> dest) {
        return marked.contains(dest);
    }

    @Override
    public List<Vertex<V>> pathTo(Vertex<V> dest) {
        if (!hasPathTo(dest)) return null;
        LinkedList<Vertex<V>> path = new LinkedList<>();
        for (Vertex<V> x = dest; x != start; x = edgeTo.get(x)) {
            path.addFirst(x);
        }

        path.addFirst(start);
        return path;
    }

}