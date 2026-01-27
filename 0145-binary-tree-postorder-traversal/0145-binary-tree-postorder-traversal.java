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
    ArrayList<Integer> post_order = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return post_order;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        post_order.add(root.val);

        return post_order;
    }
}