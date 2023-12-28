package Assignments.Assignment10.AdjacencyMatrixRepresentation;

import java.util.Scanner;

/**
 * Provides a simple command-line interface for interacting with the graph.
 */
public class Main {
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
