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
public class Codec {

    // Encodes a tree to a single string.
    public  String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(".");
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        System.out.print(sb.toString());
        return sb.toString();
    }



    // Decodes your encoded data to tree.


    public static TreeNode deserialize(String data) {
        String[] res = data.split(",");
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = null;
        for(int i = 0; i < res.length; i++){
            if(res[i].equals("")) continue;
            int val = Integer.parseInt(res[i]);
            if(stk.isEmpty()){
                root = new TreeNode(val);
                stk.push(root);
            }
            else{
                if(val < stk.peek().val){
                    TreeNode tmp = new TreeNode(val);
                    stk.peek().left = new TreeNode(val);
                    stk.push(tmp);
                }
                else{
                    TreeNode tmp = new TreeNode(val);
                    TreeNode fahter = new TreeNode(0);
                    while(!stk.isEmpty() && stk.peek().val < val){
                        fahter = stk.pop();
                    }
                    fahter.right = tmp;
                    stk.push(tmp);
                }
            }
        }
        return root;
    }



    public static void main(String[] args){
           deserialize("3,1,2,4");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));