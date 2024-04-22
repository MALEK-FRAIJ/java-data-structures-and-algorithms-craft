package com.DataStructure;

/**
 * iCollectionDynamic
 */
public interface CollectionDynamic {
    // Query Operations
    /**
     * Appends the specified element to the end of this Array
     * 
     * @param element to be appended to this Array
     * @return {@code true} (if add element on the top)
     * @since 1.0
     */
    public boolean add(int element);

    /**
     * Inserts the specified element at the specified position in this array.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * 
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *                                        ({@code index < 0 || index > size})
     * @return {@code true} If a new item is added in the ArrayList at any Location
     * @since 1.0
     */
    public boolean add(int index, int element);

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty();

    /**
     * Tests if this ArrayList is Full.
     * 
     * @return {@code true} if {@code (size == capacity)}; {@code false} otherwise.
     */
    public boolean isFull();

    /**
     * Returns the number of elements in this list. If this list contains
     * more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Removes the element at the specified position in this ArrayList.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     * 
     * @param index index at which the specified element is to be removed
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *                                        ({@code index < 0 || index >= size})
     * 
     * @return Returns the element that was removed from the ArrayList
     * @since 1.0
     */
    public int remove(int index);

    /**
     * Return the element which indexed
     * 
     * @param index index at which the specified element is to be returned
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *                                        ({@code index <= 0 || index > size})
     * @return Returns the element that was indexed from the ArrayList
     * 
     */
    public int get(int index);

    /**
     * Replaces the element at the specified position in this ArrayList with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     *
     */
    public int set(int index, int element);

}
