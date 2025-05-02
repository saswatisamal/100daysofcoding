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

 class Pair{
      TreeNode key;
      int value;
      public Pair(TreeNode key, int value){
        this.key=key;
        this.value=value;
      }

 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
      if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            int min=q.peek().value;
            int first=0,last=0;
            for(int i =0;i<size;i++){
                TreeNode node = q.peek().key;
                int index=q.peek().value-min;
                q.poll();
                if(i==0){
                    first=index;
                }
                if(i==size-1){
                    last=index;
                }
                if(node.left!=null){
                    q.add(new Pair(node.left,index*2+1));
               }
                if(node.right!=null){
                    q.add(new Pair(node.right,index*2+2));
                }
            }
            ans=Math.max(ans,((last-first)+1));
        }
        return ans;
}
}