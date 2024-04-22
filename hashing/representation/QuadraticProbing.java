package hashing.representation;

public class QuadraticProbing {

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
     * Constructs a QuadraticProbing instance with a default initial capacity of 10.
     */
    QuadraticProbing() {
        this.initialCapacity = 10;
        this.hashKeys = new int[initialCapacity];
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
     * Generates the hash value for the given key.
     * 
     * @param key The key for which hash value needs to be generated.
     * @return The hash value for the given key.
     */
    public int getHash(int key) {
        return key % initialCapacity;
    }

    /**
     * Performs quadratic probing to find an empty slot for insertion.
     * 
     * @param key the key to be inserted.
     * @return the index where the key should be inserted.
     */
    private int QuadraticProbe(int key) {
        int index = getHash(key);
        int i = 0;
        while (hashKeys[(index + i * i) % initialCapacity] != 0) {
            i++;
        }
        return (index + i * i) % initialCapacity;
    }

    /**
     * Inserts a key into the hash table using quadratic probing.
     * 
     * @param key the key to be inserted.
     */
    public void insert(int key) {
        int index = getHash(key);
        if (hashKeys[index] != 0) {
            index = QuadraticProbe(key);
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
        while (probeCount < initialCapacity && hashKeys[(index + probeCount * probeCount) % initialCapacity] != key) {
            probeCount++;
            if (hashKeys[(index + probeCount * probeCount) % initialCapacity] == 0) {
                return -1;
            }
        }
        return (probeCount == initialCapacity) ? -1 : (index + probeCount * probeCount) % initialCapacity;
    }

    /**
     * Searches for a key in the hash table.
     * 
     * @param key the key to search for.
     * @return the index of the key if found, or -1 if not found.
     */
    public int search(int key) {
        int index = getHash(key);
        if (hashKeys[index] != key) {
            index = searchProb(key);
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
