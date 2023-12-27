package Assignments.Assignment6;

import java.util.*;
/**
 * This program represents a tree data structure and provides various operations on the tree,
 * such as adding child nodes, displaying the tree, finding siblings of a node,
 * identifying leaves and internal nodes, determining the depth and height of the tree,
 * obtaining the path to a specific node, finding the subtree rooted at a given node,
 * and exiting the program.
 */

public class Main {

/**
 * The main entry point of the program.
 *
 * @param args Command-line arguments (not used in this program)
 */
public static void main(String[] args) {
    // Create a new tree with the root node "Root"
    Tree<String> tree = new Tree<>("Root");

    // Create a Scanner object for user input
    Scanner scanner = new Scanner(System.in);

    // Continuously prompt the user for an operation until they choose to exit
    while (true) {
        try {
            // Display the menu of operations
            System.out.println("Choose an operation:");
            System.out.println("1. Add child node");
            System.out.println("2. Display tree");
            System.out.println("3. Siblings of a node");
            System.out.println("4. List leaves of the tree");
            System.out.println("5. List internal nodes of the tree");
            System.out.println("6. List path for a given node");
            System.out.println("7. Depth of a node");
            System.out.println("8. Height of the tree");
            System.out.println("9. Subtree rooted at a given node");
            System.out.println("10. Exit");

            // Get the user's choice
            int choice = scanner.nextInt();

            // Handle the selected operation
            switch (choice) {
                case 1:
                    try {
                    System.out.print("Enter parent node data: ");
                    String parentData = scanner.next();
                    System.out.print("Enter child node data: ");
                    String childData = scanner.next();
                    TreeNode<String> parentNode = findNode(tree.getRoot(), parentData);
                    if (parentNode != null) {
                        tree.addChild(parentNode, childData);
                        System.out.println("Child node added.");
                    } else {
                        System.out.println("Parent node not found.");
                    }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                        
                    break;

                // case 2:
                //     // Display tree operation
                //     displayTree(tree.getRoot(), 0);
                //     break;

                case 2:
                    displayTree(tree.getRoot(), 0, "");
                    break;

                case 3:
                try {
                    System.out.print("Enter node data: ");
                    String nodeData = scanner.next();
                    TreeNode<String> node = findNode(tree.getRoot(), nodeData);
                    if (node != null) {
                        List<TreeNode<String>> siblings = tree.getSiblings(node);
                        System.out.println("Siblings of the node:");
                        for (TreeNode<String> sibling : siblings) {
                            System.out.println(sibling.data);
                        }
                    } else {
                        System.out.println("Node not found.");
                    }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                        
                    break;

                case 4:
                try {
                    List<TreeNode<String>> leaves = tree.getLeaves(tree.getRoot());
                    System.out.println("Leaves of the tree:");
                    for (TreeNode<String> leaf : leaves) {
                        System.out.println(leaf.data);
                    }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                        
                    break;

                case 5:
                try {
                    List<TreeNode<String>> internalNodes = tree.getInternalNodes(tree.getRoot());
                    System.out.println("Internal nodes of the tree:");
                    for (TreeNode<String> internalNode : internalNodes) {
                        System.out.println(internalNode.data);
                    }
                        } catch (Exception e) {
                            System.out.println("An error occurred: " + e.getMessage());
                        }
                        
                        break;

                case 6:
                try {
                    System.out.print("Enter node data: ");
                    String nodeData = scanner.next();
                    TreeNode<String> node = findNode(tree.getRoot(), nodeData);
                    if (node != null) {
                        List<TreeNode<String>> path = tree.getPath(node);
                        System.out.println("Path for the given node:");
                        for (TreeNode<String> pathNode : path) {
                            System.out.println(pathNode.data);
                        }
                    } else {
                        System.out.println("Node not found.");
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                        
                    break;

                case 7:
                try {
                    System.out.print("Enter node data: ");
                    String nodeData = scanner.next();
                    TreeNode<String> node = findNode(tree.getRoot(), nodeData);
                    if (node != null) {
                        int depth = tree.getDepth(node);
                        System.out.println("Depth of the node: " + depth);
                    } else {
                        System.out.println("Node not found.");
                    }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                                
                    break;

                case 8:
                try {
                    int height = tree.getHeight();
                    System.out.println("Height of the tree: " + height);
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                    break;

                case 9:
                        try {
                System.out.print("Enter node data: ");
                String nodeData = scanner.next();
                TreeNode<String> node = findNode(tree.getRoot(), nodeData);
                if (node != null) {
                    Tree<String> subtree = tree.getSubtree(node);
                    System.out.println("Subtree rooted at the given node:");
                    displayTree(subtree.getRoot(), 0, "");
                } else {
                    System.out.println("Node not found.");
                }
                } catch (Exception e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                    break;

                case 10:
                    // Exit the program
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // consume the invalid input
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

/**
 * Displays the tree rooted at the specified node.
 *
 * @param node The root node of the subtree to display
 * @param level The current level of indentation
 */
// private static void displayTree(TreeNode<String> node, int level) {
//     StringBuilder indent = new StringBuilder();
//     for (int i = 0; i < level; i++) {
//         indent.append("  ");
//     }
//     System.out.println(indent.toString() + node.data);
//     for (TreeNode<String> child : node.children) {
//         displayTree(child, level + 1);
//     }
// }

private static void displayTree(TreeNode<String> node, int level, String path) {
    StringBuilder indent = new StringBuilder();
    for (int i = 0; i < level; i++) {
        indent.append("  ");
    }
    System.out.println(indent.toString() + path + node.data);
    int childNumber = 1;
    for (TreeNode<String> child : node.children) {
        displayTree(child, level + 1, path + childNumber + ".");
        childNumber ++;
    }
}

/**
 * Finds a node with the specified data in the tree.
 *
 * @param node The current node to search
 * @param targetData The data to search for
 *
 * @return The node with the specified data, or null if not found
 */
private static TreeNode<String> findNode(TreeNode<String> node, String targetData) {
    if (node.data.equals(targetData)) {
        return node;
    }
    for (TreeNode<String> child : node.children) {
        TreeNode<String> found = findNode(child, targetData);
        if (found != null) {
            return found;
        }
    }
    return null;
}
}







   