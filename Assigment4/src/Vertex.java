import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {

    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex() {
    }

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public V getData() {
        return data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<V> vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex<?> vertex)) return false;
        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }

}