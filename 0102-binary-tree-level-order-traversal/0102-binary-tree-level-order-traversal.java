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
    public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> ans= new ArrayList();
        if(root==null){
          return ans;
        } 
         Queue<TreeNode> q= new LinkedList();
         q.add(root);
         while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level= new ArrayList();
           for(int i=0;i<size;i++){
            TreeNode item= q.poll();
            level.add(item.val);
            if(item.left!=null){
                q.add(item.left);
            }
            if(item.right!=null){
                q.add(item.right);
            }
        }
         ans.add(level);
        }
       return ans;
}
}