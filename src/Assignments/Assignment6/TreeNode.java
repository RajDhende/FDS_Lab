package Assignments.Assignment6;

import java.util.*;
/**
 * Represents a tree node with generic data.
 *
 * @param <T> the type of data stored in the node.
 */
public class TreeNode<T> {
T data;
List<TreeNode<T>> children;

/**
 * Constructs a tree node with the given data.
 *
 * @param data the data to be stored in the node.
 */
public TreeNode(T data) {
    this.data = data;
    this.children = new ArrayList<>();
}
}