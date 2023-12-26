package Assignments.Assignment10.AdjacencyMatrixRepresentation;

import java.util.*;

/**
 * Represents a graph using an adjacency matrix for integer vertices.
 */
class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    /**
     * Constructs a graph with a specified number of vertices.
     *
     * @param numVertices the number of vertices in the graph
     */
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    /**
     * Gets the number of vertices in the graph.
     *
     * @return the number of vertices
     */
    public int numVertices() {
        return numVertices;
    }

    /**
     * Gets a list of vertices in the graph.
     *
     * @return a list of vertices
     */
    public List<Integer> vertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    /**
     * Gets the number of edges in the graph.
     *
     * @return the number of edges
     */
    public int numEdges() {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    count++;
                }
            }
        }
        return count / 2; // Since each edge is counted twice
    }

    /**
     * Gets a list of edges in the graph.
     *
     * @return a list of edges
     */
    public List<String> edges() {
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            for (int j = i; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    edges.add("(" + i + ", " + j + ")");
                }
            }
        }
        return edges;
    }

    /**
     * Gets the edge between two vertices.
     *
     * @param u the first vertex
     * @param v the second vertex
     * @return the edge between the vertices, or null if not found
     */
    public String getEdge(int u, int v) {
        return adjacencyMatrix[u][v] == 1 ? "(" + u + ", " + v + ")" : null;
    }

    /**
     * Gets the end vertices of an edge.
     *
     * @param edge the edge
     * @return an array containing the end vertices
     */
    public int[] endVertices(String edge) {
        int[] vertices = new int[2];
        vertices[0] = Integer.parseInt(edge.substring(1, edge.indexOf(',')));
        vertices[1] = Integer.parseInt(edge.substring(edge.indexOf(',') + 2, edge.indexOf(')')));
        return vertices;
    }

    /**
     * Gets the opposite vertex of an edge relative to a given vertex.
     *
     * @param v    the reference vertex
     * @param edge the edge
     * @return the opposite vertex
     */
    public int opposite(int v, String edge) {
        int[] vertices = endVertices(edge);
        if (vertices[0] == v) {
            return vertices[1];
        } else if (vertices[1] == v) {
            return vertices[0];
        } else {
            return -1; // Edge is not incident to v
        }
    }

    /**
     * Gets the out-degree of a vertex.
     *
     * @param v the vertex
     * @return the out-degree of the vertex
     */
    public int outDegree(int v) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
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
    public int inDegree(int v) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets a list of outgoing edges of a vertex.
     *
     * @param v the vertex
     * @return a list of outgoing edges
     */
    public List<String> outGoingEdges(int v) {
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                edges.add("(" + v + ", " + i + ")");
            }
        }
        return edges;
    }

    /**
     * Gets a list of incoming edges of a vertex.
     *
     * @param v the vertex
     * @return a list of incoming edges
     */
    public List<String> inComingEdges(int v) {
        List<String> edges = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[i][v] == 1) {
                edges.add("(" + i + ", " + v + ")");
            }
        }
        return edges;
    }

    /**
     * Inserts a new vertex into the graph.
     *
     * @param x the vertex to be inserted
     */
    public void insertVertex(int x) {
        int[][] newMatrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newMatrix[i][j] = adjacencyMatrix[i][j];
            }
        }
        numVertices++;
        adjacencyMatrix = newMatrix;
    }

    /**
     * Inserts a new edge between two vertices.
     *
     * @param u the first vertex
     * @param v the second vertex
     * @param x the value of the edge
     */
    public void insertEdge(int u, int v, int x) {
        adjacencyMatrix[u][v] = x;
        adjacencyMatrix[v][u] = x;
    }

    /**
     * Adds an edge between two vertices.
     *
     * @param i the first vertex
     * @param j the second vertex
     */
    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    /**
     * Removes an edge between two vertices.
     *
     * @param i the first vertex
     * @param j the second vertex
     */
    public void removeEdge(int i, int j) {
        adjacencyMatrix[i][j] = 0;
        adjacencyMatrix[j][i] = 0;
    }

    /**
     * Checks if there is an edge between two vertices.
     *
     * @param i the first vertex
     * @param j the second vertex
     * @return true if there is an edge, false otherwise
     */
    public boolean isEdge(int i, int j) {
        return adjacencyMatrix[i][j] == 1;
    }

    /**
     * Gets the adjacency matrix of the graph.
     *
     * @return the adjacency matrix
     */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}

/**
 * Provides a simple command-line interface for interacting with the graph.
 */
class GraphInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int numVertices = scanner.nextInt();
        Graph graph = new Graph(numVertices);

        try {
            while (true) {
                System.out.println("\n1. Add Edge");
                System.out.println("2. Remove Edge");
                System.out.println("3. Check Edge");
                System.out.println("4. Print Graph");
                System.out.println("5. Print Vertices");
                System.out.println("6. Print Edges");
                System.out.println("7. Get Edge");
                System.out.println("8. Out Degree");
                System.out.println("9. In Degree");
                System.out.println("10. Outgoing Edges");
                System.out.println("11. Incoming Edges");
                System.out.println("12. Exit");
                System.out.println("Enter your choice:");
                int choice = scanner.nextInt();

                int u, v;
                String e;
                switch (choice) {
                    case 1:
                        System.out.println("Enter the vertices u and v to add an edge:");
                        u = scanner.nextInt();
                        v = scanner.nextInt();
                        graph.addEdge(u, v);
                        break;
                    case 2:
                        System.out.println("Enter the vertices u and v to remove an edge:");
                        u = scanner.nextInt();
                        v = scanner.nextInt();
                        graph.removeEdge(u, v);
                        break;
                    case 3:
                        System.out.println("Enter the vertices u and v to check if an edge exists:");
                        u = scanner.nextInt();
                        v = scanner.nextInt();
                        if (graph.isEdge(u, v)) {
                            System.out.println("An edge exists between " + u + " and " + v + ".");
                        } else {
                            System.out.println("No edge exists between " + u + " and " + v + ".");
                        }
                        break;
                    case 4:
                        System.out.println("The adjacency matrix is:");
                        for (int i = 0; i < numVertices; i++) {
                            for (int j = 0; j < numVertices; j++) {
                                System.out.print(graph.getAdjacencyMatrix()[i][j] + " ");
                            }
                            System.out.println();
                        }
                        break;
                    case 5:
                        System.out.println("The vertices are: " + graph.vertices());
                        break;
                    case 6:
                        System.out.println("The edges are: " + graph.edges());
                        break;
                    case 7:
                        System.out.println("Enter the vertices u and v to get the edge:");
                        u = scanner.nextInt();
                        v = scanner.nextInt();
                        System.out.println("The edge is: " + graph.getEdge(u, v));
                        break;

                    case 8:
                        System.out.println("Enter the vertex to get the out degree:");
                        v = scanner.nextInt();
                        System.out.println("The out degree is: " + graph.outDegree(v));
                        break;
                    case 9:
                        System.out.println("Enter the vertex to get the in degree:");
                        v = scanner.nextInt();
                        System.out.println("The in degree is: " + graph.inDegree(v));
                        break;
                    case 10:
                        System.out.println("Enter the vertex to get the outgoing edges:");
                        v = scanner.nextInt();
                        System.out.println("The outgoing edges are: " + graph.outGoingEdges(v));
                        break;
                    case 11:
                        System.out.println("Enter the vertex to get the incoming edges:");
                        v = scanner.nextInt();
                        System.out.println("The incoming edges are: " + graph.inComingEdges(v));
                        break;
                    case 12:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 16.");
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        } finally {
            scanner.close();
        }
    }
}
