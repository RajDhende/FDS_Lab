package Assignments.Assignment10.AdjacencyListRepresentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of element stored in the vertex
 */
class Vertex<T> {
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

    /**
     * Main method to interact with and demonstrate the functionality of the graph.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                try {
                    System.out.println("\nGraph Menu:");
                    System.out.println("1. Add Vertex");
                    System.out.println("2. Add Edge");
                    System.out.println("3. Display Vertices");
                    System.out.println("4. Display Edges");
                    System.out.println("5. Display Outgoing Edges");
                    System.out.println("6. Display Incoming Edges");
                    System.out.println("7. Display In-Degree");
                    System.out.println("8. Display Out-Degree");
                    System.out.println("9. Display Adjacency List");
                    System.out.println("10. Remove a vertex");
                    System.out.println("11. Remove an edge");
                    System.out.println("12. Exit");
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
                            System.out.println("Vertices:");
                            for (Iterator<Vertex<String>> it = graph.vertices(); it.hasNext(); ) {
                                Vertex<String> vertex = it.next();
                                System.out.println(vertex.element);
                            }
                            break;

                        case 4:
                            System.out.println("Edges:");
                            for (Iterator<Edge<String>> it = graph.edges(); it.hasNext(); ) {
                                Edge<String> edge = it.next();
                                System.out.println(edge.element);
                            }
                            break;

                        case 5:
                            System.out.print("Enter vertex element to display outgoing edges: ");
                            String vertexElementOutgoing = scanner.next();
                            Vertex<String> vertexOutgoing = findVertex(graph, vertexElementOutgoing);

                            if (vertexOutgoing != null) {
                                System.out.println("Outgoing edges from " + vertexOutgoing.element + ":");
                                for (Iterator<Edge<String>> it = graph.outGoingEdges(vertexOutgoing); it.hasNext(); ) {
                                    Edge<String> edge = it.next();
                                    System.out.println(edge.element);
                                }
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 6:
                            System.out.print("Enter vertex element to display incoming edges: ");
                            String vertexElementIncoming = scanner.next();
                            Vertex<String> vertexIncoming = findVertex(graph, vertexElementIncoming);

                            if (vertexIncoming != null) {
                                graph.displayIncomingEdges(vertexIncoming);
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 7:
                            System.out.print("Enter vertex element to display in-degree: ");
                            String vertexElementInDegree = scanner.next();
                            Vertex<String> vertexInDegree = findVertex(graph, vertexElementInDegree);

                            if (vertexInDegree != null) {
                                graph.displayInDegree(vertexInDegree);
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 8:
                            System.out.print("Enter vertex element to display out-degree: ");
                            String vertexElementOutDegree = scanner.next();
                            Vertex<String> vertexOutDegree = findVertex(graph, vertexElementOutDegree);

                            if (vertexOutDegree != null) {
                                graph.displayOutDegree(vertexOutDegree);
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 9:
                            graph.displayAdjacencyList();
                            break;

                        case 10:
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

                        case 11:
                            System.out.print("Enter source vertex element to remove edge: ");
                            String sourceElementToRemove = scanner.next();
                            System.out.print("Enter target vertex element to remove edge: ");
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

                        case 12:
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        } finally {
            scanner.close();
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



