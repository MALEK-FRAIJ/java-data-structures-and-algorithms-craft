package linkedList.representation;

public class DoubleLinkedList {

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
     * Constructs an empty DoubleLinkedList.
     */
    public DoubleLinkedList() {

    }

    public int getSize() {
        return size;
    }

    public Node getTail() {
        return tail;
    }

    public void linkBefore(int element) {
        Node temp = head;
        Node newNode = new Node(null, element, head);
        head.prev = newNode;
        head = newNode;
        if (temp == null) {
            tail = newNode;
        }
        size++;
    }

    public void add(int index, int element) {
        if (index == 0) {
            linkBefore(element);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
        }
    }

    /**
     * Represents a node in a Double linked list.
     */
    static class Node {
        Node prev;// Reference to the previous node in the linked list
        int data; // Data stored in the node
        Node next; // Reference to the next node in the linked list

        /**
         * Constructs a node with the given data and reference to the next node.
         *
         * @param prev Reference to the previous node in the linked list.
         * @param data The data to be stored in the node.
         * @param next Reference to the next node in the linked list.
         */
        Node(Node prev, int data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
