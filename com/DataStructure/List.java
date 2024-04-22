package com.DataStructure;

/**
 * List
 */
public interface List extends CollectionDynamic {
    // Query Operations

    /**
     * To Find any element in ArrayList
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     * 
     */
    public int linearSearch(int target);

    /**
     * To swap two element of array List
     * 
     * @param index1 The first index of item to be replaced
     * @param index2 The second index of item to be replaced
     * 
     */
    public void swap(int index1, int index2);

    /**
     * To Find any element in ArrayList
     * using iteration loop
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     *
     */
    public int binarySearch(int target);

    /**
     * To Find any element in ArrayList
     * using recursion ,Extra Memory
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     * 
     */
    public int binarySearch(int low, int height, int target);

    /**
     * Returns {@code true} if this list is sorted.
     * 
     * @return {@code true} if this list is sorted ,otherwise {@code false};
     */
    public Boolean isSort();

    /**
     * Returns the largest value stored in ArrayList
     * 
     * @return max is the largest value stored in ArrayList is returned
     * 
     */
    public int max();

    /**
     * Returns the lowest value stored in ArrayList
     * 
     * @return min is the lowest value stored in ArrayList is returned
     * 
     */
    public int min();

    /**
     * Returns the sum of the values stored in ArrayList
     * 
     * @return sum of the values stored in ArrayList
     * 
     */
    public int sum();

    /**
     * Returns the avg of the values stored in ArrayList
     * 
     * @return avg of the values stored in ArrayList
     * 
     */
    public double avg();

    /**
     * It reflects the complete Arraylist elements by two pointers so that the first
     * element has its place in the last ,and the last element has its place in the
     * first.
     * 
     * 
     * @return {@code true} if reversed ArrayList Elements Complete,
     *         {@code false} if list is empty.
     */
    public boolean reverse();

    /**
     * rotates the elements of the Arraylist from left to right and element by
     * element is called each time {@code leftRotate()} method.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     * 
     * @return {@code true} if one element is moved to the left,otherwise
     *         {@code false} if list is empty.
     */
    public boolean leftRotate();

    /**
     * rotates the elements of the Arraylist from right to left and element by
     * element is called each time {@code rightRotate()} method.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * 
     * @return {@code true} if one element is moved to the right,otherwise
     *         {@code false} if list is empty.
     */
    public boolean rightRotate();

    public void insertSorted(int element);

    public boolean insertSort(int element);

    public void negativeLeftSide();
}