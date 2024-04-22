package hashing.representation;

import java.util.ArrayList;

/**
 * Represents a generic map data structure.
 * 
 * @param <K> the type of keys.
 * @param <V> the type of values.
 */
public class Map<K, V> {

    private ArrayList<MapNode<K, V>> buckets;
    private int size;
    private int initialCapacity;
    final double DEFAULT_LOAD_FACTOR = 0.75;

    public Map() {
        this.initialCapacity = 5;
        this.buckets = new ArrayList<>(initialCapacity);
        addDefaultValueOfBuckets();
    }

    public Map(int initialCapacity) {
        this.buckets = new ArrayList<>(initialCapacity);
        addDefaultValueOfBuckets();
    }

    private void addDefaultValueOfBuckets() {
        for (int i = 0; i < initialCapacity; i++) {
            this.buckets.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public double getDEFAULT_LOAD_FACTOR() {
        return DEFAULT_LOAD_FACTOR;
    }

    private int getBucketInd(K key) {
        int hashCode = key.hashCode();
        return (hashCode % initialCapacity);
    }

    public void add(K key, V value) {
        int bucketInd = getBucketInd(key);
        MapNode<K, V> head = buckets.get(bucketInd);

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        MapNode<K, V> newMapNode = new MapNode<K, V>(key, value);
        head = buckets.set(bucketInd, newMapNode);
        System.out.println("Pair(" + key + ", " + value + ") inserted successfully.\n");
        size++;
        checkLoadFactor();
    }

    private void checkLoadFactor() {
        double loadFactor = (1.0 * getSize() / initialCapacity);
        System.out.println("Current Load factor = " + loadFactor);
        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            System.out.println(loadFactor + " is greater than " + DEFAULT_LOAD_FACTOR);
            System.out.println("Therefore Rehashing will be done.\n");
            rehash();
            System.out.println("New Size of Map: " + initialCapacity + "\n");
        }

        System.out.println("Number of pairs in the Map: " + size);
        System.out.println("Size of Map: " + initialCapacity + "\n");
    }

    private void rehash() {
        ArrayList<MapNode<K, V>> temp = buckets;
        System.out.println("\n***Rehashing Started***\n");
        for (int i = 0; i < 2 * initialCapacity; i++) {
            buckets.add(null);
        }
        size = 0;
        initialCapacity *= 2;
        for (int i = 0; i < temp.size(); i++) {

            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V val = head.value;
                add(key, val);
                head = head.next;
            }
        }
        System.out.println("\n***Rehashing Ended***\n");
    }

    public void printMap() {
        ArrayList<MapNode<K, V>> temp = buckets;
        System.out.println("Current HashMap:");

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                System.out.println("key = " + head.key + ", val = " + head.value);
                head = head.next;
            }
        }
        System.out.println();
    }

    // Function to get an element from Map
    public V getValue(K key) {
        // Get actual index of the key
        int actualIndex = getBucketInd(key);
        MapNode<K, V> temp = buckets.get(actualIndex);
        // Search for key in list
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * Represents a node in the map.
     */
    @SuppressWarnings("hiding")
    class MapNode<K, V> {

        K key;
        V value;
        MapNode<K, V> next;

        /**
         * Constructs a new MapNode with the specified key and value.
         * 
         * @param key   the key of the node.
         * @param value the value associated with the key.
         */
        public MapNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}
