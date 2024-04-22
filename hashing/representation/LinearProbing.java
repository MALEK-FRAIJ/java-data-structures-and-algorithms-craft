package hashing.representation;

/**
 * LinearProbing is a simple implementation of a hash table using linear probing
 * collision resolution.
 */
public class LinearProbing {

    /**
     * The array to store hash keys.
     */
    private int[] hashKeys;

    /**
     * The initial capacity of the hash table.
     */
    private int initialCapacity;

    /**
     * The number of elements currently stored in the hash table.
     */
    private int size = 0;

    /**
     * Constructs a LinearProbing instance with a default initial capacity of 10.
     */
    public LinearProbing() {
        this.initialCapacity = 10;
        this.hashKeys = new int[initialCapacity];
    }

    /**
     * Checks if the hash table is full.
     *
     * @return true if the hash table is full, false otherwise.
     */
    public boolean isFull() {
        return size == initialCapacity;
    }

    /**
     * Checks if the hash table is empty.
     *
     * @return true if the hash table is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Gets the initial capacity of the hash table.
     *
     * @return the initial capacity of the hash table.
     */
    public int getInitialCapacity() {
        return initialCapacity;
    }

    /**
     * Gets the number of elements currently stored in the hash table.
     *
     * @return the number of elements stored in the hash table.
     */
    public int getSize() {
        return size;
    }

    /**
     * Calculates the loading factor of the hash table.
     *
     * @return the loading factor (ratio of elements to capacity) of the hash table.
     */
    public double loadingFactor() {
        return (double) size / initialCapacity;
    }

    /**
     * Generates the hash value for the given key.
     * 
     * @param key The key for which hash value needs to be generated.
     * @return The hash value for the given key.
     */
    public int getHash(int key) {
        return key % initialCapacity;
    }

    /**
     * Performs linear probing to find an empty slot for insertion.
     * 
     * @param key the key to be inserted.
     * @return the index where the key should be inserted.
     */
    private int probing(int key) {
        int index = getHash(key);
        int i = 0;
        while (hashKeys[(i + index) % initialCapacity] != 0) {
            index++;
        }
        return (i + index) % initialCapacity;
    }

    /**
     * Inserts a key into the hash table using linear probing.
     * 
     * @param key the key to be inserted.
     */
    public void insert(int key) {
        int index = getHash(key);
        if (isFull()) {
            System.out.println("Hash Keys Array in LinearProbing is Full...");
            System.out.println("Can't inserted..");
            return;
        }
        if (hashKeys[index] != 0) {
            index = probing(key);
        }
        hashKeys[index] = key;
        size++;
    }

    /**
     * Performs linear probing to search for a key in the hash table.
     * 
     * @param key the key to search for.
     * @return the index of the key if found, or -1 if not found.
     */
    private int searchProb(int key) {
        int index = getHash(key);
        int probeCount = 0;
        while (probeCount < initialCapacity && hashKeys[(index + probeCount) % initialCapacity] != key) {
            probeCount++;
            if (hashKeys[(index + probeCount) % initialCapacity] == 0) {
                return -1;
            }
        }
        return (probeCount == initialCapacity) ? -1 : (index + probeCount) % initialCapacity;
    }

    /**
     * Searches for a key in the hash table.
     * 
     * @param key the key to search for.
     * @return the index of the key if found, or -1 if not found.
     */
    public int search(int key) {
        int index = getHash(key);
        if (hashKeys[index] != key)
            index = searchProb(key);

        return index;
    }

    /**
     * Removes a key from the hash table.
     * 
     * @param key the key to be removed.
     * @return the index of the removed key, or -1 if the key was not found.
     */
    public int remove(int key) {
        int index = search(key);
        if (index >= 0) {
            hashKeys[index] = 0;
            size--;
        }
        return index;
    }

    /**
     * Updates the value of a key in the hash table.
     * 
     * @param key    the key to be updated.
     * @param newKey the new value for the key.
     * @return the index of the updated key, or -1 if the key was not found.
     */
    public int setElement(int key, int newKey) {
        int index = search(key);
        if (index >= 0) {
            hashKeys[index] = newKey;
        }
        return index;
    }

    /**
     * Displays the contents of the hash table.
     */
    public void display() {
        for (int i = 0; i < hashKeys.length; i++) {
            System.out.println("index " + i + " ---> " + hashKeys[i]);
        }
    }
}
