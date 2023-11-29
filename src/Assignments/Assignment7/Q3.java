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
class ExpressionTree {

    /**
     * Creates an example expression tree.
     *
     * @return The root node of the expression tree.
     */
    static TreeNode createExpressionTree() {
        // Constructing the expression tree with sample values
        TreeNode root = new TreeNode("-");
        root.left = new TreeNode("/");
        root.right = new TreeNode("+");
        root.left.left = new TreeNode("*");
        root.left.right = new TreeNode("+");

        root.left.left.left = new TreeNode("3");
        root.left.left.right = new TreeNode("1");

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
     * Displays the expression represented by the given expression tree.
     *
     * @param node The root node of the expression tree.
     */
    static void displayExpression(TreeNode node) {
        if (node != null) {
            if (node.left != null || node.right != null) {
                System.out.print("(");
            }

            displayExpression(node.left);
            System.out.print(node.value);
            displayExpression(node.right);

            if (node.left != null || node.right != null) {
                System.out.print(")");
            }
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

        // Display the expression
        System.out.print("Expression: ");
        displayExpression(root);
    }
}
