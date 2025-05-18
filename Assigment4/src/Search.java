import java.util.List;

public interface Search<V> {
    boolean hasPathTo(Vertex<V> dest);
    List<Vertex<V>> pathTo(Vertex<V> dest);
}