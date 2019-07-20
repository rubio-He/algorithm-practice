import java.util.*;
public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int odd = 0;
        int even = 0;
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0) + 1);
        }
        int[] arr = new int[n];
        int index = 0;
        arr[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(arr[index] != nums[i]) arr[++index] = nums[i];
        }
        dp[0] = arr[0] * freq.get(nums[0]);
        int max = 0;
        for(int i = 1; i <= index; i++){
            dp[i] =  (arr[i-1] + 1) == arr[i] ? (i-2 >=0 ? dp[i-2] : 0) + arr[i]*freq.get(arr[i]) : dp[i-1] + arr[i]*freq.get(arr[i]);
            max = Math.max(max, dp[i]);
         }
        return max;
    }

    public static void main(String[] args){
        System.out.println(deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
