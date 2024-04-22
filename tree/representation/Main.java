package tree.representation;

public class Main {

    public static void main(String[] args) {
        /*
         * BinaryTree<String> tree = new BinaryTree<>(5);
         * 
         * tree.addRoot("Amman");
         * 
         * tree.addLeftChild(0, "Irbid");
         * tree.addRightChild(0, "AL-zarqa");
         * 
         * tree.addLeftChild(1, "Al-Mafraq");
         * tree.addRightChild(1, "Aqaba");
         * 
         * tree.addLeftChild(2, "Jarash");
         * tree.addRightChild(2, "Madaba");
         * 
         * tree.display();
         * 
         * tree.postOrderRecursive(0);
         * System.out.println();
         * tree.postOrderIterative(0);
         * System.out.println();
         * tree.postOrderIterativeUsingTwoStack(0);
         */
        BinaryTreeLinkedList bt = new BinaryTreeLinkedList();
        bt.createBinaryTree();

    }
}
