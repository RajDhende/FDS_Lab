package Assignments.Assignment7;

class TreeNode {
    String value;
    TreeNode left, right;

    public TreeNode(String value) {
        this.value = value;
        this.left = this.right = null;
    }
}

class ExpressionTree {
    static TreeNode createExpressionTree() {
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

    public static void main(String[] args) {
        TreeNode root = createExpressionTree();

        System.out.print("Expression: ");
        displayExpression(root);
    }
}
