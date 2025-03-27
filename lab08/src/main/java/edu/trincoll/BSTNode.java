package edu.trincoll;
/**
 * Binary Search Tree node implementation
 * @param <Key> The key type
 * @param <E> The element type
 */
public class BSTNode<Key, E> implements BinNode<Key, E> {
    private Key key;            // Key for this node
    private E element;          // Element for this node
    private BSTNode<Key, E> left;   // Pointer to left child
    private BSTNode<Key, E> right;  // Pointer to right child
    
    /**
     * Constructor
     * @param k The key
     * @param val The element
     */
    public BSTNode(Key k, E val) {
        key = k;
        element = val;
        left = right = null;
    }
    
    /**
     * Constructor
     * @param k The key
     * @param val The element
     * @param l Left child
     * @param r Right child
     */
    public BSTNode(Key k, E val, BSTNode<Key, E> l, BSTNode<Key, E> r) {
        key = k;
        element = val;
        left = l;
        right = r;
    }
    
    // Implementations for BinNode interface
    public Key key() { return key; }
    public void setKey(Key k) { key = k; }
    
    public E element() { return element; }
    public void setElement(E v) { element = v; }
    
    public BSTNode<Key, E> left() { return left; }
    public void setLeft(BinNode<Key, E> n) { left = (BSTNode<Key, E>)n; }
    
    public BSTNode<Key, E> right() { return right; }
    public void setRight(BinNode<Key, E> n) { right = (BSTNode<Key, E>)n; }
    
    public boolean isLeaf() { return (left == null) && (right == null); }
}
