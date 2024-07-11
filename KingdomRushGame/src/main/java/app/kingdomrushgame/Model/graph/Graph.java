package app.kingdomrushgame.Model.graph;

public interface Graph<V, E> {
    int numVertices();
    Iterable<Vertex<V>> vertices();
    int numEdges();
    Iterable<Edge<E>> edges();
    int outDegree(Vertex<V> v);
    Iterable<Edge<E>> outgoingEdges(Vertex<V> v);
    int inDegree(Vertex<V> v);
    Iterable<Edge<E>> incomingEdges(Vertex<V> v);
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v);
    Vertex<V>[] endVertices(Edge<E> e);
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);
    Vertex<V> insertVertex(V element);
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element);
    void removeVertex(Vertex<V> v);
    void removeEdge(Edge<E> e);
}

