package Assignments.Assignment10.AdjacencyMapRepresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A class representing a graph with vertices and edges.
 *
 * @param <T> the type of element stored in the graph
 */
class Graph<T> {
    List<Vertex<T>> vertices;
    List<Edge<T>> edges;
    Map<Vertex<T>, Map<Vertex<T>, Edge<T>>> adjacencyMap;

    /**
     * Constructs a new graph.
     */
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        adjacencyMap = new HashMap<>();
    }


    /**
     * Gets an iterator over the vertices in the graph.
     *
     * @return an iterator over the vertices
     */
    public Iterator<Vertex<T>> vertices() {
        return vertices.iterator();
    }

    /**
     * Gets an iterator over the edges in the graph.
     *
     * @return an iterator over the edges
     */
    public Iterator<Edge<T>> edges() {
        return edges.iterator();
    }

    /**
     * Gets the edge between two vertices.
     *
     * @param u the first vertex
     * @param v the second vertex
     * @return the edge between the vertices, or null if not found
     */
    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> edge : edges) {
            if ((edge.u == u && edge.v == v) || (edge.u == v && edge.v == u)) {
                return edge;
            }
        }
        return null;
    }


    /**
     * Gets the opposite vertex of an edge relative to a given vertex.
     *
     * @param v the reference vertex
     * @param e the edge
     * @return the opposite vertex
     */
    public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {
        return (e.u == v) ? e.v : e.u;
    }

    /**
     * Gets the out-degree of a vertex.
     *
     * @param v the vertex
     * @return the out-degree of the vertex
     */
    public int outDegree(Vertex<T> v) {
        int count = 0;
        for (Edge<T> edge : edges) {
            if (edge.u == v) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the in-degree of a vertex.
     *
     * @param v the vertex
     * @return the in-degree of the vertex
     */
    public int inDegree(Vertex<T> v) {
        int count = 0;
        for (Edge<T> edge : edges) {
            if (edge.v == v) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets an iterator over the outgoing edges of a vertex.
     *
     * @param v the vertex
     * @return an iterator over the outgoing edges
     */
    public Iterator<Edge<T>> outGoingEdges(Vertex<T> v) {
        List<Edge<T>> outgoingEdges = new ArrayList<>();
        for (Edge<T> edge : edges) {
            if (edge.u == v) {
                outgoingEdges.add(edge);
            }
        }
        return outgoingEdges.iterator();
    }

    /**
     * Gets an iterator over the incoming edges of a vertex.
     *
     * @param v the vertex
     * @return an iterator over the incoming edges
     */
    public Iterator<Edge<T>> inComingEdges(Vertex<T> v) {
        List<Edge<T>> incomingEdges = new ArrayList<>();
        for (Edge<T> edge : edges) {
            if (edge.v == v) {
                incomingEdges.add(edge);
            }
        }
        return incomingEdges.iterator();
    }

    /**
     * Inserts a new vertex with the given element into the graph.
     *
     * @param x the element to be stored in the new vertex
     * @return the newly inserted vertex
     */
    public Vertex<T> insertVertex(T x) {
        Vertex<T> vertex = new Vertex<>(x);
        vertices.add(vertex);
        adjacencyMap.put(vertex, new HashMap<>());
        return vertex;
    }

    /**
     * Inserts a new edge with the given element between the given vertices into the graph.
     *
     * @param u the first vertex
     * @param v the second vertex
     * @param x the element to be stored in the new edge
     * @return the newly inserted edge
     */
    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, T x) {
        Edge<T> edge = new Edge<>(u, v, x);
        edges.add(edge);
        adjacencyMap.get(u).put(v, edge);
        adjacencyMap.get(v).put(u, edge);
        return edge;
    }

    /**
     * Removes a vertex from the graph along with its incident edges.
     *
     * @param v the vertex to be removed
     */
    public void removeVertex(Vertex<T> v) {
        List<Edge<T>> incidentEdges = new ArrayList<>(v.incidentEdges.values());
        for (Edge<T> edge : incidentEdges) {
            removeEdge(edge);
        }
        vertices.remove(v);
        adjacencyMap.remove(v);

        for (Vertex<T> vertex : adjacencyMap.keySet()) {
            adjacencyMap.get(vertex).remove(v);
        }
    }

    /**
     * Removes a specific edge from the graph.
     *
     * @param e the edge to be removed
     */
    public void removeEdge(Edge<T> e) {
        edges.remove(e);
        e.u.incidentEdges.remove(e.v);
        e.v.incidentEdges.remove(e.u);
        adjacencyMap.get(e.u).remove(e.v);
        adjacencyMap.get(e.v).remove(e.u);
    }

    /**
     * Displays the incoming edges of a vertex.
     *
     * @param v the vertex
     */
    public void displayIncomingEdges(Vertex<T> v) {
        System.out.println("Incoming edges to vertex " + v.element + ":");
        for (Iterator<Edge<T>> it = inComingEdges(v); it.hasNext();) {
            Edge<T> edge = it.next();
            System.out.println(edge.element);
        }
    }

    /**
     * Displays the in-degree of a vertex.
     *
     * @param v the vertex
     */
    public void displayInDegree(Vertex<T> v) {
        System.out.println("In-degree of vertex " + v.element + ": " + inDegree(v));
    }

    /**
     * Displays the out-degree of a vertex.
     *
     * @param v the vertex
     */
    public void displayOutDegree(Vertex<T> v) {
        System.out.println("Out-degree of vertex " + v.element + ": " + outDegree(v));
    }

    /**
     * Displays the adjacency map of the graph.
     */
    public void displayAdjacencyMap() {
        System.out.println("Adjacency Map:");
        for (Vertex<T> vertex : adjacencyMap.keySet()) {
            System.out.print(vertex.element + ": ");
            for (Edge<T> edge : adjacencyMap.get(vertex).values()) {
                System.out.print("(" + opposite(vertex, edge).element + ", " + edge.element + ") ");
            }
            System.out.println();
        }
    }

}
