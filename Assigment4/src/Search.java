import java.util.List;
public interface Search<V> {
    List<Vertex<V>> findPathTo(Vertex<V> startVertex, Vertex<V> endVertex);
}