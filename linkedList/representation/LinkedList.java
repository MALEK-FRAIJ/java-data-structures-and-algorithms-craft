/**
 * This is a package that a contains on a classes for Data Structure 
 * LinkedList DSA
 * @author Malek Fraij
 * @version 1.0
 * @since 2023
 */
package linkedList.representation;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The LinkedList class represents a singly linked list implementation.
 *
 * @author Malek Fraij
 * @version 1.0
 */
public class LinkedList {

    /**
     * Pointer to first node.
     */
    private Node head;

    /**
     * Pointer to tail node.
     */
    private Node tail;

    /**
     * size of element in linkedList.
     * 
     * @value 0 default value initial value
     */
    private int size = 0;

    /**
     * Constructs an empty SinglyLinkedList.
     */
    public LinkedList() {

    }

    /**
     * Returns the number of elements in this LinkedList.
     * 
     * @return the number of elements in this LinkedList
     */

    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     *
     * @implSpec
     *           This implementation returns {@code size() == 0}.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * Checks whether the given index is within the bounds of the linked list
     * positions.
     * Throws an IndexOutOfBoundsException if the index is out of range.
     * 
     * @param index The index to be checked.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactoring of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Adds the specified element to the end of the linked list.
     * 
     * @param element The element to be added to the end of the linked list.
     * @return true if the element is successfully added to the linked list.
     */
    public boolean add(int element) {
        addLast(element);
        return true;
    }

    /**
     * Adds a new node with the specified element at the beginning of the linked
     * list.
     * 
     * @param element The element to be added to the beginning of the linked list.
     */
    public void addFirst(int element) {
        Node first = head;
        Node newNode = new Node(element, head);
        head = newNode;
        if (first == null) {
            tail = newNode;
        } /*
           * else {
           * first.next = newNode;
           * }
           */
        size++;
    }

    /**
     * Inserts an element at the specified index in the linked list.
     *
     * @param index   The index at which the element will be inserted.
     * @param element The element to be inserted into the linked list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public void add(int index, int element) {
        checkPositionIndex(index); // Checks if the index is within the range of the linked list
        if (index == size) {
            addLast(element);
        } else {
            checkIndexFirst(index, element);
        }
    }

    /**
     * Checks the index to determine the insertion point for an element in the
     * linked list.
     * If the index is 0, adds the element at the beginning.
     * Otherwise, adds the element at the specified index.
     *
     * @param index   The index at which the element will be inserted.
     * @param element The element to be inserted into the linked list.
     */
    private void checkIndexFirst(int index, int element) {
        if (index == 0) {
            addFirst(element);
        } else {
            linkBefore(index, element);
        }
    }

    /**
     * Checks the index to determine whether to remove the first element or a
     * specific element in the linked list.
     *
     * @param index The index of the element to be checked or removed.
     * @return The data of the removed element if the index is not 0; otherwise,
     *         returns void.
     * @throws NoSuchElementException if the list is empty or the index is out of
     *                                bounds.
     */
    private int checkIndexLast(int index) {
        if (index == 0) {
            return removeFirst();
        }
        return linkRemove(index);
    }

    /**
     * Inserts an element at the specified index in the linked list.
     * 
     * @param index   The index at which the element will be inserted.
     * @param element The element to be inserted into the linked list.
     */
    public void linkBefore(int index, int element) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(element, temp.next);
        temp.next = newNode;
        size++;
    }

    /**
     * Inserts an element at the end of the linked list.
     *
     * @param element The element to be inserted at the end of the linked list.
     */
    public void addLast(int element) {
        Node last = tail;
        Node newNode = new Node(element, null);
        tail = newNode;
        if (last == null) {
            head = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    /**
     * Pushes an element onto the top of the linked list (equivalent to addFirst).
     *
     * @param element The element to be added to the beginning of the linked list.
     * @return true to indicate the element was successfully added to the linked
     *         list.
     */
    public boolean push(int element) {
        addFirst(element);
        return true;
    }

    /**
     * Offers an element for insertion into the linked list (equivalent to add).
     *
     * @param element The element to be added to the linked list.
     * @return true to indicate the element was successfully offered for insertion
     *         into the linked list.
     */
    public boolean offer(int element) {
        return add(element);
    }

    /*
     * public void addSort(int element) {
     * Node first = head, last = null;
     * 
     * while (first != null && first.data < element) {
     * last = first;
     * first = first.next;
     * }
     * Node newNode = new Node(element, last.next);
     * last.next = newNode;
     * size++;
     * }
     */

    /**
     * Inserts an element into the sorted linked list while preserving the ascending
     * order.
     *
     * @param element The element to be inserted into the sorted linked list.
     */
    public void addSort(int element) {
        int count = 0;
        Node temp = head;
        while (temp != null && temp.data < element) {
            count++;
            temp = temp.next;
        }
        add(count, element);
    }

    /**
     * Removes and returns the data from the first node of the linked list.
     * This method is equivalent to calling removeFirst().
     *
     * @return The data from the first node of the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    public int remove() {
        return removeFirst();
    }

    /**
     * Removes and returns the data from the first node of the linked list.
     * Throws NoSuchElementException if the list is empty.
     *
     * @return The data from the first node of the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    public int removeFirst() {
        Node first = head;
        if (first == null) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        head = head.next;
        size--;
        return first.data;
    }

    /**
     * Removes the node at the specified index from the linked list and returns its
     * data.
     *
     * @param index The index of the node to be removed.
     * @return The data of the removed node.
     * @throws NoSuchElementException if the list is empty or the index is out of
     *                                bounds.
     */
    public int remove(int index) {
        checkPositionIndex(index);
        if (index == size - 1) {
            return removeLast();
        }
        return checkIndexLast(index);
    }

    /**
     * Removes and returns the data from the last node of the linked list.
     *
     * @return The data from the last node of the linked list.
     * @throws NoSuchElementException if the list is empty.
     */
    public int removeLast() {
        Node first = head, last = null;
        if (first == null) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        while (first.data != tail.data) {
            last = first;
            first = first.next;
        }
        last.next = null;
        tail = last;
        size--;
        return first.data;
    }

    /**
     * Removes the node at the specified index from the linked list and returns its
     * data.
     *
     * @param index The index of the node to be removed.
     * @return The data of the removed node.
     * @throws NoSuchElementException if the list is empty or the index is out of
     *                                bounds.
     */
    public int linkRemove(int index) {
        Node first = head, last = null;
        if (first == null) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }
        for (int i = 0; i < index; i++) {
            last = first;
            first = first.next;
        }
        last.next = first.next;
        size--;
        return first.data;
    }

    /**
     * Displays the data of the linked list in the forward order.
     * Traverses the linked list starting from the head node
     * and prints the data of each node in the forward direction.
     */
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Displays the data of a linked list recursively in reverse order.
     * Starting from the given node, it prints the data of each node in reverse
     * order.
     * 
     * @param first The starting node of the linked list.
     */
    public void recursiveDisplay(Node first) {
        if (first != null) {
            recursiveDisplay(first.next);
            System.out.print(first.data + " ");
        }
    }

    /**
     * Retrieves the head node of the linked list.
     *
     * @return The head node of the linked list.
     */
    public Node getHead() {
        return head;
    }

    /**
     * Retrieves the data of the first node in the linked list.
     *
     * @return The data of the first node in the linked list, or a sentinel value
     *         (e.g., -1) if the list is empty.
     */
    public int peekFirst() {
        Node first = head;
        return (first == null) ? -1 : first.data; // Returning -1 as a sentinel value if the list is empty
    }

    /**
     * Retrieves the data of the last node in the linked list.
     * 
     * @return The data of the last node in the linked list, or a default value
     *         (e.g., -1) if the list is empty.
     */
    public int peekLast() {
        Node last = tail;
        return (last == null) ? -1 : last.data; // Returning -1 as a default value if the list is empty
    }

    /**
     * Counts the number of nodes starting from the given node.
     *
     * @param first The starting node of the linked list.
     * @return The total number of nodes starting from the given node.
     */
    public int countNode(Node first) {
        int count = 0;
        while (first != null) {
            count++;
            first = first.next;
        }
        return count;
    }

    /**
     * Calculates the sum of all elements in the linked list.
     * Traverses the linked list starting from the head node
     * and computes the sum of all node data values.
     *
     * @return The sum of all elements in the linked list.
     */
    public int sumOfAllElements() {
        Node temp = head;
        int sum = 0;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    /**
     * Calculates the sum of all elements in the linked list using recursion.
     * Recursively traverses the linked list starting from the given node
     * and computes the sum of all node data values.
     *
     * @param first The starting node of the linked list.
     * @return The sum of all elements in the linked list.
     */
    public int sumOfAllElementsRecursive(Node first) {
        if (first == null) {
            return 0;
        }
        return first.data + sumOfAllElementsRecursive(first.next);
    }

    /**
     * Finds the maximum value among all elements in the linked list.
     * Traverses the entire linked list starting from the head node
     * and determines the maximum value among all node data values.
     *
     * @return The maximum value among all elements in the linked list,
     *         or Integer.MIN_VALUE if the list is empty.
     */
    public int Max() {
        Node temp = head;
        int max = Integer.MIN_VALUE;

        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
            }
            temp = temp.next;
        }
        return max;
    }

    /**
     * Finds the maximum value among all elements in the linked list using
     * recursion.
     * Recursively traverses the linked list starting from the given node
     * and determines the maximum value among all node data values.
     *
     * @param first The starting node of the linked list.
     * @return The maximum value among all elements in the linked list,
     *         or Integer.MIN_VALUE if the list is empty.
     */
    public int maxRecursive(Node first) {
        if (first == null) {
            return Integer.MIN_VALUE;
        }
        int max = maxRecursive(first.next);
        return max > first.data ? max : first.data;
    }

    /**
     * Searches for a node containing the specified element in the linked list.
     *
     * @param element The element to search for in the linked list.
     * @return The node containing the specified element if found, otherwise returns
     *         null.
     */
    public Node search(int element) {

        Node temp = head;
        while (temp != null) {
            if (temp.data == element) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * Searches for a node containing the specified element in the linked list and
     * moves it to the head.
     *
     * @param element The element to search for in the linked list.
     * @return The node containing the specified element if found and moved to the
     *         head, otherwise returns null.
     */
    public Node searchMoveToHead(int element) {
        Node first = head, last = null;

        while (first != null) {
            last = first;
            if (first.data == element) {
                last.next = first.next;
                first.next = head;
                head = first;
                return first;
            }

            first = first.next;
        }
        return null;
    }

    /**
     * Checks if the linked list, starting from the head, is sorted in ascending
     * order.
     *
     * @return true if the linked list is sorted in ascending order; otherwise,
     *         false.
     */
    public boolean isSorted() {
        Node first = head;
        int min = Integer.MIN_VALUE;
        while (first != null) {
            if (first.data < min) {
                return false;
            }
            min = first.data;
            first = first.next;
        }
        return true;
    }

    /**
     * Converts the linked list into an integer array.
     *
     * @return An array containing the elements of the linked list.
     */
    public int[] toArray() {
        Node first = head;
        int[] array = new int[size];
        int i = 0;
        while (first != null) {
            array[i] = first.data;
            first = first.next;
            i++;
        }
        return array;
    }

    /**
     * Reverses the order of elements in the linked list.
     * Note: This method modifies the existing linked list in place.
     */
    public void reverseLinkedList() {
        Node first = head;
        int[] array = toArray();
        int i = array.length - 1;
        while (first != null) {
            first.data = array[i--];
            first = first.next;
        }
    }

    /**
     * Reverses the order of elements in the linked list using a sliding pointer
     * approach.
     * Note: This method modifies the existing linked list in place.
     */
    public void reverseLinkedListSliding() {
        Node last = head, middle = null, first = null;

        while (last != null) {
            first = middle;
            middle = last;
            last = last.next;
            middle.next = first;
        }
        tail = head;
        head = middle;
    }

    /**
     * Removes duplicated elements from the linked list.
     * Note: This method assumes the list is sorted.
     * Modifies the existing linked list in place.
     */
    public void removeDuplicated() {
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                size--; // Decrement size to reflect removed node
            } else {
                temp = temp.next;
            }
        }
        // Update tail to the last node after removing duplicates
        tail = temp;
    }

    /*
     * public void reverseLinkedListRecursive(Node last,Node temp) {
     * 
     * if (temp != null) {
     * 
     * reverseLinkedListRecursive(temp,temp.next)
     * temp.next = last;
     * } else
     * head = last;
     * 
     * }
     */

    /**
     * Concatenates the current linked list with another linked list.
     *
     * @param list The linked list to be concatenated with the current list.
     */
    public void concatenationTwoLinkedList(LinkedList list) {
        tail.next = list.head;
        tail = list.tail;
    }

    /**
     * Merges the current linked list with another linked list in sorted order.
     *
     * @param list The linked list to be merged with the current list.
     */
    public void mergeTwoLinkedList(LinkedList list) {
        Node mergedHead = new Node(0, null); // Create a dummy node to simplify logic
        Node current = mergedHead;

        Node first = head;
        Node second = list.head;

        while (first != null && second != null) {
            if (first.data < second.data) {
                current.next = first;
                first = first.next;
            } else {
                current.next = second;
                second = second.next;
            }
            current = current.next;
        }

        if (first != null) {
            current.next = first;
        } else {
            current.next = second;
            tail = list.tail; // Update the tail to the tail of the merged list
        }

        // Update the head of the merged list
        head = mergedHead.next;
    }

    /**
     * Merges two sorted linked lists into a single sorted linked list using
     * recursion.
     *
     * @param list1 The head node of the first sorted linked list.
     * @param list2 The head node of the second sorted linked list.
     * @return The head node of the merged sorted linked list.
     */
    public Node mergeTwoLinkedList(Node list1, Node list2) {
        if (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                list1.next = mergeTwoLinkedList(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLinkedList(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        }
        return list1;
    }

    /**
     * Checks whether a loop exists in the linked list using the Floyd's Cycle
     * Detection algorithm.
     *
     * @return true if a loop is found, false otherwise
     */
    public boolean checkLoopInLinkedList() {
        Node first = head, last = head;
        while (first != null && last != null && last.next != null) {
            last = last.next.next;
            first = first.next;
            if (last == first) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a loop in the linked list by connecting the tail node to a specific node
     * indicated by the provided index.
     *
     * @param index The index of the node to which the tail node will be connected
     *              to create a loop.
     * @throws IndexOutOfBoundsException if the index is out of the linked list's
     *                                   range.
     */
    public void addLoopInLinkedList(int index) {
        checkPositionIndex(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        tail.next = temp;
    }

    /**
     * Displays the elements of a circular linked list starting from the head node.
     * This method traverses the circular list and prints each element until it
     * reaches the head node again.
     */
    public void displayCircular() {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    /**
     * Recursively displays the elements of a circular linked list starting from the
     * given node.
     * 
     * @param temp The starting node from which to display the circular linked list.
     */
    static boolean flag = true;

    public void displayCircularRecursive(Node temp) {
        if (temp != head || flag) {
            flag = false;
            System.out.print(temp.data + " ");
            displayCircularRecursive(temp.next);
        }
        flag = true;
    }

    /**
     * Adds a new node containing the specified element to a circular linked list.
     *
     * @param element The element to be added to the circular linked list.
     */
    public void addCircular(int element) {
        Node temp = head, last = null;
        do {
            last = temp;
            temp = temp.next;
        } while (temp != head);
        Node newNode = new Node(element, temp);
        last.next = newNode;
        tail = newNode;
    }

    /**
     * Removes the last node from the circular linked list.
     * Note: Assumes the circular linked list contains at least one node.
     */
    public void removeCircular() {
        Node first = head, second = null, third = null;
        do {
            third = second;
            second = first;
            first = first.next;
        } while (first != head);
        second = null;
        third.next = first;
        tail = third;
    }

    /*
     * public Node middleNode() {
     * Node temp = head;
     * for (int i = 0; i < Math.floor(size / 2); i++) {
     * temp = temp.next;
     * }
     * return temp;
     * }
     */

    public Node middleNode() {
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int s = (int) Math.floor(stack.size() / 2);
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        return stack.pop();
    }

    /**
     * Represents a node in a linked list.
     */
    static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the linked list

        /**
         * Constructs a node with the given data and reference to the next node.
         *
         * @param data The data to be stored in the node.
         * @param next Reference to the next node in the linked list.
         */
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
