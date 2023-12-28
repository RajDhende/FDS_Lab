package Assignments.Assignment10.AdjacencyMapRepresentation;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a vertex in a graph.
 *
 * @param <T> the type of element stored in the vertex
 */
public class Vertex<T> {
    T element;
    Map<Vertex<T>, Edge<T>> incidentEdges;

    /**
     * Constructs a new vertex with the given element.
     *
     * @param element the element to be stored in the vertex
     */
    public Vertex(T element) {
        this.element = element;
        this.incidentEdges = new HashMap<>();
    }
}
