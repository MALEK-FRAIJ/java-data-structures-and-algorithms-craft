package tree.representation;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import java.util.ArrayList;

/**
 * A class representing a binary tree with an array-based implementation.
 * 
 * @param <T> The type of elements in the tree.
 */
public class BinaryTree<T> {

    /**
     * Default initial capacity of the array
     */
    private int initialCapacity = 10;
    /**
     * nodes is a Array to hold the elements of the tree
     */
    private T[] nodes;

    /**
     * size is a Number of elements currently in the tree
     */
    private int size;

    /**
     * Constructs a binary tree with the default initial capacity.
     */
    @SuppressWarnings("unchecked")
    BinaryTree() {
        this.nodes = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Constructs a binary tree with a specified initial capacity.
     * 
     * @param initialCapacity The initial capacity of the binary tree.
     */
    @SuppressWarnings("unchecked")
    BinaryTree(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.nodes = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Gets the initial capacity of the binary tree.
     * 
     * @return The initial capacity of the binary tree.
     */
    public int getInitialCapacity() {
        return initialCapacity;
    }

    /**
     * Gets the number of elements in the binary tree.
     * 
     * @return The number of elements in the binary tree.
     */
    public int size() {
        return size;
    }

    /**
     * A class representing a binary tree with an array-based implementation.
     * 
     * @param <T> The type of elements in the tree.
     */
    public void addRoot(T root) {
        nodes[0] = root;
        size++;
    }

    /**
     * Adds a left child to the specified node.
     * 
     * @param root    The index of the parent node.
     * @param element The element to be added as the left child.
     */
    public void addLeftChild(int root, T element) {
        int left = (root * 2) + 1;
        if (nodes[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", left);
            return;
        }
        if (left >= nodes.length) {
            grow();
        }
        nodes[left] = element;
        size++;
    }

    /**
     * Adds a right child to the specified node.
     * 
     * @param root    The index of the parent node.
     * @param element The element to be added as the right child.
     */
    public void addRightChild(int root, T element) {
        int right = (root * 2) + 2;
        if (nodes[root] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", right);
            return;
        }
        if (right >= nodes.length) {
            grow();
        }
        nodes[right] = element;
        size++;
    }

    /**
     * Increases the capacity of the underlying array when it's full.
     */
    private void grow() {
        initialCapacity *= 2;
        T[] newNodes = Arrays.copyOf(nodes, initialCapacity);
        nodes = newNodes;
    }

    /**
     * Displays the elements of the array in a formatted string.
     * Elements are separated by commas and enclosed within square brackets.
     */
    public void display() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < nodes.length; i++) {
            sb.append(nodes[i]);
            if (i < nodes.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }

    /**
     * Retrieves the parent element of the node at the specified index.
     * 
     * @param index The index of the node for which to find the parent.
     * @return The parent element of the node.
     * @throws IllegalArgumentException if the index is invalid or if the parent is
     *                                  not found.
     */
    public T getParent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Root node has no parent");
        }
        int parentIndex = (index / 2) - 1;

        if (parentIndex < 0 || parentIndex >= initialCapacity) {
            throw new IllegalArgumentException("Invalid index: " + index);
        }
        return nodes[parentIndex];
    }

    /**
     * Performs a recursive in-order traversal starting from the given index.
     *
     * @param index The index of the current node.
     */
    public void inOrderRecursive(int index) {
        if (index < initialCapacity && nodes[index] != null) {
            inOrderRecursive(index * 2 + 1);
            System.out.print(nodes[index] + " ");
            inOrderRecursive(index * 2 + 2);
        }

    }

    /**
     * Performs iterative in-order traversal on a binary tree starting from the
     * given index.
     * Prints the values of the nodes visited in in-order.
     *
     * @param index The index of the root node of the binary tree to start traversal
     *              from.
     */
    public void inOrderIterative(int index) {

        if (index >= initialCapacity || index < 0)
            return;

        Stack<Integer> stack = new Stack<>();

        while (index < initialCapacity || !stack.isEmpty()) {

            if (index < initialCapacity && nodes[index] != null) {
                stack.push(index);
                index = (index * 2) + 1;
            } else {
                index = stack.pop();
                System.out.print(nodes[index] + " ");
                index = (index * 2) + 2;
            }
        }
    }

    /**
     * Performs a recursive post-order traversal starting from the given index.
     *
     * @param index The index of the current node.
     */
    public void postOrderRecursive(int index) {
        if (index < initialCapacity && nodes[index] != null) {
            postOrderRecursive(index * 2 + 1);
            postOrderRecursive(index * 2 + 2);
            System.out.print(nodes[index] + " ");
        }
    }

    /**
     * Performs a recursive pre-order traversal starting from the given index.
     *
     * @param index The index of the current node.
     */
    public void preOrderRecursive(int index) {
        if (index < initialCapacity && nodes[index] != null) {
            System.out.print(nodes[index] + " ");
            preOrderRecursive((index * 2) + 1);
            preOrderRecursive((index * 2) + 2);
        }
    }

    /**
     * Performs iterative pre-order traversal on a binary tree starting from the
     * given index.
     * Prints the values of the nodes visited in pre-order.
     *
     * @param index The index of the root node of the binary tree to start traversal
     *              from.
     */
    public void preOrderIterative(int index) {

        if (index >= initialCapacity || index < 0)
            return;

        Stack<Integer> stack = new Stack<>();

        while (index < initialCapacity || !stack.isEmpty()) {

            if (index < initialCapacity && nodes[index] != null) {
                System.out.print(nodes[index] + " ");
                stack.push(index);
                index = (index * 2) + 1;
            } else {
                index = stack.pop();
                index = (index * 2) + 2;
            }
        }
    }

    /**
     * Performs iterative pre-order traversal on a binary tree starting from the
     * given index
     * using a stack in reverse order.
     * Prints the values of the nodes visited in pre-order.
     *
     * @param index The index of the root node of the binary tree to start traversal
     *              from.
     */
    public void preOrderReverseStack(int index) {

        if (index >= initialCapacity || index < 0)
            return;

        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            index = stack.pop();
            System.out.print(nodes[index] + " ");

            int rightChild = index * 2 + 2;
            int leftChild = index * 2 + 1;

            if (rightChild < initialCapacity && nodes[rightChild] != null)
                stack.push(rightChild);
            if (leftChild < initialCapacity && nodes[leftChild] != null)
                stack.push(leftChild);
        }
    }

    /**
     * Perform iterative post-order traversal starting from the given index.
     *
     * @param index The index to start the traversal from
     */
    public void postOrderIterative(int index) {
        if (index >= initialCapacity || index < 0)
            return;

        Stack<Integer> stack = new Stack<>();

        while (index < initialCapacity || !stack.isEmpty()) {

            if (index < initialCapacity && nodes[index] != null) {
                stack.push(index);
                index = index * 2 + 1;
            } else {
                index = stack.pop();
                if (index > 0) {
                    stack.push(-index);
                    index = index * 2 + 2;
                } else if (index == 0) {
                    index = index * 2 + 2;
                } else {
                    System.out.print(nodes[-index] + " ");
                    index = Integer.MAX_VALUE;
                }
            }
        }
        System.out.print(nodes[0]);
    }

    /**
     * Perform iterative post-order traversal using two stacks, starting from the
     * given index.
     *
     * @param index The index to start the traversal from
     */
    public void postOrderIterativeUsingTwoStack(int index) {
        List<T> list = new ArrayList<>();
        if (index >= initialCapacity || index < 0)
            return;

        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        while (!stack.isEmpty()) {
            index = stack.pop();
            list.add(0, nodes[index]);

            int left = (index * 2) + 1;
            int right = (index * 2) + 2;
            if (left < initialCapacity && nodes[left] != null) {
                stack.push(left);
            }
            if (right < initialCapacity && nodes[right] != null) {
                stack.push(right);
            }
        }
        System.out.println(list);
    }

}
