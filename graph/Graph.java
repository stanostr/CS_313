package graph;

public interface Graph<V, E>
{
    int numVertices();

    int numEdges();

    Iterable<Vertex<V>> vertices();

    Iterable<Edge<E>> edges();

    int outDegree(Vertex<V> paramVertex)
            throws IllegalArgumentException;

    int inDegree(Vertex<V> paramVertex)
            throws IllegalArgumentException;

    Iterable<Edge<E>> outgoingEdges(Vertex<V> paramVertex)
            throws IllegalArgumentException;

    Iterable<Edge<E>> incomingEdges(Vertex<V> paramVertex)
            throws IllegalArgumentException;

    Edge<E> getEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2)
            throws IllegalArgumentException;

    Vertex<V>[] endVertices(Edge<E> paramEdge)
            throws IllegalArgumentException;

    Vertex<V> opposite(Vertex<V> paramVertex, Edge<E> paramEdge)
            throws IllegalArgumentException;

    Vertex<V> insertVertex(V paramV);

    Edge<E> insertEdge(Vertex<V> paramVertex1, Vertex<V> paramVertex2, E paramE)
            throws IllegalArgumentException;

    void removeVertex(Vertex<V> paramVertex)
            throws IllegalArgumentException;

    void removeEdge(Edge<E> paramEdge)
            throws IllegalArgumentException;
}