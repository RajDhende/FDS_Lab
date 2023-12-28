package Assignments.Assignment10.EdgeListRepresentation;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
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
                            System.out.print("Enter vertex element: ");
                            String outVertexElement = scanner.next();
                            Vertex<String> outVertex = findVertex(graph, outVertexElement);

                            if (outVertex != null) {
                                System.out.println("Outgoing edges from vertex " + outVertex.element + ":");
                                for (Iterator<Edge<String>> it = graph.outGoingEdges(outVertex); it.hasNext(); ) {
                                    Edge<String> edge = it.next();
                                    System.out.println(edge.element);
                                }
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 8:
                            System.out.print("Enter vertex element: ");
                            String inVertexElement = scanner.next();
                            Vertex<String> inVertex = findVertex(graph, inVertexElement);

                            if (inVertex != null) {
                                graph.displayIncomingEdges(inVertex);
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 9:
                            System.out.print("Enter vertex element: ");
                            String inDegreeVertexElement = scanner.next();
                            Vertex<String> inDegreeVertex = findVertex(graph, inDegreeVertexElement);

                            if (inDegreeVertex != null) {
                                graph.displayInDegree(inDegreeVertex);
                            } else {
                                System.out.println("Vertex not found.");
                            }
                            break;

                        case 10:
                            System.out.print("Enter vertex element: ");
                            String outDegreeVertexElement = scanner.next();
                            Vertex<String> outDegreeVertex = findVertex(graph, outDegreeVertexElement);

                            if (outDegreeVertex != null) {
                                graph.displayOutDegree(outDegreeVertex);
                            } else {
                                System.out.println("Vertex not found.");
                            }
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
        }  catch (Exception e) {
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
