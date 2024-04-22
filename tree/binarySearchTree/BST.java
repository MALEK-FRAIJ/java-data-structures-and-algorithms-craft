package tree.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BST represents a binary search tree and provides methods for basic
 * operations.
 */
public class BST {

    /**
     * The root node of the binary search tree.
     */
    private TreeNode root;

    /**
     * The number of elements in the binary search tree.
     */
    private int size = 0;

    /**
     * A queue used for various tree operations.
     */
    private Queue<TreeNode> queue;

    /**
     * A Scanner object for user input.
     */
    private Scanner scan;

    /**
     * Constructor for BinarySearchTree.
     */
    BST() {
        this.scan = new Scanner(System.in);
    }

    /**
     * Returns the number of elements in the binary search tree.
     *
     * @return The size of the binary search tree.
     */
    public int size() {
        return size;
    }

    /**
     * Retrieves the root node of the binary search tree.
     *
     * @return The root node of the binary search tree.
     */
    public TreeNode getRoot() {
        return root;
    }

    /**
     * Checks if the binary search tree is empty.
     *
     * @return true if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Adds a single root to the binary search tree with the specified element.
     *
     * @param element The element to set as the root.
     */
    public void addSingleRoot(int element) {
        this.root = new TreeNode(null, element, null);
        size++;
    }

    /**
     * Adds the root of the binary search tree based on user input.
     *
     * @param element The element to add as the root.
     * @param queue   The queue to store nodes for level-order traversal.
     */
    private void addRoot(int element, Queue<TreeNode> queue) {
        TreeNode newNode = new TreeNode(null, element, null);
        queue.offer(newNode);
        root = newNode;
        size++;
    }

    /**
     * Adds the left child of the given node based on user input.
     *
     * @param element The element to add as the left child.
     * @param root    The parent node.
     * @param queue   The queue to store nodes for level-order traversal.
     */
    private void addLeftChild(int element, TreeNode root, Queue<TreeNode> queue) {
        TreeNode newNode = new TreeNode(null, element, null);
        queue.offer(newNode);
        root.left = newNode;
        size++;
    }

    /**
     * Adds the right child of the given node based on user input.
     *
     * @param element The element to add as the right child.
     * @param root    The parent node.
     * @param queue   The queue to store nodes for level-order traversal.
     */
    private void addRightChild(int element, TreeNode root, Queue<TreeNode> queue) {
        TreeNode newNode = new TreeNode(null, element, null);
        queue.offer(newNode);
        root.right = newNode;
        size++;
    }

    /**
     * Adds the root of the binary search tree based on user input.
     *
     * @param queue The queue to store nodes for level-order traversal.
     */
    public void addInputRoot(Queue<TreeNode> queue) {
        System.out.print("Enter the Root of Binary Search Tree: ");
        int element = scan.nextInt();
        addRoot(element, queue);
    }

    /**
     * Adds the left child of the given node based on user input.
     *
     * @param root  The parent node.
     * @param queue The queue to store nodes for level-order traversal.
     */
    private void addInputLeftChild(TreeNode root, Queue<TreeNode> queue) {
        System.out.print("Enter left Child(" + root.data + ") : ");
        int element = scan.nextInt();
        if (element == -1) {
            return;
        } else if (!checkElement(element, root)) {
            addLeftChild(element, root, queue);
        } else {
            System.out.println("The element (" + element + ") is greater than or equal the root (" + root.data
                    + ")\n please agin Enter the input...");
            addInputLeftChild(root, queue);
        }
    }

    /**
     * Adds the right child of the given node based on user input.
     *
     * @param root  The parent node.
     * @param queue The queue to store nodes for level-order traversal.
     */
    private void addInputRightChild(TreeNode root, Queue<TreeNode> queue) {
        System.out.print("Enter Right Child(" + root.data + ") : ");
        int element = scan.nextInt();
        if (element == -1) {
            return;
        } else if (checkElement(element, root)) {
            addRightChild(element, root, queue);
        } else {
            System.out.println("The element (" + element + ") is less than or equal the root (" + root.data
                    + ")\n please agin Enter the input...");
            addInputRightChild(root, queue);
        }
    }

    /**
     * Checks if the given element is greater than the data in the root node.
     *
     * @param element The element to check.
     * @param root    The root of the binary search tree.
     * @return true if the element is greater than the root's data, false otherwise.
     */
    public boolean checkElement(int element, TreeNode root) {
        if (element == root.data) {
            return false;
        }
        return element > root.data;
    }

    /**
     * Constructs a binary search tree based on user input using level-order
     * traversal.
     */
    public void createBST() {
        TreeNode temp;
        queue = new LinkedList<>();
        addInputRoot(queue);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            addInputLeftChild(temp, queue);
            addInputRightChild(temp, queue);
        }
        scan.close();
    }

    /**
     * Performs an in-order traversal of the binary search tree.
     * In-order traversal visits the left subtree, then the current node, and
     * finally the right subtree.
     *
     * @param root The root of the binary search tree.
     */
    public void inOrder(TreeNode root) {

        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * Recursively searches for an element in the binary search tree.
     *
     * @param root    The root of the binary search tree.
     * @param element The element to search for.
     * @return The TreeNode containing the element, or null if not found.
     */
    public TreeNode binarySearchTree(TreeNode root, int element) {
        if (root == null)
            return null;
        if (root.data == element)
            return root;

        return element > root.data ? binarySearchTree(root.right, element) : binarySearchTree(root.left, element);
    }

    /**
     * Searches for an element in the binary search tree using a loop.
     *
     * @param root    The root of the binary search tree.
     * @param element The element to search for.
     * @return The TreeNode containing the element, or null if not found.
     */
    public TreeNode binarySearchTreeUsingLoop(TreeNode root, int element) {
        while (root != null) {
            if (element == root.data)
                return root;
            else if (element > root.data)
                root = root.right;
            else
                root = root.left;
        }
        return null;
    }

    /**
     * Adds an element to the binary search tree iteratively.
     *
     * @param root    The root of the binary search tree.
     * @param element The element to be added.
     */
    public void addElement(TreeNode root, int element) {
        TreeNode temp = null;
        TreeNode newNode = new TreeNode(null, element, null);
        while (root != null) {
            temp = root;
            if (element == root.data)
                return;
            else if (element < root.data)
                root = root.left;
            else
                root = root.right;
        }

        if (temp == null)
            this.root = newNode;
        else if (element < temp.data)
            temp.left = newNode;
        else
            temp.right = newNode;
        size++;

    }

    /**
     * Adds an element to the binary search tree recursively.
     *
     * @param root    The root of the binary search tree.
     * @param element The element to be added.
     * @return The root of the modified binary search tree.
     */
    public TreeNode addElementRecursive(TreeNode root, int element) {
        if (root == null) {
            TreeNode newNode = new TreeNode(null, element, null);
            if (this.root == null) {
                // If the tree is empty, set the new node as the root
                this.root = newNode;
            }
            size++;
            return newNode;
        }

        if (element < root.data) {
            root.left = addElementRecursive(root.left, element);
        } else {
            root.right = addElementRecursive(root.right, element);
        }

        return root;
    }

    /**
     * Calculates the maximum depth of a binary tree.
     *
     * @param root The root of the binary tree.
     * @return The maximum depth of the binary tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (leftDepth == 0 || rightDepth == 0)
            return Math.max(leftDepth, rightDepth) + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * TreeNode represents a node in a binary tree.
     */
    static class TreeNode {
        TreeNode left; // Reference to the left child node.
        int data; // Data stored in the node.
        TreeNode right; // Reference to the right child node.

        /**
         * Constructs a new TreeNode with the given left and right children and data.
         *
         * @param left  The left child node.
         * @param data  The data stored in the node.
         * @param right The right child node.
         */
        TreeNode(TreeNode left, int data, TreeNode right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
    }

}
