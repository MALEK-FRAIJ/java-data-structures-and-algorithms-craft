package stack.representation;

public class StackLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    StackLinkedList() {

    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element The element to be added to the stack.
     */
    public void push(int element) {
        Node newNode = new Node(element, head);
        head = newNode;
        if (isEmpty()) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack, or -1 if the stack is empty.
     */
    public int pop() {
        Node temp = head;
        if (temp == null) {
            return -1;
        }
        head = head.next;
        size--;
        return temp.data;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Retrieves the value of the first element in the linked list without removing
     * it.
     *
     * @return The value of the first element, or -1 if the list is empty.
     */
    public int peek() {
        return isEmpty() ? -1 : head.data; // Returns the data of the first node if not empty, otherwise -1
    }

    /**
     * Retrieves the head node of the linked list.
     *
     * @return The head node of the linked list.
     */
    public Node getHead() {
        return head; // Returns the head node of the linked list
    }

    public Node getTail() {
        return tail;
    }

    /**
     * Retrieves the current size of the linked list.
     *
     * @return The number of nodes in the linked list.
     */
    public int size() {
        return size; // Returns the size of the linked list
    }

    /**
     * Displays the elements of the linked list.
     */
    public void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while (temp != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.println("\b]");
    }

    /**
     * A static nested class representing a node in a linked list.
     */
    static class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node

        /**
         * Constructs a node with the provided data and reference to the next node.
         *
         * @param data The data to be stored in the node.
         * @param next Reference to the next node.
         */
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
