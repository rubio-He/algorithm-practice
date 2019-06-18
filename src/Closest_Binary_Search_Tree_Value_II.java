/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;
class Closest_Binary_Search_Tree_Value_II {
    Stack<Integer> stk = new Stack<>();
    List<Integer> res = new LinkedList<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        int min = Integer.MAX_VALUE;

        inorder(root, target, k, min);
        return res;
    }
    public void inorder(TreeNode root, double target, int k , int min){
        if( root == null ) return;
        inorder(root.left, target, k, min);
        if( Math.abs(root.val - target) <  Math.abs(min - target)){
            min = root.val;
            stk.push(root.val);
        }
        else{
            while(!stk.isEmpty() && Math.abs(root.val - target) > Math.abs(stk.peek() - target) && res.size() < k){
                res.add(stk.pop());
            }
        }
        inorder(root.right, target,k, min);
    }
}