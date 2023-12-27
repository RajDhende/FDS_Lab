package Assignments.Assignment6;

import java.util.*;

/**
 * Represents a generic tree data structure.
 *
 * @param <T> the type of data stored in the tree nodes.
 */
class Tree<T> {

private TreeNode<T> root;

/**
 * Constructs a tree with the specified root data.
 *
 * @param rootData the data for the root of the tree.
 */
public Tree(T rootData) {
    this.root = new TreeNode<>(rootData);
}

/**
 * Gets the root node of the tree.
 *
 * @return the root node.
 */
public TreeNode<T> getRoot() {
    return root;
}

/**
 * Adds a child node with the specified data to the given parent node.
 *
 * @param parent    the parent node.
 * @param childData the data for the new child node.
 */
public void addChild(TreeNode<T> parent, T childData) {
    TreeNode<T> child = new TreeNode<>(childData);
    parent.children.add(child);
}

/**
 * Retrieves the siblings of a given node.
 *
 * @param node the node to find siblings for.
 * @return the list of siblings or null if the node is the root.
 */
public List<TreeNode<T>> getSiblings(TreeNode<T> node) {
    if (node == root) {
        return null;
    }

    TreeNode<T> parent = findParent(root, node);
    if (parent != null) {
        return parent.children;
    }

    return null;
}

/**
 * Retrieves the leaves of a given node.
 *
 * @param node the node to find leaves for.
 * @return the list of leaves.
 */
public List<TreeNode<T>> getLeaves(TreeNode<T> node) {
    List<TreeNode<T>> leaves = new ArrayList<>();
    findLeaves(node, leaves);
    return leaves;
}

/**
 * Retrieves the internal nodes of a given node.
 *
 * @param node the node to find internal nodes for.
 * @return the list of internal nodes.
 */
public List<TreeNode<T>> getInternalNodes(TreeNode<T> node) {
    List<TreeNode<T>> internalNodes = new ArrayList<>();
    findInternalNodes(node, internalNodes);
    return internalNodes;
}

/**
 * Retrieves the path from the root to a given node.
 *
 * @param node the target node.
 * @return the list representing the path.
 */
public List<TreeNode<T>> getPath(TreeNode<T> node) {
    List<TreeNode<T>> path = new ArrayList<>();
    findPath(root, node, path);
    return path;
}

/**
 * Retrieves the depth of a given node in the tree.
 *
 * @param node the target node.
 * @return the depth of the node.
 */
public int getDepth(TreeNode<T> node) {
    return findDepth(root, node, 0);
}

/**
 * Retrieves the height of the tree.
 *
 * @return the height of the tree.
 */
public int getHeight() {
    return findHeight(root);
}

/**
 * Retrieves a subtree rooted at the given node.
 *
 * @param node the root of the subtree.
 * @return the subtree.
 */
public Tree<T> getSubtree(TreeNode<T> node) {
    TreeNode<T> subtreeRoot = findNode(root, node);
    if (subtreeRoot != null) {
        Tree<T> subtree = new Tree<>(subtreeRoot.data);
        copySubtree(subtreeRoot, subtree.getRoot());
        return subtree;
    }
    return null;
}

/**
 * This method finds a node in a tree.
 *
 * @param current The current node.
 * @param target The target node to find.
 * @return The found node or null if not found.
 */
private TreeNode<T> findNode(TreeNode<T> current, TreeNode<T> target) {
    if (current == target) {
        return current;
    }
    for (TreeNode<T> child : current.children) {
        TreeNode<T> found = findNode(child, target);
        if (found != null) {
            return found;
        }
    }
    return null;
}

/**
 * This method finds the parent of a node in a tree.
 *
 * @param current The current node.
 * @param target The target node whose parent is to be found.
 * @return The parent node or null if not found.
 */
private TreeNode<T> findParent(TreeNode<T> current, TreeNode<T> target) {
    for (TreeNode<T> child : current.children) {
        if (child == target) {
            return current;
        }
        TreeNode<T> parent = findParent(child, target);
        if (parent != null) {
            return parent;
        }
    }
    return null;
}

/**
 * This method finds all leaf nodes in a tree.
 *
 * @param current The current node.
 * @param leaves The list to store the leaf nodes.
 */
private void findLeaves(TreeNode<T> current, List<TreeNode<T>> leaves) {
    if (current.children.isEmpty()) {
        leaves.add(current);
    } else {
        for (TreeNode<T> child : current.children) {
            findLeaves(child, leaves);
        }
    }
}

/**
 * This method finds all internal nodes in a tree.
 *
 * @param current The current node.
 * @param internalNodes The list to store the internal nodes.
 */
private void findInternalNodes(TreeNode<T> current, List<TreeNode<T>> internalNodes) {
    if (!current.children.isEmpty()) {
        internalNodes.add(current);
        for (TreeNode<T> child : current.children) {
            findInternalNodes(child, internalNodes);
        }
    }
}

    /**
 * This method finds the path from the current node to the target node.
 *
 * @param current The current node.
 * @param target The target node.
 * @param path The list to store the path.
 */
private void findPath(TreeNode<T> current, TreeNode<T> target, List<TreeNode<T>> path) {
    if (current == target) {
        path.add(current);
        return;
    }

    for (TreeNode<T> child : current.children) {
        if (findNode(child, target) != null) {
            path.add(current);
            findPath(child, target, path);
        }
    }
}

/**
 * This method finds the depth of a node in a tree.
 *
 * @param current The current node.
 * @param target The target node whose depth is to be found.
 * @param depth The current depth.
 * @return The depth of the target node or -1 if not found.
 */
private int findDepth(TreeNode<T> current, TreeNode<T> target, int depth) {
    if (current == target) {
        return depth;
    }
    for (TreeNode<T> child : current.children) {
        int result = findDepth(child, target, depth + 1);
        if (result >= 0) {
            return result;
        }
    }
    return -1;
}

/**
 * This method finds the height of a tree.
 *
 * @param current The current node.
 * @return The height of the tree.
 */
private int findHeight(TreeNode<T> current) {
    if (current.children.isEmpty()) {
        return 0;
    } else {
        int maxHeight = 0;
        for (TreeNode<T> child : current.children) {
            int childHeight = findHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }
        return maxHeight + 1;
    }
}

/**
 * This method copies a subtree.
 *
 * @param current The current node.
 * @param copy The node to store the copy of the subtree.
 */
private void copySubtree(TreeNode<T> current, TreeNode<T> copy) {
    for (TreeNode<T> child : current.children) {
        TreeNode<T> childCopy = new TreeNode<>(child.data);
        copy.children.add(childCopy);
        copySubtree(child, childCopy);
    }
}
}