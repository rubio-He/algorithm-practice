
import java.util.*;
public class LargestDivisionSet {

    static List<Integer> largestDivisibleSubset(int[] nums){
        List<Integer> res = new LinkedList<>();
        if(nums.length == 0) return res;
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        int maxIndex = 0;
        int maxLen = -1;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] % nums[j] == 0){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;


                    if(dp[i] >= maxLen){
                        maxLen = dp[i];
                        maxIndex = i;
                    }
                }

            }
        }


        if(maxLen == -1) res.add(nums[0]);
        else{
            while(maxIndex != -1){
                res.add(nums[maxIndex]);
                maxIndex = parent[maxIndex];
            }
        }
        return res;
    }
}
