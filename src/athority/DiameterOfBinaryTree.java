package athority;

/*
    543. 二叉树的直径
    给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
    这条路径可能穿过根结点。

    示例 :
    给定二叉树

              1
             / \
            2   3
           / \
          4   5
    返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

    注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);

        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;

    }
}
/*  2.
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;

        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);

        return Math.max(L, R) + 1;
    }
 */
/*  1.
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
         ans = 1;
        depth(root);
        return ans - 1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;   //空节点，可以直接知道它的空节点为0
        }
        //计算左右节点的深度
        int L = depth(root.left);
        int R = depth(root.right);

        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */