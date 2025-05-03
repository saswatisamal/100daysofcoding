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
    public int maxDepth(TreeNode root) {
        List<Integer> im= new ArrayList();
        int[] height= new int[1];
        heightOfBT(root,im,height);
        return height[0];
    }

    public void heightOfBT(TreeNode root,List<Integer> intermediate,int[] height){
       if (root == null) return;
        intermediate.add(root.val);
        if (root.left == null && root.right == null) {
            height[0] = Math.max(height[0], intermediate.size());
        } else {
            heightOfBT(root.left, intermediate, height);
            heightOfBT(root.right, intermediate, height);
        }
        intermediate.remove(intermediate.size() - 1);
    }
}