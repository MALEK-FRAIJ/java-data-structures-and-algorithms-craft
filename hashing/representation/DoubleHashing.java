package hashing.representation;

public class DoubleHashing {

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

    private static final int PRIME = 7;

    /**
     * Constructs a DoubleHashing instance with a default initial capacity of 10.
     */
    public DoubleHashing() {
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
     * Calculates the hash value for a given key using modulo operation.
     * 
     * @param key the key to calculate the hash value for.
     * @return the hash value calculated using modulo operation.
     */
    private int getHash(int key) {
        return key % initialCapacity;
    }

    /**
     * Calculates the hash value for a given key using prime number subtraction.
     * 
     * @param key the key to calculate the hash value for.
     * @return the hash value calculated using prime number subtraction.
     */
    private int PrimeHash(int key) {
        return PRIME - (key % PRIME);
    }

    /**
     * Performs double hashing to find an empty slot for insertion.
     * 
     * @param index1 the first hash index.
     * @param index2 the second hash index.
     * @return the index where the key should be inserted.
     */
    private int DoubleHash(int index1, int index2) {
        int probeCount = 0;
        while (hashKeys[(index1 + probeCount * index2) % initialCapacity] != 0) {
            probeCount++;
        }
        return (index1 + probeCount * index2) % initialCapacity;
    }

    /**
     * Inserts a key into the hash table using double hashing.
     * 
     * @param key the key to be inserted.
     */
    public void insert(int key) {
        int index1 = getHash(key);
        int index2 = PrimeHash(key);
        if (hashKeys[index1] != 0) {
            index1 = DoubleHash(index1, index2);
        }
        hashKeys[index1] = key;
        size++;
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
