import java.util.*;
public class Find_all_anagrams_in_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int n = s.length();
        int left = 0, right = 0;
        Map<Character, Integer> m = new HashMap<>();
        int counter = m.size();
        for(char c : p.toCharArray()) m.put(c, m.getOrDefault(c,0) + 1);
        while(right < n){
            char c = s.charAt(right);
            if(m.containsKey(c)){
                m.put(c , m.get(c) - 1);
                if(m.get(c) == 0) counter--;
            }
            right++;
            while(counter == 0){
                char cc = s.charAt(left);
                if(m.containsKey(cc)){
                    m.put(cc, m.get(cc) + 1);
                    if(m.get(cc) > 0) counter++;
                }
                if(right - left  == p.length()){
                    res.add(left);
                }
                left++;
            }

        }
        return res;
    }


    public List<Integer> findAnagramsII(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) {
                count--;
            }
            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0){
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Find_all_anagrams_in_String sol = new Find_all_anagrams_in_String();
        sol.findAnagrams("cbaebabacd","abc");
    }
}
