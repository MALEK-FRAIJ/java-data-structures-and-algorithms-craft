package queue.representation;

public class PriorityQueue {
    private int[] elementData;
    private int size;
    private int initialCapacity;
    private int peek = -1;

    PriorityQueue() {
        this.initialCapacity = 10;
        this.size = 0;
        this.elementData = new int[initialCapacity];
    }

    PriorityQueue(int initialCapacity) {
        super();
        this.initialCapacity = initialCapacity;
        this.elementData = new int[initialCapacity];
    }

    public boolean isEmpty() {
        return peek < 0;
    }

    public boolean isFull() {
        return peek == initialCapacity - 1;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public int size() {
        return size;
    }

    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        return elementData[peek];
    }

    public boolean offer(int element) {
        if (isFull()) {
            grow();
        }
        if (!isEmpty() && element > elementData[peek]) {
            // shiftRight(element);
            return true;
        }
        elementData[++peek] = element;
        size++;
        return true;
    }

    public int poll() {
        int element = -1;
        if (isEmpty()) {
            return element;
        }
        element = elementData[peek--];
        size--;
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
            return;
        }
        for (int i = 0; i <= peek; i++) {
            System.out.print(elementData[i] + ",");
        }
        System.out.println("\b]");
    }

    private void grow() {
        int[] newElementData = new int[initialCapacity * 2];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
        newElementData = null;
        initialCapacity *= 2;
    }

}
