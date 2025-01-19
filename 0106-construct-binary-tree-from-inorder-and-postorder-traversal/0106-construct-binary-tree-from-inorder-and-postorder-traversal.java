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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> imMap= new HashMap();
        prepareInMap(inorder,imMap);
        int inStart=0;int inEnd=inorder.length-1;int postStart=0;int postEnd=postorder.length-1;
        return buildTreeFromInNPostOrder(inorder,inStart,inEnd,postStart,postEnd,postorder,imMap);
        
    }

    private TreeNode buildTreeFromInNPostOrder(int[] inorder,int inStart,int inEnd,int postStart,int postEnd,int[] postorder,Map<Integer,Integer> imMap){
        if(inStart>inEnd || postStart>postEnd){
           return null;
        }
        TreeNode root=new TreeNode(postorder[postEnd]);
        int inRoot=imMap.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=buildTreeFromInNPostOrder(inorder,inStart,inRoot-1,postStart,postStart+numsLeft-1,postorder,imMap);
        root.right=buildTreeFromInNPostOrder(inorder,inRoot+1,inEnd,postStart+numsLeft,postEnd-1,postorder,imMap);
        return root;
    }

    private void prepareInMap(int[] inorder,Map<Integer,Integer> inMap){
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
    }
}