/*
IBL13 CSE017 Fall 2019
@author Arielle Carr modified by Dennis Kuzminer
 */

public class BinarySearchTree extends BinaryTree {
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected Integer deleteReturn;

    public BinarySearchTree(Node root){
        super(root);
    }

    /** Starter method add.
     @param item The Integer being inserted
     @return true if the Integer is inserted, false
     if the Integer already exists in the tree
     */
    public boolean add(Integer item) {
        root = add(root, item);
        return addReturn;
    }
    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree. @param localRoot The local root of the subtree
     @param item The Integer to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node add(Node localRoot, Integer item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node(item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item); return localRoot;
        }
        else {

            localRoot.right = add(localRoot.right, item); return localRoot;
        }
    }
    /** Starter method find.
     @param target The Integer being sought @return The Integer, if found, otherwise null
     */
    public Integer find(Integer target) {
        return find(root, target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root @param target The Integer being sought @return The Integer, if found, otherwise null
     */
    private Integer find(Node localRoot, Integer target) {
        if (localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }
    /** Starter method delete.
     post: The Integer is not in the tree. @param target The Integer to be deleted @return The Integer deleted from the tree
     or null if the Integer was not in the tree
     */
    public Integer delete(Integer target) {
        root = delete(root, target);
        return deleteReturn;
    }
    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node delete(Node localRoot, Integer item) {
        if (localRoot == null) {
// item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }
// Search for item to delete.
        int compResult = item.compareTo(localRoot.data); if (compResult < 0) {
// item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if (compResult > 0) {
// item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else {
// item is at local root. deleteReturn = localRoot.data;
            if (localRoot.left == null) {
// If there is no left child, return right child // which can also be null.
                return localRoot.right;
            }
            else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            }
            else {
// Node being deleted has 2 children, replace the data // with inorder predecessor.
                if (localRoot.left.right == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                    // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                else {
// Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip) @return The data in the ip
     */
    private Integer findLargestChild(Node parent) {
// If the right child has no right child, it is // the inorder predecessor.
        if (parent.right.right == null) {
            Integer returnValue = parent.right.data; parent.right = parent.right.left; return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    public boolean contains(Integer elem){
        return elem.equals(find(elem));
    }



}
