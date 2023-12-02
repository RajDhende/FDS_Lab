package Assignments.Assignment9.EdgeListRepresentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of element stored in the vertex
 */
class Vertex<T> {
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

/**
 * Represents an edge between two vertices in a graph.
 *
 * @param <T> the type of element stored in the edge
 */
class Edge<T> {
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

/**
 * Represents a generic graph.
 *
 * @param <T> the type of element stored in the graph
 */
class Graph<T> {
    List<Vertex<T>> vertices;
    List<Edge<T>> edges;

    /**
     * Constructs a new empty graph.
     */
    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
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
        return edge;
    }

    /**
     * Removes a vertex and its incident edges from the graph.
     *
     * @param v the vertex to be removed
     */
    public void removeVertex(Vertex<T> v) {
        vertices.remove(v);
        Iterator<Edge<T>> edgeIterator = edges.iterator();
        while (edgeIterator.hasNext()) {
            Edge<T> edge = edgeIterator.next();
            if (edge.u == v || edge.v == v) {
                edgeIterator.remove();
            }
        }
    }

    /**
     * Removes an edge from the graph.
     *
     * @param e the edge to be removed
     */
    public void removeEdge(Edge<T> e) {
        edges.remove(e);
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
     * Main method to interact with and demonstrate the functionality of the graph.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nGraph Menu:");
                System.out.println("1. Add Vertex");
                System.out.println("2. Add Edge");
                System.out.println("3. Remove Vertex");
                System.out.println("4. Remove Edge");
                System.out.println("5. Display Vertices");
                System.out.println("6. Display Edges");
                System.out.println("7. Display Outgoing Edges");
                System.out.println("8. Display Incoming Edges");
                System.out.println("9. Display In-Degree");
                System.out.println("10. Display Out-Degree");
                System.out.println("11. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter vertex element: ");
                        String vertexElement = scanner.next();
                        graph.insertVertex(vertexElement);
                        break;

                    case 2:
                        System.out.print("Enter source vertex element: ");
                        String sourceElement = scanner.next();
                        System.out.print("Enter target vertex element: ");
                        String targetElement = scanner.next();
                        System.out.print("Enter edge element: ");
                        String edgeElement = scanner.next();

                        Vertex<String> sourceVertex = findVertex(graph, sourceElement);
                        Vertex<String> targetVertex = findVertex(graph, targetElement);

                        if (sourceVertex != null && targetVertex != null) {
                            graph.insertEdge(sourceVertex, targetVertex, edgeElement);
                            System.out.println("Edge added successfully.");
                        } else {
                            System.out.println("One or both vertices not found.");
                        }
                        break;

                    case 3:
                        System.out.print("Enter vertex element to remove: ");
                        String vertexElementToRemove = scanner.next();
                        Vertex<String> vertexToRemove = findVertex(graph, vertexElementToRemove);

                        if (vertexToRemove != null) {
                            graph.removeVertex(vertexToRemove);
                            System.out.println("Vertex removed successfully.");
                        } else {
                            System.out.println("Vertex not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter source vertex element: ");
                        String sourceElementToRemove = scanner.next();
                        System.out.print("Enter target vertex element: ");
                        String targetElementToRemove = scanner.next();

                        Vertex<String> sourceVertexToRemove = findVertex(graph, sourceElementToRemove);
                        Vertex<String> targetVertexToRemove = findVertex(graph, targetElementToRemove);

                        Edge<String> edgeToRemove = graph.getEdge(sourceVertexToRemove, targetVertexToRemove);

                        if (edgeToRemove != null) {
                            graph.removeEdge(edgeToRemove);
                            System.out.println("Edge removed successfully.");
                        } else {
                            System.out.println("Edge not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Vertices:");
                        for (Iterator<Vertex<String>> it = graph.vertices(); it.hasNext(); ) {
                            Vertex<String> vertex = it.next();
                            System.out.println(vertex.element);
                        }
                        break;

                    case 6:
                        System.out.println("Edges:");
                        for (Iterator<Edge<String>> it = graph.edges(); it.hasNext(); ) {
                            Edge<String> edge = it.next();
                            System.out.println(edge.element);
                        }
                        break;

                    case 7:
                        // ... (existing code)
                        break;

                    case 8:
                        // ... (existing code)
                        break;

                    case 9:
                        // ... (existing code)
                        break;

                    case 10:
                        // ... (existing code)
                        break;

                    case 11:
                        System.out.println("Exiting the program.");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    /**
     * Finds a vertex with the given element in the graph.
     *
     * @param graph   the graph to search
     * @param element the element to search for
     * @return the vertex with the specified element, or null if not found
     */
    private static Vertex<String> findVertex(Graph<String> graph, String element) {
        for (Vertex<String> vertex : graph.vertices) {
            if (vertex.element.equals(element)) {
                return vertex;
            }
        }
        return null;
    }
}
