package queue.representation;

public class Queue<E> {

    /**
     * An array to store elements of generic type 'E'.
     */
    private E[] elementData;

    /**
     * Initial capacity set for the queue.
     */
    private int initialCapacity = 10;
    /**
     * Index representing the front of the queue.
     */
    private int front = -1;
    /**
     * Index representing the rear of the queue.
     */
    private int rear = -1;
    /**
     * Number of elements currently present in the queue.
     */
    private int size = 0;

    /**
     * Constructs a Queue with an initial capacity for elements.
     * 
     * @param initialCapacity The initial capacity of the Queue.
     */
    @SuppressWarnings("unchecked")
    Queue() {
        this.elementData = (E[]) new Object[initialCapacity];
    }

    /**
     * Constructs a Queue with a specified initial capacity for elements.
     * 
     * @param initialCapacity The initial capacity of the Queue.
     */
    @SuppressWarnings("unchecked")
    Queue(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.elementData = (E[]) new Object[initialCapacity];
    }

    /**
     * Checks if the queue is empty.
     * 
     * @return true if the queue is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full; otherwise, false.
     */
    public boolean isFull() {
        return rear == initialCapacity - 1;
    }

    /**
     * Offers an element to the queue.
     *
     * @param element The element to be added to the queue.
     * @return true if the element was added successfully; otherwise, false.
     */
    public boolean offer(E element) {
        if (isFull()) {
            grow();
        }
        elementData[++rear] = element;
        size++;
        return true;
    }

    /**
     * Retrieves and removes the element at the front of the queue.
     *
     * @return The element removed from the queue, or null if the queue is empty.
     */
    public E poll() {
        E element;
        if (isEmpty()) {
            return (E) null;
        }
        element = elementData[++front];
        size--;
        return element;
    }

    public void restingPointer() {
        front = rear = -1;
    }

    /**
     * Increases the capacity of the queue when it becomes full.
     * It doubles the current capacity and copies elements to the new queue.
     */
    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newQueue = (E[]) new Object[initialCapacity * 2];
        for (int i = front + 1; i <= rear; i++) {
            newQueue[i] = elementData[i];
        }
        initialCapacity *= 2;
        elementData = newQueue;
        newQueue = null;
    }

    /**
     * Retrieves the current size of the queue.
     *
     * @return The number of elements in the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the initial capacity of the queue.
     *
     * @return The initial capacity set for the queue.
     */
    public int getInitialCapacity() {
        return initialCapacity;
    }

    /**
     * Displays the elements of the queue.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(elementData[i] + ",");
        }
        System.out.println("\b]");
    }

}
