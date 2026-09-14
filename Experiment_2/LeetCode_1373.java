/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair {
    int mx;
    int mn;
    int sum;
    int maxSum;
    boolean isBST;

    Pair(int mx, int mn, int sum, int maxSum, boolean isBST) {
        this.mx = mx;
        this.mn = mn;
        this.sum = sum;
        this.maxSum = maxSum;
        this.isBST = isBST;
    }
}

class Solution {
    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, true);
        }
        Pair lf = solve(root.left);
        Pair rt = solve(root.right);
        if (lf.isBST && rt.isBST && lf.mx < root.val && rt.mn > root.val) {
            int currSum = lf.sum + rt.sum + root.val;
            int maxSum = Math.max(currSum, Math.max(lf.maxSum, rt.maxSum));
            return new Pair(Math.max(root.val, rt.mx), Math.min(root.val, lf.mn), currSum, maxSum, true);
        }
        return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, Math.max(lf.maxSum, rt.maxSum), false);
    }

    public int maxSumBST(TreeNode root) {
        Pair res = solve(root);
        return res.maxSum;
    }
}
