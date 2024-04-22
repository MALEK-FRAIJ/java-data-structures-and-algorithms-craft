package sorting.techniques;

public class Sorting {

    /**
     * Sorts an array of integers using Bubble Sort algorithm.
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void bubbleSort(int[] arr, int length) {
        boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < (length - i) - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Swaps two elements in an integer array.
     *
     * @param arr The array in which elements are to be swapped.
     * @param i   Index of the first element.
     * @param j   Index of the second element.
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Sorts an array of integers using Insertion Sort algorithm.
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void insertionSort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * Sorts an array of integers using Selection Sort algorithm.
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void selectionSort(int[] arr, int length) {
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * Partitions the array into two segments based on a pivot element.
     * Elements smaller than the pivot are placed to the left, and elements greater
     * than the pivot are placed to the right.
     *
     * @param arr   The array to be partitioned.
     * @param begin The starting index of the partition range.
     * @param end   The ending index of the partition range.
     * @return The index of the pivot element after partitioning.
     */
    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int i = begin - 1;
        int j = end + 1;

        do {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                swap(arr, i, j);
            }
        } while (i < j);

        swap(arr, begin, j);
        return j;
    }

    /**
     * Sorts an array of integers using QuickSort algorithm.
     *
     * @param arr   The array to be sorted.
     * @param begin The starting index of the array or partition to be sorted.
     * @param end   The ending index of the array or partition to be sorted.
     */
    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int middle = partition(arr, begin, end);
            quickSort(arr, begin, middle);
            quickSort(arr, middle + 1, end);
        }
    }

    /**
     * Sorts an array of integers using Counting Sort algorithm.
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void countSort(int[] arr, int length) {
        int max = findMax(arr, length);
        int[] countArray = new int[max + 1];

        // Count occurrences of each element
        for (int i = 0; i < length; i++) {
            countArray[arr[i]]++;
        }

        // Reconstruct the sorted array based on counts
        int k = 0;
        int i = 0;
        while (i < max + 1) {
            if (countArray[i] > 0) {
                arr[k++] = i;
                countArray[i]--;
            } else {
                i++;
            }
        }
    }

    /**
     * Finds the maximum value in the given array.
     *
     * @param arr    The array to search for the maximum value.
     * @param length The number of elements in the array.
     * @return The maximum value in the array.
     */
    private int findMax(int[] arr, int length) {
        int max = arr[0];
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Sorts an array of integers using Bucket Sort algorithm with linked lists
     * (bin/bucket).
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void binBucketSort(int[] arr, int length) {
        int max = findMax(arr, length);
        Node[] bins = new Node[max + 1];

        // Distribute elements into bins
        for (int i = 0; i < length; i++) {
            insertIntoBin(bins, arr[i]);
        }

        // Gather elements back from bins into the original array
        int i = 0, k = 0;
        while (i < max + 1) {
            if (bins[i] != null) {
                arr[k++] = deleteFromBin(bins, i);
            } else {
                i++;
            }
        }
    }

    /**
     * Deletes and returns an element from the specified bin in the bucket.
     *
     * @param bins  The array of bins/buckets.
     * @param index The index of the bin to delete from.
     * @return The deleted element.
     */
    private int deleteFromBin(Node[] bins, int index) {
        Node node = bins[index];
        bins[index] = bins[index].next;
        return node.data;
    }

    /**
     * Inserts an element into the appropriate bin in the bucket.
     *
     * @param bins  The array of bins/buckets.
     * @param value The value to be inserted.
     */
    private void insertIntoBin(Node[] bins, int value) {
        int index = value; // Using value as the index for simplicity; you may need a hashing function here
                           // in a practical scenario
        if (bins[index] == null) {
            bins[index] = new Node(value, null);
        } else {
            Node newNode = new Node(value, bins[index]);
            bins[index] = newNode;
        }
    }

    /**
     * Displays the elements of an integer array in a formatted manner.
     *
     * @param arr The array to display.
     */
    public void display(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    /**
     * Sorts an array of integers using Radix Sort algorithm.
     *
     * @param arr    The array to be sorted.
     * @param length The number of elements in the array to be sorted.
     */
    public void radixSort(int[] arr, int length) {
        int max = findMax(arr, length);
        int divisor = 1;
        Node[] bins = new Node[10];

        // Iterate through each digit position (from right to left)
        while (max / divisor > 0) {
            // Distribute elements into bins based on the current digit
            for (int i = 0; i < length; i++) {
                int digit = (arr[i] / divisor) % 10;
                insertIntoBin(bins, digit, arr[i]);
            }

            // Gather elements back from bins into the original array
            int i = 0, k = 0;
            while (i < bins.length) {
                if (bins[i] != null) {
                    arr[k++] = deleteFromBin(bins, i);
                } else {
                    i++;
                }
            }

            // Move to the next digit position
            divisor *= 10;
        }
    }

    /**
     * Inserts an element into the appropriate bin in the radix bucket.
     *
     * @param bins  The array of radix bins.
     * @param digit The digit used to determine the bin.
     * @param value The value to be inserted.
     */
    private void insertIntoBin(Node[] bins, int digit, int value) {
        if (bins[digit] == null) {
            bins[digit] = new Node(value, null);
        } else {
            Node newNode = new Node(value, null);
            Node currentNode = bins[digit];
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
