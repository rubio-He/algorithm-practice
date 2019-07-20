
public class BST_Operation {
    TreeNode delete(TreeNode root, int key){
        if(root == null) return root;
        if(key < root.val) root.left = delete(root.left, key);
        else if(key > root.val) root.right =  delete(root.right, key);
        else{
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
        }
        return root;
    }

    private int minValue(TreeNode root){
        int min = root.val;
        while(root.left != null){
            min = root.left.val;
            root = root.left;
        }
        return min;
    }


    public TreeNode insertRec(TreeNode root, int key){
        if(root == null){
            root = new TreeNode(key);
            return root;
        }
        if(key > root.val){
            root.right = insertRec(root.right, key);
        }
        else if(key < root.val){
            root.left = insertRec(root.left,key);
        }
        return root;
    }
}
