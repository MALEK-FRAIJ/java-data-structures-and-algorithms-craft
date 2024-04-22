package hashing.representation;

public class Chaining {

    /**
     * Array to store the head nodes of the linked lists
     */
    private Node[] hashKeys;

    /**
     * Constructs a new Chaining with initial capacity of 10.
     */
    public Chaining() {
        this.hashKeys = new Node[10];

    }

    /**
     * Generates the hash value for the given key.
     * 
     * @param key The key for which hash value needs to be generated.
     * @return The hash value for the given key.
     */
    public int getHash(int key) {
        return key % 10;
    }

    /**
     * Inserts a key into the HashMap.
     * 
     * @param key The key to be inserted.
     */
    public void insert(int key) {
        int hash = getHash(key);
        Node currentNode = hashKeys[hash];
        Node newNode = new Node(key, null);

        if (currentNode != null)
            newNode.next = hashKeys[hash];
        hashKeys[hash] = newNode;

    }

    /**
     * Searches for a key in the HashMap.
     * 
     * @param key The key to search for.
     * @return true if the key is found, false otherwise.
     */
    public boolean search(int key) {
        int hash = getHash(key);
        Node currentNode = hashKeys[hash];
        while (currentNode != null) {
            if (currentNode.data == key) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Removes a key from the HashMap.
     * 
     * @param key The key to be removed.
     * @return The removed key if found, -1 otherwise.
     */
    public int remove(int key) {
        int hash = getHash(key);
        Node current = hashKeys[hash];
        Node previous = null;

        if (current == null)
            return -1;

        if (current.data == key) {
            hashKeys[hash] = current.next;
            return current.data;
        }

        while (current != null) {
            if (current.data == key) {
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }

        return -1;
    }

    /**
     * Displays the contents of the HashMap.
     */
    public void display() {
        int index = 0;
        for (Node currentNode : hashKeys) {
            System.out.print("index " + index + ": ");
            while (currentNode != null) {
                if (currentNode.next == null)
                    System.out.print(currentNode.data);
                else
                    System.out.print(currentNode.data + "  ---->  ");

                currentNode = currentNode.next;
            }
            index++;
            System.out.println();
        }

    }

    /**
     * Inner class representing a node in the hash table.
     */
    static class Node {
        int data;
        Node next;

        /**
         * Constructs a new node with the given data and next node reference.
         * 
         * @param data The data to be stored in the node.
         * @param next Reference to the next node in the chain.
         */
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
