import java.util.*;

public class DijkstraSearch<V> implements Search<V>{

    private final Map<Vertex<V>, Double> distTo = new HashMap<>();
    private final Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();
    private final PriorityQueue<Vertex<V>> priorityQueue;
    private final Vertex<V> start;

    public DijkstraSearch(WeightedGraph<V> graph, Vertex<V> start) {
        this.start = start;
        Comparator<Vertex<V>> comparator = Comparator.comparingDouble(distTo::get);
        this.priorityQueue = new PriorityQueue<>(comparator);
        for (Vertex<V> v : graph.getVertices()) {
            distTo.put(v, Double.POSITIVE_INFINITY);
        }
        distTo.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Vertex<V> current = priorityQueue.poll();
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                relax(current, entry.getKey(), entry.getValue());
            }
        }
    }

    private void relax(Vertex<V> from, Vertex<V> to, double weight) {
        double newDist = distTo.get(from) + weight;
        if (newDist < distTo.get(to)) {
            distTo.put(to, newDist);
            edgeTo.put(to, from);
            priorityQueue.remove(to);
            priorityQueue.add(to);
        }
    }

    @Override
    public boolean hasPathTo(Vertex<V> dest) {
        return distTo.get(dest) < Double.POSITIVE_INFINITY;
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

    public double getDistance(Vertex<V> dest) {
        return distTo.get(dest);
    }
}