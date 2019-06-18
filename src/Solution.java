import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = -1;
        for(int i = 0;  i < nums.length; i++){
            int n = nums[i];
            if(!m.containsKey(n)){
                int l = (m.containsKey(n-1)) ? m.get(n-1) : 0;
                int r = (m.containsKey(n+1)) ? m.get(n+1) : 0;
                int sum = l + r + 1;
                m.put(n,sum);
                if(sum == k) res = i+1;
                m.put(n-l, sum);
                m.put(n+r, sum);
                // 1 2 3 4 5
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{3,1,5,4,2}, 1));
    }
}