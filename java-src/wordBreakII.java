/**
 * Created by Hobbes on 6/15/17.
 */
import java.util.*;
public class wordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>();
        List<String> res = new LinkedList<String>();
        for(String w : wordDict){
            set.add(w);
        }
        helper(res, 0, 1, set,s,new StringBuilder());
        return res;
    }

    static void helper(List<String> res, int i, int j, Set<String> set, String s,StringBuilder sb){
        if(j > s.length()) return;
        String tmp = s.substring(i,j);
        if(set.contains(tmp)){
            sb.append(' ');
            sb.append(tmp);
            if(j == s.length()){
                sb.deleteCharAt(0);
                res.add(sb.toString());
                return;
            }
            else{
                StringBuilder sb2 = new StringBuilder(sb.toString());
                helper(res, j, j+1,set,s,sb2);
            }
        }
        helper(res,i,j+1,set,s,sb);
    }

    public static void main(String[] args){
        String s = "catsanddog";
        List<String> ll = new LinkedList<>();
        ll.add("cat");
        ll.add("sand");
        ll.add("and");
        ll.add("dog");
        wordBreak(s,ll);
    }
}
