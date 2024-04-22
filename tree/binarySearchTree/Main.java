package tree.binarySearchTree;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();

        /* bst.createBST(); */

        int a[] = { -9, -3, 2, 4, 4, 0, -6, -5 };

        for (int i : a) {
            bst.addElementRecursive(bst.getRoot(), i);
        }

        System.out.println("maximum Depth is: " + bst.maxDepth(bst.getRoot()));
        System.out.println("Minimum Depth is: " + bst.minDepth(bst.getRoot()));
        bst.inOrder(bst.getRoot());

    }
}
