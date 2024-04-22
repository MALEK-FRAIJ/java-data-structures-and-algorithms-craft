package tree.representation;

import java.util.Queue;
import java.util.Scanner;

import java.util.Stack;

import java.util.LinkedList;

/**
 * Represents a binary tree using linked nodes.
 */

public class BinaryTreeLinkedList {

    /**
     * Reference to the root node of the tree
     */
    private Node root;
    /**
     * Queue used for tree traversal or operations
     */
    private Queue<Node> queue;
    /**
     * Tracks the number of nodes in the tree
     */
    private int size = 0;

    /**
     * Scanner object for user input
     */
    private Scanner scan;

    private Stack<Node> stack;

    /**
     * Constructs a BinaryTreeLinkedList object.
     * Initializes a queue using LinkedList and a Scanner for user input.
     */
    BinaryTreeLinkedList() {
        queue = new LinkedList<>(); // Initializes a queue using LinkedList
        scan = new Scanner(System.in); // Initializes a Scanner for user input
        stack = new Stack<>();
    }

    /**
     * Retrieves the index of the root node in the binary tree.
     *
     * @return The index of the root node.
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Checks if the binary tree is empty.
     *
     * @return True if the binary tree is empty, otherwise false.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Retrieves the current size of the binary tree.
     *
     * @return The current size of the binary tree.
     */
    public int size() {
        return size;
    }

    /**
     * Adds a root node with the given element to the tree.
     * 
     * @param element The element to be added as the root node.
     */
    private void addRoot(char element) {
        Node newNode = new Node(null, element, null);
        queue.offer(newNode);
        root = newNode;
        size++;
    }

    /**
     * Adds a left child node with the given element to the specified root node.
     * 
     * @param element The element to be added as the left child node.
     * @param root    The root node where the left child will be added.
     */
    private void leftChild(char element, Node root) {
        Node newNode = new Node(null, element, null);
        queue.offer(newNode);
        root.prev = newNode;
        size++;
    }

    /**
     * Adds a right child node with the given element to the specified root node.
     * 
     * @param element The element to be added as the right child node.
     * @param root    The root node where the right child will be added.
     */
    private void rightChild(char element, Node root) {
        Node newNode = new Node(null, element, null);
        queue.offer(newNode);
        root.next = newNode;
        size++;
    }

    /**
     * Creates a root node for the binary tree by taking user input.
     * 
     * Prompts the user to enter the value for the root node of the binary tree.
     * Uses the entered value to add a root node to the tree.
     */
    public void createRootNode() {
        System.out.print("Enter the Root of Binary Tree: ");
        char a = scan.next().charAt(0);
        addRoot(a);
    }

    /**
     * Creates a left child node for the specified parent node.
     * 
     * Prompts the user to enter the value for the left child node of the specified
     * parent node.
     * If the entered value is not '-', it adds a left child node with the entered
     * value to the parent node.
     * 
     * @param temp The parent node for which the left child node will be created.
     */
    private void createLeftNode(Node temp) {
        System.out.print("Enter left Child(" + temp.data + ") : ");
        char a = scan.next().charAt(0);
        if (a != '-') {
            leftChild(a, temp);
        }
    }

    /**
     * Creates a right child node for the specified parent node.
     * 
     * Prompts the user to enter the value for the right child node of the specified
     * parent node.
     * If the entered value is not '-', it adds a right child node with the entered
     * value to the parent node.
     * 
     * @param temp The parent node for which the right child node will be created.
     */
    private void createRightNode(Node temp) {
        System.out.print("Enter Right Child(" + temp.data + ") : ");
        char a = scan.next().charAt(0);
        if (a != '-') {
            rightChild(a, temp);
        }
    }

    /**
     * Creates a binary tree by taking user input to construct nodes and their
     * connections.
     * 
     * The method initiates by creating the root node through user input.
     * Then, it iterates using a queue to prompt for and create left and right child
     * nodes for each existing node in the tree.
     * The process continues until the queue is empty, indicating that all possible
     * nodes have been added.
     * Finally, it closes the scanner used for input.
     */
    public void createBinaryTree() {
        createRootNode();
        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            createLeftNode(temp);
            createRightNode(temp);
        }
        scan.close();
    }

    /**
     * Performs a pre-order traversal starting from the specified root node.
     *
     * Traverses the binary tree in a pre-order fashion: root, left subtree, right
     * subtree.
     * Prints the data of each node visited during the traversal.
     *
     * @param root The root node of the subtree to be traversed.
     */
    public void preOrder(Node root) {

        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.prev);
            preOrder(root.next);
        }
    }

    /**
     * Performs an in-order traversal starting from the specified root node.
     * 
     * Traverses the binary tree in an in-order fashion: left subtree, root, right
     * subtree.
     * Prints the data of each node visited during the traversal.
     * 
     * @param root The root node of the subtree to be traversed.
     */
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.prev);
            System.out.print(root.data + " ");
            inOrder(root.next);
        }
    }

    /**
     * Performs a post-order traversal starting from the specified root node.
     *
     * Traverses the binary tree in a post-order fashion: left subtree, right
     * subtree, root.
     * Prints the data of each node visited during the traversal.
     *
     * @param root The root node of the subtree to be traversed.
     */
    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.prev);
            postOrder(root.next);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Performs a pre-order traversal of the binary tree using a stack.
     * 
     * Traverses the binary tree in pre-order fashion iteratively using a stack.
     * Prints the data of each node visited during the traversal.
     */
    public void preOrderStack() {
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                System.out.print(temp.data + " ");
                stack.push(temp);
                temp = temp.prev;
            } else {
                temp = stack.pop();
                temp = temp.next;
            }
        }
    }

    /**
     * Performs an in-order traversal of the binary tree using a stack.
     * 
     * Traverses the binary tree in in-order fashion iteratively using a stack.
     * Prints the data of each node visited during the traversal.
     */
    public void inOrderStack() {
        Node temp = root;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.prev;
            } else {
                temp = stack.pop();
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }

    }

    /**
     * Performs a post-order traversal of the binary tree using stacks.
     * 
     * Traverses the binary tree in post-order fashion iteratively using stacks.
     * Prints the data of each node visited during the traversal.
     */
    public void postOrderStack() {
        Node temp = root;
        stack.push(temp);
        Stack<Node> output = new Stack<>();
        while (!stack.isEmpty()) {
            temp = stack.pop();
            output.push(temp);

            if (temp.prev != null) {
                stack.push(temp.prev);
            }
            if (temp.next != null) {
                stack.push(temp.next);
            }
        }

        while (!output.isEmpty()) {
            System.out.print(output.pop().data + " ");
        }

    }

    /**
     * Performs a level-order traversal of the binary tree using a queue.
     * 
     * Traverses the binary tree in level-order (breadth-first) fashion using a
     * queue.
     * Prints the data of each node visited during the traversal.
     */
    public void levelOrder() {
        Node temp = root;
        queue.offer(temp);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.prev != null) {
                queue.offer(temp.prev);
            }
            if (temp.next != null) {
                queue.offer(temp.next);
            }
            System.out.print(temp.data + " ");
        }
    }

    /**
     * Calculates the number of generating trees given the number of nodes.
     *
     * @param nodes The number of nodes in the tree.
     * @return The number of generating trees.
     */
    public int numberOfGeneratingTrees(int nodes) {
        if (checkNode(nodes)) {
            int numerator = factorial(nodes * 2, nodes);
            int denominator = factorial(nodes, 1);
            return numerator / denominator / (nodes + 1);
        }
        return -1;
    }

    /**
     * Checks if the specified number of nodes is valid for generating a tree.
     * 
     * @param nodes The number of nodes intended for the tree
     * @return True if the number of nodes is valid, otherwise False
     */
    private boolean checkNode(int nodes) {
        if (nodes <= 0) {
            System.out.println("A tree cannot be generated because there are no nodes");
            return false;
        }
        return true;
    }

    /**
     * Calculates the factorial of a number within a specified range.
     *
     * @param fact The number for which factorial needs to be calculated.
     * @param end  The end of the range for factorial calculation.
     * @return The factorial of the specified number within the given range.
     */
    public int factorial(int fact, int end) {
        if (fact <= end) {
            return 1;
        }
        return fact * factorial(fact - 1, end);
    }

    /**
     * Checks if two binary trees are identical.
     *
     * @param p The root of the first tree.
     * @param q The root of the second tree.
     * @return True if both trees are identical, false otherwise.
     */
    public boolean isSameTree(Node p, Node q) {
        // If both nodes are null, they are equal
        if (p == null && q == null) {
            return true;
        }

        // If one node is null or their values are different, they are not equal
        if (p == null || q == null || p.data != q.data) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(p.prev, q.prev) && isSameTree(p.next, q.next);
    }

    /**
     * A method to check if a binary tree is symmetric.
     * 
     * @param root The root node of the binary tree.
     * @return True if the binary tree is symmetric, false otherwise.
     */
    public boolean isSymmetric(Node root) {

        if (root == null)
            return false;

        return isMirror(root.prev, root.next);
    }

    /**
     * A helper method to check if two subtrees are mirrors of each other.
     * 
     * @param rootLeft  The root node of the left subtree.
     * @param rootRight The root node of the right subtree.
     * @return True if the subtrees are mirrors of each other, false otherwise.
     */
    private boolean isMirror(Node rootLeft, Node rootRight) {
        if (rootLeft == null && rootRight == null)
            return true;

        if (rootLeft == null || rootRight == null || rootLeft.data != rootRight.data)
            return false;

        return isMirror(rootLeft.prev, rootRight.next) && isMirror(rootLeft.next, rootRight.prev);
    }

    /**
     * Recursively counts the number of nodes in a binary tree starting from the
     * given root node.
     * 
     * @param root The root node of the binary tree
     * @return The total count of nodes in the binary tree
     */
    public int nodeCount(Node root) {
        int left, right;
        while (root != null) {
            left = nodeCount(root.prev);
            right = nodeCount(root.next);
            return left + right + 1;
        }
        return 0;
    }

    /**
     * Recursively calculates the sum of the data values of all nodes in a binary
     * tree,
     * including the given root node and its children.
     * 
     * @param root The root node of the binary tree
     * @return The sum of the data values of all nodes in the binary tree
     */
    public int sumOfChild(Node root) {
        if (root != null) {
            return root.data + sumOfChild(root.prev) + sumOfChild(root.next);
        }
        return 0;
    }

    /**
     * A method to count the number of leaf nodes in a binary tree.
     * 
     * @param root The root node of the binary tree.
     * @return The number of leaf nodes in the binary tree.
     */
    public int countLeafNode(Node root) {

        if (root == null)
            return 0;

        int left = countLeafNode(root.prev);
        int right = countLeafNode(root.next);

        if (root.prev == null && root.next == null)
            return 1;

        return left + right;
    }

    /**
     * Counts the number of leaf nodes in the binary tree starting from the root
     * node.
     * method 2
     * 
     * @return The count of leaf nodes in the binary tree
     */
    public int countLeafNodes() {
        return countLeafNodesRec(root);
    }

    /**
     * Recursively counts the number of leaf nodes in a binary tree starting from
     * the given root node.
     * 
     * @param root The root node of the binary tree
     * @return The count of leaf nodes in the binary tree
     */
    private int countLeafNodesRec(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.prev == null && root.next == null) {
            return 1;
        } else {
            return countLeafNodesRec(root.prev) + countLeafNodesRec(root.next);
        }
    }

    /**
     * Calculate the maximum depth of a binary tree.
     *
     * @param root The root node of the binary tree
     * @return The maximum depth of the binary tree rooted at the given node
     */
    public int maxDepth(Node root) {

        if (root != null) {
            int left = maxDepth(root.prev);
            int right = maxDepth(root.next);

            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }
        }

        return 0;
    }

    /**
     * Calculate the maximum depth of a binary tree recursively.
     *
     * @param root The root node of the binary tree
     * @return The maximum depth of the binary tree rooted at the given node
     */
    public int maxDepthRec(Node root) {
        if (root == null) {
            return 0;
        }
        // Recursively calculate the maximum depth of the left and right subtrees,
        // then return the maximum depth among them plus 1 (for the current node).
        return Math.max(maxDepthRec(root.prev), maxDepthRec(root.next)) + 1;
    }

    /**
     * A method to calculate the number of nodes in a binary tree that have both
     * left and right children as non-null,
     * where each node has a degree of two.
     * 
     * @param root The root node of the binary tree.
     * @return The number of nodes with degree of two in the binary tree.
     */
    public int countDegreeTwo(Node root) {

        if (root == null)
            return 0;

        int left = countDegreeTwo(root.prev);
        int right = countDegreeTwo(root.next);

        if (root.prev != null && root.next != null)
            return left + right + 1;
        else
            return left + right;
    }

    /**
     * A method to count the number of nodes in a binary tree that have at least one
     * non-null child.
     * 
     * @param root The root node of the binary tree.
     * @return The number of nodes with at least one non-null child in the binary
     *         tree.
     */
    public int countDegreeOneOrTwo(Node root) {

        if (root == null)
            return 0;

        // Recursive calls to count the number of nodes with at least one non-null child
        // in the left and right subtrees
        int left = countDegreeOneOrTwo(root.prev);
        int right = countDegreeOneOrTwo(root.next);

        if (root.prev != null || root.next != null)
            return left + right + 1;
        else
            return left + right;

    }

    /**
     * A method to count the number of nodes in a binary tree that have exactly one
     * non-null child.
     * 
     * @param root The root node of the binary tree.
     * @return The number of nodes with exactly one non-null child in the binary
     *         tree.
     */
    public int countDegreeOne(Node root) {
        // Base case: If the root is null, return 0
        if (root == null)
            return 0;

        int left = countDegreeOne(root.prev);
        int right = countDegreeOne(root.next);

        // Check if the current node has exactly one non-null child using XOR operator
        if (root.prev != null ^ root.next != null)
            return left + right + 1;
        else
            return left + right;

    }

    /**
     * Represents a node in a binary tree.
     */
    static class Node {
        Node prev; // Reference to the previous (left) child node
        char data; // Data contained within the node
        Node next; // Reference to the next (right) child node

        /**
         * Constructs a node with the given data and references to the previous and next
         * nodes.
         *
         * @param prev The previous (left) child node.
         * @param data The data to be stored in the node.
         * @param next The next (right) child node.
         */
        Node(Node prev, char data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

}
