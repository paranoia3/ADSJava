import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    private final Set<Vertex<V>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, double weight) {
        source.addAdjacentVertex(dest, weight);
        addVertex(source);
        addVertex(dest);
    }

    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}