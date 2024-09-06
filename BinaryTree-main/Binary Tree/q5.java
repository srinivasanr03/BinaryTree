class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class q5 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right subtrees
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        q5 solution = new q5();
        
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println("Original tree (pre-order):");
        solution.preOrderTraversal(root);
        System.out.println();

        TreeNode mirroredRoot = solution.mirrorTree(root);

        System.out.println("Mirror tree (pre-order):");
        solution.preOrderTraversal(mirroredRoot);
    }
}
