package Assignments.Assignment7;

/**
 * Represents a node in an expression tree.
 */
class TreeNode {
    String value; // The value of the node (operator or operand)
    TreeNode left, right; // References to the left and right child nodes

    /**
     * Constructs a TreeNode with the given value.
     *
     * @param value The value of the node.
     */
    public TreeNode(String value) {
        this.value = value;
        this.left = this.right = null;
    }
}

/**
 * Represents an expression tree and provides methods to create and display it.
 */
class Q4 {

    /**
     * Creates an expression tree that matches the provided infix expression.
     *
     * @return The root node of the expression tree.
     */
    static TreeNode createExpressionTree() {
        // Constructing the expression tree to match the provided infix expression
        TreeNode root = new TreeNode("-");
        root.left = new TreeNode("/");
        root.right = new TreeNode("+");
        root.left.left = new TreeNode("*");
        root.left.right = new TreeNode("+");

        root.left.left.left = new TreeNode("+");
        root.left.left.right = new TreeNode("3");

        root.left.left.left.left = new TreeNode("3");
        root.left.left.left.right = new TreeNode("1");

        root.left.right.left = new TreeNode("-");
        root.left.right.right = new TreeNode("2");

        root.left.right.left.left = new TreeNode("9");
        root.left.right.left.right = new TreeNode("5");

        root.right.left = new TreeNode("*");
        root.right.right = new TreeNode("6");

        root.right.left.left = new TreeNode("3");
        root.right.left.right = new TreeNode("-");
        root.right.left.right.left = new TreeNode("7");
        root.right.left.right.right = new TreeNode("4");

        return root;
    }

    /**
     * Displays the expression represented by the given expression tree in a specific format.
     *
     * @param treeNode The root node of the expression tree.
     */
    static void displayExpressionInFormat(TreeNode treeNode) {
        if (treeNode != null) {
            if (treeNode.left != null || treeNode.right != null) {
                System.out.print("(");
            }

            displayExpressionInFormat(treeNode.left);
            System.out.print(treeNode.value);
            displayExpressionInFormat(treeNode.right);

            if (treeNode.left != null || treeNode.right != null) {
                System.out.print(")");
            }
        }
    }

    /**
     * Displays the expression tree using a similar structure as the provided printTree method.
     *
     * @param treeNode   The current node in the traversal.
     * @param prefix The prefix for indentation.
     * @param isLeft True if the current node is the left child, false otherwise.
     */
    static void printExpressionTree(TreeNode treeNode, String prefix, boolean isLeft) {
        if (treeNode != null) {
            printExpressionTree(treeNode.right, prefix + (isLeft ? "│   " : "    "), false);
            System.out.println(prefix + (isLeft ? "└── " : "┌── ") + treeNode.value);
            printExpressionTree(treeNode.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    /**
     * The main method that demonstrates the creation and display of an expression tree.
     *
     * @param args The command-line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an expression tree
        TreeNode root = createExpressionTree();

        // Display the expression in the desired format
        System.out.print("The Expression is: ");
        displayExpressionInFormat(root);

        // Display the expression tree structure
        System.out.println("\nExpression Tree Structure:");
        printExpressionTree(root, "", true);
    }
}

