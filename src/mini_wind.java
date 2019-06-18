public class mini_wind {
    public static String minWindow(String S, String T) {
        if(S.length() == 0 || T.length() == 0) return "";
        String res = "";
        int len = 20000;
        for(int i = 0; i < S.length(); i++){
            int idx = helper(S, T, i, 0);
            if(idx == -1) continue;
            if(len > (idx - i)){
                len = idx - i;
                res = S.substring(i,idx);
            }
        }
        return res;
    }

    static int helper(String s, String t, int i, int j){
        if(j == t.length()) return i;
        for(int k = i; k < s.length(); k++){
            if(s.charAt(k) == t.charAt(j)) return helper(s,t, k+1, j+1);
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.print(minWindow("abcdebdde","bde"));
    }
}
