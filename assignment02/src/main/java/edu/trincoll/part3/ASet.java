package edu.trincoll.part3;

/**
 * An array-based implementation of a Set ADT.
 * A set is an unordered collection of unique elements.
 *
 * @param <E> the type of elements in this set
 */
class ASet<E> implements Set<E> {
    private static final int defaultSize = 10;
    private int maxSize; // max size of the array
    private int setSize; // current size of the array
    private E[] setArray; // The set array

    /**
     * Constructs an empty set with default capacity of 10 elements.
     */
    @SuppressWarnings("unchecked")
    public ASet() {
        maxSize = defaultSize;
        setSize = 0;
        setArray = (E[]) new Object[maxSize];
    }

    /**
     * Constructs an empty set with specified initial capacity.
     *
     * @param size the initial capacity of the set
     */
    @SuppressWarnings("unchecked")
    public ASet(int size) {
        maxSize = size;
        setSize = 0;
        setArray = (E[]) new Object[maxSize];
    }

    /**
     * Checks if an item exists in the set.
     *
     * @param item the item to check for
     * @return true if the item is in the set, false otherwise
     */
    @Override
    public boolean contains(E item) {
        for (int i = 0; i < setSize; i++) {
            if (setArray[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the set is empty.
     *
     * @return true if the set contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return setSize == 0;
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the number of elements in the set
     */
    @Override
    public int size() {
        return setSize;
    }

    /**
     * Adds an item to the set if it's not already present and there's space.
     *
     * @param item the item to be added to the set
     */
    @Override
    public void insert(E item) {
        if (!contains(item) && setSize < maxSize) {
            setArray[setSize++] = item;
        }
    }

    /**
     * Returns the item at the specified position in the set.
     *
     * @param i the index of the element to return
     * @return the element at the specified position, or null if index is invalid
     */
    @Override
    public E getValue(int i) {
        if (i >= 0 && i < setSize) {
            return setArray[i];
        }
        return null;
    }

    /**
     * Returns a new set that is the union of this set and the specified set.
     * The union contains all elements that are in either set.
     *
     * @param S the set to form a union with
     * @return a new set containing all elements from both sets
     */
    @Override
    public Set<E> union(Set<E> S) {
        Set<E> result = new ASet<>(maxSize + S.size());
        // Add all elements from this set
        for (int i = 0; i < setSize; i++) {
            result.insert(setArray[i]);
        }
        // Add all elements from S
        for (int i = 0; i < S.size(); i++) {
            result.insert(S.getValue(i));
        }
        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and the specified set.
     * The intersection contains only elements that are in both sets.
     *
     * @param S the set to intersect with
     * @return a new set containing elements common to both sets
     */
    @Override
    public Set<E> intersect(Set<E> S) {
        Set<E> result = new ASet<>(Math.min(maxSize, S.size()));
        for (int i = 0; i < setSize; i++) {
            if (S.contains(setArray[i])) {
                result.insert(setArray[i]);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the difference of this set and the specified set.
     * The difference contains elements that are in this set but not in the specified set.
     *
     * @param S the set to find the difference with
     * @return a new set containing elements in this set but not in S
     */
    @Override
    public Set<E> diff(Set<E> S) {
        Set<E> result = new ASet<>(maxSize);
        for (int i = 0; i < setSize; i++) {
            if (!S.contains(setArray[i])) {
                result.insert(setArray[i]);
            }
        }
        return result;
    }

    /**
     * Returns a new set that is the symmetric difference of this set and the specified set.
     * The symmetric difference contains elements that are in either set, but not in both.
     *
     * @param S the set to find the symmetric difference with
     * @return a new set containing elements in either set but not in both
     */
    @Override
    public Set<E> symDiff(Set<E> S) {
        Set<E> union = this.union(S);
        Set<E> intersection = this.intersect(S);
        return union.diff(intersection);
    }

    /**
     * Returns a string representation of the set.
     * Format: "< element1|  element2|  element3|  >"
     *
     * @return a string representation of the set
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder((setSize + 1) * 4);
        out.append("< ");
        for (int i = 0; i < setSize; i++) {
            out.append(setArray[i]);
            out.append("|  ");
        }
        out.append(">");
        return out.toString();
    }
}