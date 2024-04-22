package hashing.representation;

/* import java.util.Random; */

public class Main {

    public static void main(String[] args) {

        /*
         * Random random = new Random();
         * Chaining hashMap = new Chaining();
         * int low = 59900;
         * int high = 60000;
         * 
         * for (int i = 0; i < 25; i++) {
         * int randomNumber = random.nextInt(high - low) + low;
         * hashMap.insert(randomNumber);
         * }
         * System.out.println("****************");
         * 
         * hashMap.display();
         * System.out.println("****************");
         * for (int i = 0; i < 5; i++) {
         * int randomNumber = random.nextInt(high - low) + low;
         * System.out.println("The Number " + randomNumber + " is: " +
         * hashMap.search(randomNumber));
         * }
         * System.out.println("****************");
         * for (int j = 0; j < 4; j++) {
         * int randomNumber = random.nextInt(high - low) + low;
         * System.out.println("The Number " + hashMap.remove(randomNumber) +
         * " removed...");
         * }
         * System.out.println("******** ********");
         * hashMap.display();
         */

        Map<Integer, String> map = new Map<Integer, String>();

        map.add(1, "Geeks");

        map.printMap();

        map.add(2, "forGeeks");
        map.printMap();

        map.add(3, "A");
        map.printMap();

        map.add(4, "Computer");
        map.printMap();

        map.add(5, "Portal");
        map.printMap();

    }
}