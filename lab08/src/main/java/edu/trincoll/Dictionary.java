package edu.trincoll;
/**
 * Dictionary abstract class
 * @param <Key> The key type
 * @param <E> The element type
 */
public abstract class Dictionary<Key extends Comparable<Key>, E> {
    /**
     * Reinitialize dictionary
     */
    public abstract void clear();
    
    /**
     * Insert a record
     * @param k The key for the record being inserted
     * @param e The record being inserted
     */
    public abstract void insert(Key k, E e);
    
    /**
     * Remove and return a record
     * @param k The key of the record to be removed
     * @return The record that is removed, or null if none exists
     */
    public abstract E remove(Key k);
    
    /**
     * Remove and return an arbitrary record from dictionary
     * @return The record removed, or null if none exists
     */
    public abstract E removeAny();
    
    /**
     * Find a record using the key
     * @param k The key of the record to find
     * @return The record matching key k, or null if none exists
     */
    public abstract E find(Key k);
    
    /**
     * @return The number of records in the dictionary
     */
    public abstract int size();
    
    /**
     * @return The minimum key value in the BST
     */
    public abstract Key getMin();
    
    /**
     * @return The maximum key value in the BST
     */
    public abstract Key getMax();
    
    /**
     * Display the entire BST using inorder traversal
     */
    public abstract void display_inorder();
    
    /**
     * Display the entire BST using preorder traversal
     */
    public abstract void display_preorder();
    
    /**
     * Display the entire BST using postorder traversal
     */
    public abstract void display_postorder();
    
    /**
     * Check if the dictionary contains a value
     * @param e The value to search for
     * @return True if the value is found, false otherwise
     */
    public abstract boolean containsValue(E e);
    
    /**
     * Find the successor of a key in the BST
     * @param k The key to find the successor for
     * @return The successor key, or null if none exists
     */
    public abstract Key successor(Key k);
    
    /**
     * Find the predecessor of a key in the BST
     * @param k The key to find the predecessor for
     * @return The predecessor key, or null if none exists
     */
    public abstract Key predecessor(Key k);
    
    /**
     * @return The height of the BST
     */
    public abstract int height();
    
    /**
     * @return True if the dictionary is empty, false otherwise
     */
    public abstract boolean isEmpty();
}
