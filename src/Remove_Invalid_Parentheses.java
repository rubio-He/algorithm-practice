import java.util.*;
public class Remove_Invalid_Parentheses {
    public static List<String> removeInvalidParentheses(String s) {
        int left_para = 0;
        int right_para = 0;
        for(char c : s.toCharArray()){
            if(c == '(') left_para++;
            else if(c == ')'){
                if(left_para > 0) left_para--;
                else right_para++;
            }
        }
        Set<String> res = new HashSet<String>();
        dfs(0,left_para,right_para,0,s,new StringBuilder(), res);
        return new ArrayList<String>(res);
    }

    private static void dfs(int idx, int left_para, int right_para, int rest_pair, String s, StringBuilder sb, Set<String> res){
        if(left_para < 0 || right_para < 0 || rest_pair < 0) return;
        if(idx == s.length()){
            if(left_para == 0 && right_para == 0 && rest_pair == 0){
                res.add(sb.toString());
            }
            return;
        }
        if(s.charAt(idx) == '(') {
            dfs(idx+1,left_para - 1,right_para, rest_pair,s,new StringBuilder(sb.toString()),res);
            dfs(idx+1,left_para, right_para, rest_pair + 1,s,new StringBuilder(sb.append(s.charAt(idx)).toString()), res);
        }
        else if(s.charAt(idx) == ')'){
            dfs(idx+1,left_para,right_para -1, rest_pair,s,new StringBuilder(sb.toString()),res);
            dfs(idx+1,left_para,right_para, rest_pair -1,s,new StringBuilder(sb.append(s.charAt(idx)).toString()),res);
        }
        else{
            dfs(idx+1,left_para,right_para, rest_pair,s,new StringBuilder(sb.append(s.charAt(idx)).toString()),res);
        }
    }

    public static void main(String[] args){
        removeInvalidParentheses("s");
    }
}
