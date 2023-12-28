package Assignments.Assignment10.AdjacencyListRepresentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of element stored in the vertex
 */
public class Vertex<T> {
    T element;
    List<Edge<T>> incidentEdges;

    /**
     * Constructs a new vertex with the given element.
     *
     * @param element the element to be stored in the vertex
     */
    public Vertex(T element) {
        this.element = element;
        this.incidentEdges = new ArrayList<>();
    }
}
