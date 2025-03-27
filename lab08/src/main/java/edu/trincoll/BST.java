package edu.trincoll;

/**
 * Binary Search Tree implementation that extends the Dictionary abstract class.
 * Provides methods for inserting, removing, and finding elements based on keys,
 * as well as various tree traversal and tree property methods.
 *
 * @param <Key> The type of keys, must implement Comparable
 * @param <E> The type of elements/values stored in the tree
 */
public class BST<Key extends Comparable<Key>, E> extends Dictionary<Key, E> {
    private BSTNode<Key, E> root;  // Root of the BST
    private int nodecount;         // Number of nodes in the BST

    /**
     * Constructor - creates an empty BST.
     */
    public BST() {
        root = null;
        nodecount = 0;
    }

    /**
     * Insert a record into the BST.
     * 
     * @param k The key for the record being inserted
     * @param e The element/value being inserted
     */
    @Override
    public void insert(Key k, E e) {
        root = inserthelp(root, k, e);
        nodecount++;
    }

    /**
     * Helper method to recursively insert a new node with key k and value e.
     * 
     * @param rt The root of the current subtree
     * @param k The key to insert
     * @param e The element/value to insert
     * @return The root of the modified subtree
     */
    private BSTNode<Key, E> inserthelp(BSTNode<Key, E> rt, Key k, E e) {
        if (rt == null)
            return new BSTNode<>(k, e);
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(inserthelp(rt.left(), k, e));
        else
            rt.setRight(inserthelp(rt.right(), k, e));
        return rt;
    }

    /**
     * Returns the minimum key value in the BST.
     *
     * @return The minimum key in the BST, or null if the tree is empty
     */
    @Override
    public Key getMin() {
        if (root == null)
            return null;
        BSTNode<Key, E> temp = getmin(root);
        return temp.key();
    }

    /**
     * Helper method to find the node with the minimum key in a subtree.
     *
     * @param rt The root of the current subtree
     * @return The node with the minimum key
     */
    private BSTNode<Key, E> getmin(BSTNode<Key, E> rt) {
        if (rt.left() == null)
            return rt;
        return getmin(rt.left());
    }

    /**
     * Find a record using the key.
     * 
     * @param k The key of the record to find
     * @return The record matching key k, or null if none exists
     */
    @Override
    public E find(Key k) {
        return findhelp(root, k);
    }

    /**
     * Helper method to recursively find a record in the BST.
     *
     * @param rt The root of the current subtree
     * @param k The key to search for
     * @return The element with key k, or null if not found
     */
    private E findhelp(BSTNode<Key, E> rt, Key k) {
        if (rt == null)
            return null;
        if (rt.key().compareTo(k) > 0)
            return findhelp(rt.left(), k);
        else if (rt.key().compareTo(k) == 0)
            return rt.element();
        else
            return findhelp(rt.right(), k);
    }

    /**
     * Remove and return a record with the given key.
     *
     * @param k The key of the record to be removed
     * @return The record matching key k that was removed, or null if none exists
     */
    @Override
    public E remove(Key k) {
        E temp = findhelp(root, k);
        if (temp != null) {
            root = removehelp(root, k);
            nodecount--;
        }
        return temp;
    }

    /**
     * Helper method to recursively remove a node with key k from the BST.
     *
     * @param rt The root of the current subtree
     * @param k The key to be removed
     * @return The root of the modified subtree
     */
    private BSTNode<Key, E> removehelp(BSTNode<Key, E> rt, Key k) {
        if (rt == null)
            return null;
        if (rt.key().compareTo(k) > 0)
            rt.setLeft(removehelp(rt.left(), k));
        else if (rt.key().compareTo(k) < 0)
            rt.setRight(removehelp(rt.right(), k));
        else {
            if (rt.left() == null)
                return rt.right();
            else if (rt.right() == null)
                return rt.left();
            else {
                BSTNode<Key, E> temp = getmin(rt.right());
                rt.setElement(temp.element());
                rt.setRight(deletemin(rt.right()));
            }
        }
        return rt;
    }

    /**
     * Helper method to find and delete the node with the minimum key in a subtree.
     *
     * @param rt The root of the current subtree
     * @return The root of the modified subtree
     */
    private BSTNode<Key, E> deletemin(BSTNode<Key, E> rt) {
        if (rt.left() == null)
            return rt.right();
        rt.setLeft(deletemin(rt.left()));
        return rt;
    }

    /**
     * Reinitialize the BST by removing all nodes.
     */
    @Override
    public void clear() {
        while (root != null) {
            remove(root.key());
        }
    }

    /**
     * Remove and return an arbitrary record from the BST.
     * In this implementation, removes the root node.
     *
     * @return The record removed, or null if none exists
     */
    @Override
    public E removeAny() {
        if (root == null)
            return null;
        BSTNode<Key, E> temp = root;
        root = removehelp(root, root.key());
        nodecount--;
        return temp.element();
    }

    /**
     * Returns the number of records in the BST.
     *
     * @return The number of records
     */
    @Override
    public int size() {
        return nodecount;
    }

    /**
     * Checks if the BST is empty.
     *
     * @return True if the BST is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return nodecount == 0;
    }

    /**
     * Returns the height of the BST.
     * An empty tree has height -1, a tree with just the root has height 0.
     *
     * @return The height of the BST
     */
    @Override
    public int height() {
        if (root == null)
            return -1;
        return heightHelp(root);
    }

    /**
     * Helper method to recursively calculate the height of a subtree.
     *
     * @param rt The root of the current subtree
     * @return The height of the subtree
     */
    public int heightHelp(BSTNode<Key, E> rt) {
        if (rt == null)
            return -1;
        int left = heightHelp(rt.left());
        int right = heightHelp(rt.right());
        return 1 + Math.max(left, right);
    }

    /**
     * Returns the maximum key value in the BST.
     *
     * @return The maximum key in the BST, or null if the tree is empty
     */
    @Override
    public Key getMax() {
        if (root == null)
            return null;
        BSTNode<Key, E> temp = getmax(root);
        return temp.key();
    }

    /**
     * Helper method to find the node with the maximum key in a subtree.
     *
     * @param rt The root of the current subtree
     * @return The node with the maximum key
     */
    public BSTNode<Key, E> getmax(BSTNode<Key, E> rt) {
        if (rt.right() == null)
            return rt;
        return getmax(rt.right());
    }

    /**
     * Display the entire BST using inorder traversal.
     */
    @Override
    public void display_inorder() {
        displayInorderHelp(root);
        System.out.println();
    }

    /**
     * Helper method for inorder traversal of a subtree.
     *
     * @param rt The root of the current subtree
     */
    private void displayInorderHelp(BSTNode<Key, E> rt) {
        if (rt == null)
            return;
        displayInorderHelp(rt.left());
        System.out.print(rt.key() + ": " + rt.element() + "\n");
        displayInorderHelp(rt.right());
    }

    /**
     * Display the entire BST using preorder traversal.
     */
    @Override
    public void display_preorder() {
        displayPreorderHelp(root);
        System.out.println();
    }

    /**
     * Helper method for preorder traversal of a subtree.
     *
     * @param rt The root of the current subtree
     */
    private void displayPreorderHelp(BSTNode<Key, E> rt) {
        if (rt == null)
            return;
        System.out.print(rt.key() + ": " + rt.element() + "\n");
        displayPreorderHelp(rt.left());
        displayPreorderHelp(rt.right());
    }

    /**
     * Display the entire BST using postorder traversal.
     */
    @Override
    public void display_postorder() {
        displayPostorderHelp(root);
        System.out.println();
    }

    /**
     * Helper method for postorder traversal of a subtree.
     *
     * @param rt The root of the current subtree
     */
    private void displayPostorderHelp(BSTNode<Key, E> rt) {
        if (rt == null)
            return;
        displayPostorderHelp(rt.left());
        displayPostorderHelp(rt.right());
        System.out.print(rt.key() + ": " + rt.element() + "\n");
    }

    /**
     * Checks if the BST contains a specific value.
     *
     * @param e The value to search for
     * @return True if the value exists in the BST, false otherwise
     */
    @Override
    public boolean containsValue(E e) {
        if (root == null)
            return false;
        return containsValueHelp(root, e);
    }

    /**
     * Helper method to recursively search for a value in the BST.
     *
     * @param rt The root of the current subtree
     * @param e The element/value to search for
     * @return True if the value exists in the subtree, false otherwise
     */
    public boolean containsValueHelp(BSTNode<Key, E> rt, E e) {
        if (rt == null)
            return false;
        if (rt.element().equals(e))
            return true;
        return containsValueHelp(rt.left(), e) || containsValueHelp(rt.right(), e);
    }

    /**
     * Find the successor of a key in the BST.
     * The successor is the smallest key that is greater than k.
     *
     * @param k The key to find the successor for
     * @return The successor key, or null if none exists
     */
    @Override
    public Key successor(Key k) {
        BSTNode<Key, E> node = findNode(root, k);
        if (node == null) {
            return null; // Key not found
        }
        
        // Case 1: If right subtree exists, successor is minimum in right subtree
        if (node.right() != null) {
            return getmin(node.right()).key();
        }
        
        // Case 2: No right subtree, find the nearest ancestor whose left child 
        // is an ancestor of the node
        BSTNode<Key, E> succ = null;
        BSTNode<Key, E> current = root;
        
        while (current != null) {
            if (k.compareTo(current.key()) < 0) {
                succ = current;
                current = current.left();
            } else if (k.compareTo(current.key()) > 0) {
                current = current.right();
            } else {
                break; // Found the node
            }
        }
        
        return succ != null ? succ.key() : null;
    }

    /**
     * Find the predecessor of a key in the BST.
     * The predecessor is the largest key that is less than k.
     *
     * @param k The key to find the predecessor for
     * @return The predecessor key, or null if none exists
     */
    @Override
    public Key predecessor(Key k) {
        BSTNode<Key, E> node = findNode(root, k);
        if (node == null) {
            return null; // Key not found
        }
        
        // Case 1: If left subtree exists, predecessor is maximum in left subtree
        if (node.left() != null) {
            return getmax(node.left()).key();
        }
        
        // Case 2: No left subtree, find the nearest ancestor whose right child 
        // is an ancestor of the node
        BSTNode<Key, E> pred = null;
        BSTNode<Key, E> current = root;
        
        while (current != null) {
            if (k.compareTo(current.key()) > 0) {
                pred = current;
                current = current.right();
            } else if (k.compareTo(current.key()) < 0) {
                current = current.left();
            } else {
                break; // Found the node
            }
        }
        
        return pred != null ? pred.key() : null;
    }
    
    /**
     * Helper method to find a node with a specific key.
     *
     * @param rt The root of the current subtree
     * @param k The key to search for
     * @return The node containing key k, or null if not found
     */
    private BSTNode<Key, E> findNode(BSTNode<Key, E> rt, Key k) {
        if (rt == null)
            return null;
        if (k.compareTo(rt.key()) < 0)
            return findNode(rt.left(), k);
        else if (k.compareTo(rt.key()) > 0)
            return findNode(rt.right(), k);
        else
            return rt; // Found it
    }
}