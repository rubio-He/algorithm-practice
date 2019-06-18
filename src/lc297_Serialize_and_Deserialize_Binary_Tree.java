import java.util.*;
public class lc297_Serialize_and_Deserialize_Binary_Tree {

    public static class Solution {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root, int k) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode root, StringBuilder sb){
            if(root == null){
                sb.append('#');
                sb.append(',');
            }
            else{
                sb.append(root.val).append(',');
                buildString(root.left, sb);
                buildString(root.right, sb);
            }
        }
        public TreeNode deserialize(String data) {
            Queue<String> q = new LinkedList<>();
            q.addAll(Arrays.asList(data.split("//,")));
            return buildNodes(q);
        }

        public TreeNode buildNodes(Queue<String> q){
            String node = q.poll();
            if(node.equals("#")) return null;
            else{
                TreeNode n = new TreeNode(Integer.valueOf(node));
                n.left = buildNodes(q);
                n.right =buildNodes(q);
                return n;
            }

        }


    }


    public static void main(String[] args){
        Solution codec = new Solution();
    }
}
