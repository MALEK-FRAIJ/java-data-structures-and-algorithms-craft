package stack.representation;

public class Stack {
    /**
     * Array to store stack elements
     */
    private int[] elementData;

    /**
     * Initial capacity of the stack
     */
    private int initialCapacity;

    /**
     * Index of the top element in the stack
     */
    private int peek = -1;
    /**
     * size is The number of elements in the stack.
     */
    private int size = 0;

    /**
     * Constructs a stack with an initial capacity of 10.
     */
    public Stack() {
        this.initialCapacity = 10;
        this.elementData = new int[initialCapacity];
    }

    /**
     * Constructs a stack with the specified initial capacity.
     *
     * @param initialCapacity The initial capacity of the stack.
     */
    public Stack(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.elementData = new int[initialCapacity];
    }

    /**
     * Checks if the stack is empty (contains no elements).
     *
     * @return true if the stack is empty; otherwise, false.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Checks if the stack is full and unable to accommodate more elements.
     *
     * @return true if the stack is full; otherwise, false.
     */
    public boolean isFull() {
        return size() == initialCapacity;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element The element to be added to the stack.
     * @return true if the element is successfully added; otherwise, false.
     */
    public boolean push(int element) {
        if (isFull())
            grow();
        elementData[++peek] = element;
        size++;
        return true;
    }

    /**
     * Retrieves the element at the top of the stack without removing it.
     *
     * @return The element at the top of the stack, or -1 if the stack is empty.
     */
    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return elementData[peek];
    }

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return The number of elements in the stack.
     */
    public int size() {
        return size;
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return The element at the top of the stack, or -1 if the stack is empty.
     */
    public int pop() {
        int element = -1;
        if (isEmpty()) {
            return element;
        }
        element = elementData[peek--];
        size--;
        return element;
    }

    /**
     * Doubles the capacity of the array 'elementData'.
     * This method is used for resizing the underlying array when reaching its
     * capacity.
     */
    private void grow() {
        int[] newElementData = new int[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
        initialCapacity *= 2;
        newElementData = null;
    }

    /**
     * Displays the elements of the stack.
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + ",");
        }
        System.out.println("\b]");
    }

    /**
     * Retrieves the initial capacity of the stack.
     *
     * @return The initial capacity with which the stack was created.
     */
    public int getInitialCapacity() {
        return initialCapacity;
    }

}
