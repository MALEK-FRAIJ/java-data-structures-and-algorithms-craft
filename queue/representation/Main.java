package queue.representation;

public class Main {

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();

        for (int i = 1; i <= 5; i++) {
            priorityQueue.offer(10 * i);
        }

        priorityQueue.display();
    }

}
