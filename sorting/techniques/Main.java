package sorting.techniques;

public class Main {

    public static void main(String[] args) {
        Runtime runtime = new Runtime();
        Sorting sort = new Sorting();

        int[] arr = { 237, 146, 235, 348, 152, 163, 235, 48, 36, 62 };
        int size = arr.length;

        System.out.println("Starting...");
        runtime.start();

        sort.radixSort(arr, size);
        sort.display(arr);

        runtime.stop();
        runtime.display();
    }
}
