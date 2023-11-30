package Assignments.Assignment7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Node class representing a node in a binary tree.
 *
 * @param <T> Type of the key in the node.
 */
class Node<T> {
    T key;
    Node<T> left, right;

    /**
     * Constructor to create a new node with the specified key.
     *
     * @param item The key value of the node.
     */
    public Node(T item) {
        key = item;
        left = right = null;
    }
}

/**
 * BinaryTree class representing a binary tree with generic key values.
 *
 * @param <T> Type of the key in the binary tree.
 */
class BinaryTree<T> {
    Node<T> root;

    /**
     * Constructor to create a binary tree with a specified root key.
     *
     * @param key The key value for the root node.
     */
    BinaryTree(T key) {
        root = new Node<>(key);
    }

    /**
     * Default constructor to create an empty binary tree.
     */
    BinaryTree() {
        root = null;
    }

    /**
     * Recursive method to print the binary tree.
     *
     * @param node   The current node in the traversal.
     * @param prefix The prefix for indentation.
     * @param isLeft True if the current node is the left child, false otherwise.
     */
    void printTree(Node<T> node, String prefix, boolean isLeft) {
        if (node != null) {
            printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.key);
            printTree(node.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    /**
     * Method to print the entire binary tree.
     */
    void printTree() {
        printTree(root, "", true);
    }

    /**
     * Method to add a left child to a specified parent node.
     *
     * @param parentValue The key value of the parent node.
     * @param childValue  The key value of the left child to be added.
     */
    void addLeftChild(T parentValue, T childValue) {
        Node<T> parentNode = findNode(root, parentValue);
        if (parentNode != null) {
            parentNode.left = new Node<>(childValue);
        } else {
            System.out.println("Parent not found.");
        }
    }

    /**
     * Method to add a right child to a specified parent node.
     *
     * @param parentValue The key value of the parent node.
     * @param childValue  The key value of the right child to be added.
     */
    void addRightChild(T parentValue, T childValue) {
        Node<T> parentNode = findNode(root, parentValue);
        if (parentNode != null) {
            parentNode.right = new Node<>(childValue);
        } else {
            System.out.println("Parent not found.");
        }
    }

    /**
     * Recursive method to find a node with a specific key value.
     *
     * @param node  The current node in the traversal.
     * @param value The key value to search for.
     * @return The node with the specified key value, or null if not found.
     */
    Node<T> findNode(Node<T> node, T value) {
        if (node == null || node.key.equals(value)) {
            return node;
        }

        Node<T> leftResult = findNode(node.left, value);
        if (leftResult != null) {
            return leftResult;
        }

        return findNode(node.right, value);
    }

    /**
     * Main method to run the binary tree program with a menu-based interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree<String> tree = null;

        int choice;
        do {
            try {
                System.out.println("Menu:");
                System.out.println("1. Set the root");
                System.out.println("2. Add left child");
                System.out.println("3. Add right child");
                System.out.println("4. Print tree");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the value for the root node:");
                        String rootValue = scanner.next();
                        tree = new BinaryTree<>(rootValue);
                        break;

                    case 2:
                        if (tree == null) {
                            System.out.println("Set the root first.");
                            break;
                        }
                        try {
                            System.out.println("Enter the value for the parent node:");
                            String parentValue = scanner.next();
                            System.out.println("Enter the value for the left child:");
                            String leftChildValue = scanner.next();
                            tree.addLeftChild(parentValue, leftChildValue);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid value.");
                            scanner.nextLine();
                        }
                        break;

                    case 3:
                        if (tree == null) {
                            System.out.println("Set the root first.");
                            break;
                        }
                        try {
                            System.out.println("Enter the value for the parent node:");
                            String parentValue = scanner.next();
                            System.out.println("Enter the value for the right child:");
                            String rightChildValue = scanner.next();
                            tree.addRightChild(parentValue, rightChildValue);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid value.");
                            scanner.nextLine();
                        }
                        break;

                    case 4:
                        if (tree == null) {
                            System.out.println("Tree is empty.");
                        } else {
                            tree.printTree();
                        }
                        break;

                    case 0:
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);

        scanner.close();
    }
}