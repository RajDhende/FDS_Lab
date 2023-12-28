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

