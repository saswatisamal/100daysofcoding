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
   
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       // result of zigzag traversal
        List<List<Integer>> result = new ArrayList<>();

        // Check if the root is null,
        // return an empty result
        if (root == null) {
            return result;
        }

        // Queue to perform
        // level order traversal
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);

        // Flag to determine the direction of
        // traversal (left to right or right to left)
        boolean leftToRight = true;

        // Continue traversal until
        // the queue is empty
        while (!nodesQueue.isEmpty()) {
            // Get the number of nodes
            // at the current level
            int size = nodesQueue.size();

            // List to store the values
            // of nodes at the current level
            List<Integer> row = new ArrayList();

            // Traverse nodes at 
            // the current level
            for (int i = 0; i < size; i++) {
                // Get the front node
                // from the queue
                TreeNode node = nodesQueue.poll();

                // Determine the index to insert the node's
                // value based on the traversal direction
                int index = leftToRight ? i : (size - 1 - i);
                 while(row.size()<=index){
                    row.add(null);
                 }
                // Insert the node's value at
                // the determined index
                row.set(index, node.val);

                // Enqueue the left and right
                // children if they exist
                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            // Switch the traversal
            // direction for the next level
            leftToRight = !leftToRight;

            // Add the current level's
            // values to the result list
            result.add(row);
        }

        // Return the final result of
        // zigzag level order traversal
        return result;
    }
}

