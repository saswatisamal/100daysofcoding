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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result= new ArrayList();
        preOrderTreeTraversal(root,result);
        return result;
    }
    private void preOrderTreeTraversal(TreeNode root,List<Integer> result){
      if(root==null) return;
      result.add(root.val);
      preOrderTreeTraversal(root.left,result);
      preOrderTreeTraversal(root.right,result);
    }
}