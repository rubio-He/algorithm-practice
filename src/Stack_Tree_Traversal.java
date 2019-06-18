import java.util.*;

public class Stack_Tree_Traversal {

    void preOrder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        while(root != null || !stk.isEmpty()){
            while(root != null){
                System.out.print(root.val);
                stk.push(root);
                root = root.left;
            }
            if(!stk.isEmpty()){
                root = stk.pop();
                root = root.right;
            }
        }
    }


    void inorder(TreeNode root){
        Stack<TreeNode> stk = new Stack<>();
        while(root != null || !stk.isEmpty()){
            while(root != null){
                stk.push(root);
                root = root.left;
            }
            if(!stk.isEmpty()){
                root = stk.pop();
                System.out.print(root.val);
                root = root.right;
            }
        }
    }



}
