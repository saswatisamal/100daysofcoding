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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer,Integer> imMap= new HashMap();
        prepareInMap(inorder,imMap);
        int inStart=0;int inEnd=inorder.length-1;int preStart=0;int preEnd=preorder.length-1;
        return buildTreeFromInNPreOrder(inorder,inStart,inEnd,preStart,preEnd,preorder,imMap);
        
    }

    private TreeNode buildTreeFromInNPreOrder(int[] inorder,int inStart,int inEnd,int preStart,int preEnd,int[] preorder,Map<Integer,Integer> imMap){
        if(inStart>inEnd || preStart>preEnd){
           return null;
        }
        TreeNode root=new TreeNode(preorder[preStart]);
        int inRoot=imMap.get(root.val);
        int numsLeft=inRoot-inStart;
        root.left=buildTreeFromInNPreOrder(inorder,inStart,inRoot-1,preStart+1,preStart+numsLeft,preorder,imMap);
        root.right=buildTreeFromInNPreOrder(inorder,inRoot+1,inEnd,preStart+numsLeft+1,preEnd,preorder,imMap);
        return root;
    }

    private void prepareInMap(int[] inorder,Map<Integer,Integer> inMap){
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
    }  
    }
