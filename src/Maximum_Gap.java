import java.util.*;
public class Maximum_Gap {
    public static int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int gap =(int) Math.ceil((double)(max - min) / (n-1) );
        int[] bucketsMAX = new int[nums.length - 1];
        int[] bucketsMIN = new int[nums.length - 1];
        Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
        Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
        for(int i : nums){
            if(i == min || i == max) continue;
            int idx = (i-min)/gap;
            bucketsMAX[idx] = Math.max(bucketsMAX[idx], i);
            bucketsMIN[idx] = Math.min(bucketsMIN[idx], i);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < nums.length - 1; i++){
            if(bucketsMAX[i] == Integer.MIN_VALUE && bucketsMIN[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
            previous = bucketsMAX[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }

    public static void main(String[] args){
        System.out.print(maximumGap(new int[]{1,3,100}));
    }
}
