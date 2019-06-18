import java.util.*;
/*
LeetCode 546
Given several boxes with different colors represented by different positive numbers.
You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
Find the maximum points you can get.
 */

public class RemoveBox {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, dp, 0, 0, n-1);


    }
    int helper(int[] boxes, int[][][] dp, int k ,int l , int r){
        if(l > r) return 0;
        if(dp[l][r][k] > 0) return dp[l][r][k];

        while(l < r &&  boxes[l] == boxes[l+1]){
            l++;
            k++;
        }
        int res = (k+1) * (k+1) + helper(boxes, dp, 0,l+1,r);

        for(int i = l + 1; i <= r; i++){
            if(boxes[i] == boxes[l]){
                res = Math.max(res, helper(boxes, dp, 0, l + 1, i - 1) + helper(boxes, dp, k + 1 , i, r));
            }
        }
        dp[l][r][k] = res;
        return res;

    }
}