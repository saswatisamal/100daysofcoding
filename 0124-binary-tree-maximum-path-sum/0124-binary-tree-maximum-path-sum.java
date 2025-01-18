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
    public int maxPathSum(TreeNode root) {
   int[] maximum= new int[1];
   maximum[0]=Integer.MIN_VALUE;
    maxPathValue(root,maximum);
    return maximum[0];   
    }
    private int maxPathValue(TreeNode root,int[] maximum){
        if(root==null) return 0;
        int leftSum=Math.max(0,maxPathValue(root.left,maximum));
        int rightSum=Math.max(0,maxPathValue(root.right,maximum));
        maximum[0]=Math.max(maximum[0],root.val+leftSum+rightSum);
        return Math.max(leftSum,rightSum)+root.val;

    }
}