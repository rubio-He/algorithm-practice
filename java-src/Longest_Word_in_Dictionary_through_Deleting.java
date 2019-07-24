import java.util.*;
public class Longest_Word_in_Dictionary_through_Deleting {
//    Input:
//    s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//    Output:
//            "apple"
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d, (a,b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for(String ss : d){
            int i = 0;
            for(char c : s.toCharArray()){
                if(i < ss.length() && c == ss.charAt(i)) i++;
            }
            if(i == ss.length()) return ss;
        }
        return "";
    }

}
