import java.util.*;
public class lc3Longest_Substring_Without_Repeating_Characters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int count = 0;
            int left = 0, right = 0;
            int n = s.length(), res = 0;
            while(right < n){
                char c = s.charAt(right);
                map.put(c, map.getOrDefault(c,0) + 1);
                if(map.get(c) > 1){
                    count++;
                }
                right++;
                while(count > 0){
                    char cc = s.charAt(left);
                    map.put(cc, map.get(cc) - 1);
                    if(map.get(cc) == 1){
                        count--;
                    }
                }
                res = Math.max(res, right - left);

            }
            return res;
        }

        public int solution2(String s){
            Map<Character, Integer> m = new HashMap<>();
            int i = 0;
            int res = 0;
            for(int j = 0; j < s.length(); j++){
                if(m.containsKey(s.charAt(j))){
                    i = Math.max(i, m.get(s.charAt(j)));
                }
                m.put(s.charAt(j), j);
                res = Math.max(res, i - j);
            }
            return res;
        }

    }
}
