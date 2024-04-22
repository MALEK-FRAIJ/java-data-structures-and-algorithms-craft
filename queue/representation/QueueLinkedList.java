package queue.representation;

public class QueueLinkedList {

    private Node head;
    private Node tail;

    /**
     * Number of elements currently present in the queue.
     */
    private int size = 0;

    QueueLinkedList() {

    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        Node newNode = new Node(-1, null);
        return newNode == null;
    }

    /**
     * Retrieves the head node of the linked list.
     *
     * @return The head node of the linked list.
     */
    public Node getHead() {
        return head; // Returns the head node of the linked list
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
     * Offers an element to the queue.
     *
     * @param element The element to be added to the queue.
     * @return true if the element was added successfully; otherwise, false.
     */
    public boolean offer(int element) {
        Node temp = head;
        Node newNode = new Node(element, null);
        if (temp == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * Retrieves and removes the element at the front of the queue.
     *
     * @return The element removed from the queue, or null if the queue is empty.
     */
    public Node poll() {
        Node temp = head;
        if (isEmpty()) {
            return temp;
        }
        size--;
        head = head.next;
        return temp;
    }

    /**
     * Displays the elements of the queue.
     */
    public void display() {
        Node temp = head;
        if (isEmpty()) {
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
