import java.util.*;
public class is_Subsequence_Followup {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] l = new List[256];
        for(int i = 0; i < s.length(); i++){
            if(l[s.charAt(i)] == null) l[s.charAt(i)] = new ArrayList<>();
            l[s.charAt(i)].add(i);
        }
        int prev = 0;
        for(int i = 0; i < t.length(); i++){
            if(l[s.charAt(i)] == null) return false;
            int j = Collections.binarySearch(l[s.charAt(i)], prev);
            if(j < 0) j = - j - 1;
            if(j == l[s.charAt(i)].size()) return false;
            prev = l[s.charAt(i)].get(j) + 1;
        }
        return true;

    }
}
