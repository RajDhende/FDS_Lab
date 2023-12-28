package Assignments.Assignment10.AdjacencyListRepresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Represents a generic graph.
 *
 * @param <T> the type of element stored in the graph
 */
class Graph<T> {
    List<Vertex<T>> vertices;
    List<Edge<T>> edges;
    Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    /**
     * Constructs a new empty graph.
     */
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
        adjacencyList = new HashMap<>();
    }

    /**
     * Gets the number of vertices in the graph.
     *
     * @return the number of vertices
     */
    public int numVertices() {
        return vertices.size();
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
     * Gets the number of edges in the graph.
     *
     * @return the number of edges
     */
    public int numEdges() {
        return edges.size();
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
     * Gets the edge between two vertices if it exists.
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
     * Gets the end vertices of an edge.
     *
     * @param e the edge
     * @return an array containing the end vertices of the edge
     */
    public Vertex<T>[] endVertices(Edge<T> e) {
        return new Vertex[]{e.u, e.v};
    }

    /**
     * Gets the opposite vertex of a vertex on an edge.
     *
     * @param v the vertex
     * @param e the edge
     * @return the opposite vertex of v on e
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
     * @return an iterator over the outgoing edges of the vertex
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
     * @return an iterator over the incoming edges of the vertex
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
        adjacencyList.put(vertex, new ArrayList<>());
        return vertex;
    }

    /**
     * Inserts a new edge between the given vertices with the specified element into the graph.
     *
     * @param u       the first vertex
     * @param v       the second vertex
     * @param x       the element to be stored in the new edge
     * @return the newly inserted edge
     */
    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, T x) {
        Edge<T> edge = new Edge<>(u, v, x);
        edges.add(edge);
        adjacencyList.get(u).add(edge);
        adjacencyList.get(v).add(edge);
        return edge;
    }

    /**
     * Removes a vertex from the graph along with its incident edges.
     *
     * @param v the vertex to be removed
     */
    public void removeVertex(Vertex<T> v) {
        List<Edge<T>> incidentEdges = new ArrayList<>(v.incidentEdges);
        for (Edge<T> edge : incidentEdges) {
            removeEdge(edge);
        }
        vertices.remove(v);
        adjacencyList.remove(v);
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            adjacencyList.get(vertex).removeIf(edge -> edge.u == v || edge.v == v);
        }
    }


    /**
     * Removes an edge from the graph.
     *
     * @param e the edge to be removed
     */
    public void removeEdge(Edge<T> e) {
        edges.remove(e);
        e.u.incidentEdges.remove(e);
        e.v.incidentEdges.remove(e);
        adjacencyList.get(e.u).remove(e);
        adjacencyList.get(e.v).remove(e);
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
     * Displays the adjacency list of the graph.
     */
    public void displayAdjacencyList() {
        System.out.println("Adjacency List:");
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            System.out.print(vertex.element + ": ");
            for (Edge<T> edge : adjacencyList.get(vertex)) {
                System.out.print("(" +edge.element + ") ");
            }
            System.out.println();
        }
    }
}



