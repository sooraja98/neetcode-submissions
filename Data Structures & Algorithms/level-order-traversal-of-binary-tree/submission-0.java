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
        Queue<TreeNode>qu=new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> arrList= new ArrayList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int sizeOfQu=qu.size();
            List<Integer> list= new ArrayList<>();
            for(int i=0;i<sizeOfQu;i++){
                TreeNode data = qu.poll();
                list.add(data.val);
                if(data.left!=null){
                    qu.offer(data.left);
                }
                 if(data.right!=null){
                    qu.offer(data.right);
                }
            }
            arrList.add(list);

        }
        return arrList;
        
    }
}
