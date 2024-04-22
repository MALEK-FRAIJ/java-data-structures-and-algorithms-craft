/**
 * This is a package that a contains on a classes for Data Structure 
 * @author Malek Fraij
 * @version 1.0
 * @since 2023
 */
package com.DataStructure;

/**
 * This is a simple class that represents a Collection Data Structure in java.
 *
 * @author Malek Fraij
 * @version 1.0
 */
public class ArrayList implements List {
    /**
     * Array of the Data
     */
    private int[] arrayList;

    /**
     * The number of items reserved for arrayList in memory
     * 
     * @value 10 default value will be added through Constructor
     */
    private int capacity;

    /**
     * The number of elements entered in arrayList
     * 
     * @value 0 default value will be added through Constructor
     */
    private int size;

    /**
     * Constructs a new ArrayList object with the default Value.
     *
     * 
     */
    public ArrayList() {
        this.capacity = 10;
        this.arrayList = new int[capacity];
        this.size = 0;
    }

    /**
     * Constructs a new ArrayList object with the given capacity.
     *
     * @param capacity The new number of items reserved for arrayList in memory.
     * 
     */
    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.arrayList = new int[capacity];
        this.size = 0;
    }

    /**
     * Appends the specified element to the end of this Array
     * 
     * @param element to be appended to this Array
     * @return {@code true} (if add element on the top)
     * @since 1.0
     */
    @Override
    public boolean add(int element) {

        if (isFull()) {
            changeCapacity();
        }
        this.arrayList[size++] = element;
        return true;
    }

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
    @Override
    public boolean add(int index, int element) throws ArrayIndexOutOfBoundsException {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException(index
                    + " > " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "source index" + index + " out of bounds for object array[" + this.capacity + "]");
        } else if (isFull()) {
            changeCapacity();
        }
        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = element;
        size++;
        return true;
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * 
     */
    private void changeCapacity() {
        int[] list = new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            list[i] = arrayList[i];
        }
        arrayList = list;
        list = null;
    }

    /**
     * Printing items located in ArrayList
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(arrayList[i] + ",");
            }
            System.out.print("\b]");
        }
    }

    /**
     * Tests if this ArrayList is empty.
     * 
     * @return {@code true} if and only if this ArrayList contains
     *         no items; {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Tests if this ArrayList is Full.
     * 
     * @return {@code true} if {@code (size == capacity)}; {@code false} otherwise.
     */
    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }

    /**
     * Returns the number of elements in this ArrayList.
     * 
     * @return the number of elements in this arraylist
     */
    @Override
    public int size() {
        return this.size;
    }

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
    @Override
    public int remove(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index
                    + " >= " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "source index" + index + " out of bounds for object array[" + this.capacity + "]");
        }
        int element = arrayList[index];
        for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        return element;
    }

    /**
     * To Find any element in ArrayList
     * best case the Time complexity is O(1)
     * Average case the Time complexity is O(n)
     * worst case the Time complexity is O(n) and if unsuccessful
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     * @since 1.0
     */
    @Override
    public int linearSearch(int target) {
        for (int i = 0; i < size - 1; i++) {
            if (arrayList[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * To swap two element of array List
     * 
     * @param index1 The first index of item to be replaced
     * @param index2 The second index of item to be replaced
     * @since 1.0
     */
    @Override
    public void swap(int index1, int index2) {
        int temp = arrayList[index1];
        arrayList[index1] = arrayList[index2];
        arrayList[index2] = temp;
    }

    /**
     * To Find any element in ArrayList
     * best case the Time complexity is O(1)
     * Average case the Time complexity is O(log n)
     * worst case the Time complexity is O(log n) and if unsuccessful
     * using iteration loop
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     * @since 1.0
     */
    @Override
    public int binarySearch(int target) {
        int low = 0, height = size - 1, middle;
        while (low <= height) {
            middle = (int) Math.floor((low + height) / 2);
            if (arrayList[middle] == target)
                return middle;

            if (arrayList[middle] > target)
                height = middle - 1;
            else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * To Find any element in ArrayList
     * best case the Time complexity is O(1)
     * Average case the Time complexity is O(log n)
     * worst case the Time complexity is O(log n) and if unsuccessful
     * using recursion ,Extra Memory
     * 
     * @param target is the item that will be searched for in the list
     * @return index if ArrayList contains the target,otherwise {@code return -1}
     * @since 1.0
     */

    @Deprecated
    public int binarySearch(int low, int height, int target) {

        if (low <= height) {
            int middle = (int) Math.floor((low + height) / 2);

            if (arrayList[middle] == target) {
                return middle;
            }

            if (arrayList[middle] > target)
                return binarySearch(low, middle - 1, target);
            else
                return binarySearch(middle + 1, height, target);

        }
        return -1;
    }

    /**
     * Returns {@code true} if this list is sorted.
     * using two pointer
     * 
     * @return {@code true} if this list is sorted ,otherwise {@code false};
     * @since 1.0
     */
    @Override
    public Boolean isSort() {
        int i = 0, j = size - 1;
        while (i < j) {
            if (arrayList[i] > arrayList[i + 1] || arrayList[j] < arrayList[j - 1]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Return the element which indexed
     * 
     * @param index index at which the specified element is to be returned
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *                                        ({@code index <= 0 || index > size})
     * @return Returns the element that was indexed from the ArrayList
     * @since 1.0
     */
    @Override
    public int get(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index
                    + " >= " + size);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(
                    "source index" + index + " out of bounds for object array[" + this.capacity + "]");
        }
        return arrayList[index];
    }

    /**
     * Replaces the element at the specified position in this ArrayList with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws ArrayIndexOutOfBoundsException if the index is out of range
     *                                        ({@code index < 0 || index >= size()})
     * @since 1.0
     */
    @Override
    public int set(int index, int element) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int oldValue = arrayList[index];
        arrayList[index] = element;
        return oldValue;
    }

    /**
     * Returns the largest value stored in ArrayList
     * 
     * @return max is the largest value stored in ArrayList is returned
     * @since 1.0
     */
    @Override
    public int max() {
        int max = arrayList[0];
        for (int i = 1; i < size; i++) {
            if (arrayList[i] > max) {
                max = arrayList[i];
            }
        }
        return max;
    }

    /**
     * Returns the lowest value stored in ArrayList
     * 
     * @return min is the lowest value stored in ArrayList is returned
     * @since 1.0
     */
    @Override
    public int min() {
        int min = arrayList[0];
        for (int i = 1; i < size; i++) {
            if (arrayList[i] < min) {
                min = arrayList[i];
            }
        }
        return min;
    }

    /**
     * Returns the sum of the values stored in ArrayList
     * 
     * @return sum of the values stored in ArrayList
     * @since 1.0
     */
    @Override
    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arrayList[i];
        }
        return sum;
    }

    /**
     * Returns the avg of the values stored in ArrayList
     * 
     * @return avg of the values stored in ArrayList
     * @since 1.0
     */
    @Override
    public double avg() {
        return sum() / size();
    }

    /**
     * It reflects the complete Arraylist elements by two pointers so that the first
     * element has its place in the last ,and the last element has its place in the
     * first.
     * Where he calls the {@code swap(index1,index2)}In order to switch elements
     * 
     * @return {@code true} if reversed ArrayList Elements Complete,
     *         {@code false} if list is empty.
     * @since 1.0
     */
    @Override
    public boolean reverse() {
        if (isEmpty()) {
            return false;
        } else {
            for (int i = 0, j = size - 1; i < j; i++, j--) {
                swap(i, j);
            }
        }
        return true;
    }

    /**
     * rotates the elements of the Arraylist from right to left and element by
     * element is called each time {@code rightRotate()} method.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * 
     * @return {@code true} if one element is moved to the right,otherwise
     *         {@code false} if list is empty.
     * @since 1.0
     */
    @Override
    public boolean rightRotate() {
        if (isEmpty()) {
            return false;
        } else {
            int oldValue = arrayList[size - 1];
            for (int i = size - 1; i > 0; i--) {
                arrayList[i] = arrayList[i - 1];
            }
            arrayList[0] = oldValue;
        }
        return true;
    }

    /**
     * rotates the elements of the Arraylist from left to right and element by
     * element is called each time {@code leftRotate()} method.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     * 
     * @return {@code true} if one element is moved to the left,otherwise
     *         {@code false} if list is empty.
     * @since 1.0
     */
    @Override
    public boolean leftRotate() {
        if (isEmpty()) {
            return false;
        } else {
            int oldValue = arrayList[0];
            for (int i = 0; i < size - 1; i++) {
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[size - 1] = oldValue;
        }
        return true;
    }

    @Override
    @Deprecated
    public void insertSorted(int element) {
        for (int i = 0; i < size; i++) {
            if (element <= arrayList[i]) {
                add(i, element);
                return;
            }
        }
        add(element);
    }

    @Override
    public boolean insertSort(int element) {
        if (isEmpty()) {
            return false;
        } else if (isFull()) {
            changeCapacity();
        }
        int i = size - 1;
        while (arrayList[i] > element) {
            arrayList[i + 1] = arrayList[i];
            i--;
            if (i == -1) {
                break;
            }
        }
        arrayList[i + 1] = element;
        size++;
        return true;
    }

    @Override
    public void negativeLeftSide() {
        int i = 0, j = size - 1;
        while (i < j) {
            while (arrayList[i] < 0) {
                i++;
            }
            while (arrayList[j] >= 0) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
        }
    }

    public void mergeList(ArrayList list) {
        int[] newList = new int[this.size + list.size];
        int i = 0, j = 0, k = 0;

        while (i < size && j < list.size) {
            if (this.arrayList[i] < list.arrayList[j]) {
                newList[k++] = this.arrayList[i++];
            } else {
                newList[k++] = list.arrayList[j++];
            }
        }
        while (i < size) {
            newList[k++] = this.arrayList[i++];
        }
        while (j < list.size) {
            newList[k++] = list.arrayList[j++];
        }
        this.arrayList = newList;
        this.size = newList.length;
        newList = null;
    }
    

}
