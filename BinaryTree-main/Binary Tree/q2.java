import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class q2 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reachedNull = false;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                reachedNull = true;
            } else {
                if (reachedNull) {
                    return false; // Non-null node after a null node indicates incompleteness
                }
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        q2 solution = new q2();
        
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        
        System.out.println("Is the binary tree complete? " + solution.isCompleteTree(root));
    }
}
