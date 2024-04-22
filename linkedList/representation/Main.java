package linkedList.representation;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(8);
        list.add(6);
        list.add(3);
        list.add(81);
        list.add(61);
        list.add(31);

        System.out.println(list.middleNode().data);

    }
}
