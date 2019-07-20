public class target_Sum {
    int[][] dp;
    int res;
    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        dp = new int[nums.length][nums.length];


        return res;
    }

    public void dfs(int[] nums, int target, int i) {
        if (i == nums.length && target == 0) {
            res++;
            return;
        } else if (i == nums.length && target != 0) return;
        else {
            dfs(  nums,  target -nums[i], i + 1);
            dfs(  nums,  target +nums[i], i + 1);
        }
    }
}


