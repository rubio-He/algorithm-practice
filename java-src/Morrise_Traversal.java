
public class Morrise_Traversal {

    public void inorder(TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    System.out.print(curr.val);
                    curr = curr.right;
                }
            }
        }
    }

    public void preorder(TreeNode root){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                System.out.print(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null){
                    pred.right = curr;
                    System.out.print(curr.val);
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
    }


}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}
