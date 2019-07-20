
import java.util.*;
public class forusallOA {

    //完美树 是一种二叉树，如果这个树的所有node是没有孩子，或者是两个孩子，而且这个这个树的所有叶子节点都在同一层，这个树的所有节点数目叫做size()
    // Give a Tree, to find all maximum child tree size
    int max = 0;
    public int countSize(TreeNode root){
        helper(root);
        return max;
    }

    int helper(TreeNode root){
        if(root == null) return 0;
        int left = countSize(root.left);
        int right = countSize(root.right);
        if(left == right) {
            max = Math.max(max, left + 1);
            return left + 1;
        }
        else return Integer.MIN_VALUE;
    }


    private static final String spliter = ",";
    private static final String NN = "X";


    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

// find two subarray the length is respectively a and b, maximize the sum of the two subarrays
    public int twoSubArray(int[] arr, int a, int b){
        int n = arr.length;
        if(a + b > n) return -1;
        if(a == b) return getSumhelper(arr, a, a);
        else{
            return Math.max(getSumhelper(arr,a,b) , getSumhelper(arr,b,a));
        }

    }

    private int getSumhelper(int[] arr , int a, int b){
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = arr[i] + prefixSum[i-1];
        }

        int secondMax = prefixSum[n-1] - prefixSum[n-1-b];
        int firstMax = prefixSum[n-1-b] - prefixSum[n-1-b-a];
        int max = secondMax + firstMax;
        for(int i = n - 1 - b - a; i >= 0; i--){
            int tmp1 = prefixSum[i + a + b] - prefixSum[i + a];
            if(tmp1 > secondMax) secondMax = tmp1;
            int tmp2 = prefixSum[i + a] - prefixSum[i];
            if(tmp2 + secondMax > max) max = tmp2 + secondMax;
        }
        return max;
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1]-sum[i+1-k];
            }
            else
                posLeft[i] = posLeft[i-1];
        }
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }
            else
                posRight[i] = posRight[i+1];
        }
        // test all possible middle interval
        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        forusallOA sol = new forusallOA();
        TreeNode root = sol.deserialize("1,X,2,3,X,X,4,X,X,");
//        System.out.print(sol.countSize(root));

        System.out.print(sol.twoSubArray(new int[]{6,1,4,6,3,2,7,4}, 3,1));

    }


}
