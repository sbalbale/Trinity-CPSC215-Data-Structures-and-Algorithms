package edu.trincoll.part3;
/**
   Set ADT 
*/
public interface Set<E> {
   /** @return true if item is in this set; false otherwise. */
   public boolean contains (E item);

   /** @return true if this set is empty; false otherwise. */
   public boolean isEmpty();

   /** @return the number of elements in this set. */
   public int size();

   /** Insert an element at the current location. 
      @param item The element to be inserted. */
   public void insert(E item);

   /** @return The data element of the item at position i. */
   public E getValue(int i);

   /** Compute the union of two sets.
      @param S another set
      @return the union of this set with S.
   */
   public Set<E> union(Set<E> S);

   /** Compute the intersection of two sets.
      @param S another set
      @return the intersection of this set with S.
   */
   public Set<E> intersect(Set<E> S);

   /** Compute the difference of two sets.
      @param S another set
      @return the difference of this set with S.
   */
   public Set<E> diff(Set<E> S);

   /** Compute the symmetric difference of two sets.
      @param S another set
      @return the symmetric difference of this set with S.
   */
   public Set<E> symDiff(Set<E> S);
}