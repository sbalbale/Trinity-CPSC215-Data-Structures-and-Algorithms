package edu.trincoll;
/**
 * Binary tree node ADT interface
 * @param <Key> The key type
 * @param <E> The element type
 */
public interface BinNode<Key, E> {
    /**
     * Get and set the element value
     */
    public E element();
    public void setElement(E v);
    
    /**
     * Get and set the key value
     */
    public Key key();
    public void setKey(Key k);
    
    /**
     * Get and set the left child
     */
    public BinNode<Key, E> left();
    public void setLeft(BinNode<Key, E> n);
    
    /**
     * Get and set the right child
     */
    public BinNode<Key, E> right();
    public void setRight(BinNode<Key, E> n);
    
    /**
     * @return True if this is a leaf node
     */
    public boolean isLeaf();
}
