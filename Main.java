import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        TreeNode temp = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            int v = 0;
            temp = queue.poll();
            if (temp.left != null) {
                v++;
                queue.offer(temp);
            }
            if (temp.right != null) {
                queue.offer(temp);
                v++;
            }
            if (v % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public int sumRootToLeaf(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return root.val + sumRootToLeaf(root.left) + sumRootToLeaf(root.right);
    }
}

public class Main {

    public static void main(String[] args) {

    }
}
