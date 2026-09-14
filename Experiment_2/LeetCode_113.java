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
class Solution {
    void solve(TreeNode root, int currSum, int targetSum, List<Integer> temp, List<List<Integer>> res) {
        if (root == null)
            return;
        temp.add(root.val);
        if (root.left == null && root.right == null && currSum + root.val == targetSum) {
            res.add(new ArrayList<>(temp));
        }
        solve(root.left, currSum + root.val, targetSum, temp, res);
        solve(root.right, currSum + root.val, targetSum, temp, res);
        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }
}
