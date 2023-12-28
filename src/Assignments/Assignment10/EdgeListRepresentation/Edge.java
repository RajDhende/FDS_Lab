package Assignments.Assignment10.EdgeListRepresentation;

/**
 * Represents an edge between two vertices in a graph.
 *
 * @param <T> the type of element stored in the edge
 */
public class Edge<T> {
    Vertex<T> u, v;
    T element;

    /**
     * Constructs a new edge between the given vertices with the specified element.
     *
     * @param u       the first vertex
     * @param v       the second vertex
     * @param element the element to be stored in the edge
     */
    public Edge(Vertex<T> u, Vertex<T> v, T element) {
        this.u = u;
        this.v = v;
        this.element = element;
    }
}

