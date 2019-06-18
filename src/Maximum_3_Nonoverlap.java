class Maximum_3_Nonoverlap {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }

        int[] left = new int[n+1];
        int leftMax = sum[k] - sum[0];
        left[0]  = 0;
        //left arr
        for(int i = 1; i <= n - k; i++){
            if(sum[i + k] - sum[i] > leftMax){
                leftMax = sum[i + k] - sum[i];
                left[i] = i;
            }
            else left[i] = left[i-1];
        }

        // right
        int[] right = new int[n+1];
        int rightMax = sum[n] - sum[n-k];
        System.out.println("right" + rightMax);
        right[n-k] = n - k;
        for(int i = n - k - 1; i >= 0; i--){
            if(sum[i + k] - sum[i] > rightMax){
                rightMax = sum[i+k] - sum[i];
                right[i] = i;
            }
            else right[i] = right[i + 1];
        }

        int res = 0;
        int leftres = 0;
        int middleres = 0;
        int rightres = 0;
        for(int i = k; i <= n - 2 * k; i++){
            int l = left[i-k];
            int r = right[i+k];
            int leftSum = sum[l + k] - sum[l];
            int rightSum = sum[r + k] - sum[r];
            int middleSum = sum[i + k] - sum[i];
            if(leftSum + rightSum + middleSum > res){
                res = leftSum + rightSum + middleSum;
                leftres = l;
                rightres = r - 1;
                middleres = i - 1;
            }
        }
        return new int[]{leftres, middleres, rightres};
    }

    public static void main(String[] args){
        Maximum_3_Nonoverlap sol = new Maximum_3_Nonoverlap();
        sol.maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1},2);
    }
}