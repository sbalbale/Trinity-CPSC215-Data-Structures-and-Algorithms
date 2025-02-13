package edu.trincoll;
/**
 * List Abstract Data Type (ADT)
 *
 * Source: "A Practical Introduction to Data Structures
 * and Algorithm Analysis, 3rd Edition" by Clifford Shaffer
 *
 * @param <E> The type of elements in this list.
 */
public interface List<E> {
    /**
     * Removes all contents from the list, making it empty.
     * The client is responsible for reclaiming storage used by the elements.
     */
    void clear();

    /**
     * Inserts an element at the current location.
     * The client must ensure that the list's capacity is not exceeded.
     *
     * @param item The element to be inserted.
     */
    void insert(E item);

    /**
     * Appends an element at the end of the list.
     * The client must ensure that the list's capacity is not exceeded.
     *
     * @param item The element to be appended.
     */
    void append(E item);

    /**
     * Removes and returns the current element.
     *
     * @return The element that was removed.
     */
    E remove();

    /** Sets the current position to the start of the list. */
    void moveToStart();

    /** Sets the current position to the end of the list. */
    void moveToEnd();

    /** Moves the current position one step left. No change if already at the beginning. */
    void prev();

    /** Moves the current position one step right. No change if already at the end. */
    void next();

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements.
     */
    int length();

    /**
     * Returns the position of the current element.
     *
     * @return The position of the current element.
     */
    int currPos();

    /**
     * Sets the current position.
     *
     * @param pos The position to set as current.
     */
    void moveToPos(int pos);

    /**
     * Returns the current element.
     *
     * @return The current element.
     */
    E getValue();
}
