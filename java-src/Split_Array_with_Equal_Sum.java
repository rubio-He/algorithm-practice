import java.util.*;
public class Split_Array_with_Equal_Sum {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if(n < 7) return false;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++) sum[i] = sum[i-1] + nums[i];
        for(int j = 3; j < n - 3; j++){
            Set<Integer> set = new HashSet<Integer>();
            for(int i = 1; i < j - 1; i++){
                if(sum[j-1] - sum[i] == sum[i-1]) set.add(sum[i-1]);
            }
            for(int k = j + 1; k < n - 1; k++){
                if(sum[n-1] - sum[k] == sum[k-1] - sum[j] && set.contains(sum[k-1] - sum[j])) return true;
            }
        }
        return false;
    }


}
