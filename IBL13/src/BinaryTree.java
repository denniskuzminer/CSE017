/*
IBL13 CSE017 Fall 2019
@author Arielle Carr modified by Dennis Kuzminer
 */

import java.io.*;

public class BinaryTree {
    /** The root of the binary tree */
    protected Node root;

    protected BinaryTree(Node root) {
        this.root = root;
    }
    /** Constructs a new binary tree with data in its root leftTree as its left subtree and rightTree as its right subtree.
     */
    public BinaryTree(Integer data, BinaryTree leftTree,
                      BinaryTree rightTree) {
        root = new Node(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }
    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree(root.left);
        } else {
            return null;
        }
    }
    /** Determine whether this tree is a leaf. @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

}
