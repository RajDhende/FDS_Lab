package Assignments.Assignment10.EdgeListRepresentation;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of element stored in the vertex
 */
public class Vertex<T> {
    T element;

    /**
     * Constructs a new vertex with the given element.
     *
     * @param element the element to be stored in the vertex
     */
    public Vertex(T element) {
        this.element = element;
    }
}