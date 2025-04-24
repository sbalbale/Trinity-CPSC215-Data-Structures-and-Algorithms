package edu.trincoll;

/**
 * AugmentedBST is a generic Binary Search Tree (BST) that has been augmented
 * to support order-statistic operations. Each node is augmented with a 'size'
 * field,
 * which represents the number of nodes in the subtree rooted at that node.
 *
 * Students are required to complete the BST operations, order-statistic
 * methods,
 * and the in-order printing method as specified in the comments.
 *
 * @param <T> the type of elements maintained by this BST, must implement
 *            Comparable<T>
 */
public class AugmentedBST<T extends Comparable<T>> {

    /**
     * The Node class represents a node in the BST.
     * Each node stores the key, its left and right children, and the size of the
     * subtree.
     */
    private class Node {
        T key;
        Node left, right;
        int size; // The size of the subtree rooted at this node

        public Node(T key) {
            this.key = key;
            left = right = null;
            size = 1;
        }
    }

    private Node root;

    // Constructor: Initialize an empty BST.
    public AugmentedBST() {
        root = null;
    }

    /**
     * Returns the number of nodes in the entire BST.
     */
    public int size() {
        return size(root);
    }

    // Helper method: return the size of the given node (0 if null).
    private int size(Node node) {
        return node == null ? 0 : node.size;
    }

    /**
     * Inserts a key into the BST.
     * In addition to the standard BST insertion,
     * the size field for each node along the insertion path must be updated.
     *
     * @param key the key to insert into the BST.
     */
    public void insert(T key) {
        root = insert(root, key);
    }

    // Recursive insertion helper method.
    /**
     * Inserts a key into the BST rooted at the given node.
     * This method assumes that the BST property is maintained.
     * It also updates the size of the subtree rooted at the node.
     * 
     * @param node
     * @param key
     * @return
     */
    private Node insert(Node node, T key) {
        // Base case: if we reach a null node, create and return a new node with the key
        if (node == null)
            return new Node(key);

        // Compare the key to be inserted with the current node's key
        int cmp = key.compareTo(node.key);

        // If key is smaller, recursively insert into the left subtree
        if (cmp < 0) {
            node.left = insert(node.left, key);
        }
        // If key is larger, recursively insert into the right subtree
        else if (cmp > 0) {
            node.right = insert(node.right, key);
        }

        // Update the size of the subtree rooted at this node
        node.size = 1 + size(node.left) + size(node.right);

        // Return the updated node to maintain tree structure
        return node;
    }

    /**
     * Searches for a key in the BST.
     *
     * @param key the key to search for.
     * @return true if the key exists; false otherwise.
     */
    public boolean search(T key) {
        return search(root, key);
    }

    // Recursive search helper method.
    private boolean search(Node node, T key) {
        if (node == null)
            return false;
        int cmp = key.compareTo(node.key);
        if (cmp == 0)
            return true;
        else if (cmp < 0)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    public void delete(T key) {
        root = delete(root, key);
    }

    // Recursive deletion helper method.
    private Node delete(Node node, T key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            // Node with only one child or no child.
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            // Node with two children: replace node with its successor.
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    // Helper method: returns the minimum node from a subtree.
    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    // Helper method: Deletes the minimum node in the subtree.
    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * Returns the kth smallest element in the BST (1-indexed).
     *
     * @param k the order of the smallest element to retrieve.
     * @return the kth smallest key.
     * @throws IllegalArgumentException if k is out of bounds.
     */
    public T kthSmallest(int k) {
        if (k < 1 || k > size()) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        return kthSmallest(root, k);
    }

    /**
     * Finds the k-th smallest key in the subtree rooted at the given node.
     * This method assumes that the size of each node (number of nodes in its
     * subtree) is correctly maintained.
     *
     * @param node The root of the subtree to search within.
     * @param k    The rank (1-based index) of the desired element (e.g., k=1 for
     *             the smallest).
     * @return The key of the k-th smallest element in the subtree rooted at node
     *         or null if the node is null or k is out of bounds for the
     *         subtree size.
     */
    private T kthSmallest(Node node, int k) {
        // Base case: If the current node is null, the element cannot be found in this
        // subtree.
        if (node == null)
            return null;
        // Get the size of the left subtree.
        int leftSize = size(node.left);
        // If k is less than or equal to the size of the left subtree
        // the kth smallest element must be in the left subtree.
        if (k <= leftSize) {
            return kthSmallest(node.left, k);
            // If k is exactly one greater than the size of the left subtree
            // the current node is the kth smallest element.
        } else if (k == leftSize + 1) {
            return node.key;
            // If k is greater than the size of the left subtree plus 
            // one the kth smallest element must be in the right subtree.
            // Adjust k by subtracting the size of the left subtree and the current node.
        } else {
            return kthSmallest(node.right, k - leftSize - 1);
        }
    }

    /**
     * Returns the rank of the given key in the BST.
     * Rank is defined as the number of nodes with keys less than the given key.
     *
     * @param key the key for which to compute the rank.
     * @return the rank of the key.
     */
    public int rank(T key) {
        // Check if the key is present in the BST
        if (!search(key)) {
            // If the key is not found, return the size of the BST
            // (indicating that the key is greater than all existing keys)
            return size();
        }
        return rank(root, key);
    }

    // Recursive rank helper method.

    /**
     * Computes the rank of a key in the BST rooted at the given node.
     * The rank is defined as the number of nodes with keys less than the given key.
     *
     * @param node The root of the subtree to search within.
     * @param key  The key for which to compute the rank.
     * @return The rank of the key in the subtree rooted at {node}.
     */
    private int rank(Node node, T key) {
        // Base case: If the current node is null, the rank is 0.
        if (node == null)
            return 0;
        // Compare the key with the current node's key.
        // If the key is less than the current node's key, search in the left subtree.
        // If the key is greater than the current node's key, search in the right
        // subtree.
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            // Count the size of the left subtree and add 1 for the current node
            return size(node.left) + 1 + rank(node.right, key);
        } else {
            // Key found, return the size of the left subtree
            return size(node.left);
        }
    }

    /**
     * Prints the BST's keys in in-order (sorted order) along with their subtree
     * sizes.
     */
    public void printInOrder() {
        // key(size) for each node.
        printInOrder(root);
    }

    // Recursive in-order print helper method.
    /**
     * Performs an in-order traversal of the BST rooted at the given node.
     * It prints the key and size of each node in sorted order.
     *
     * @param node The root of the subtree to traverse.
     */
    private void printInOrder(Node node) {
        if (node == null)
            return;
        // Traverse the left subtree
        printInOrder(node.left);
        // Print the current node's key and size
        System.out.print(node.key + "(" + node.size + ") ");
        // Traverse the right subtree
        printInOrder(node.right);
    }

    // You may implement additional helper methods.

}
