



public class Number_of_palindromic_substring {
    static int count(String s){
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            dp[i+1][i] =true;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i+1; j < n; j++){
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] =true;
                    res++;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args){
        System.out.println(count("abaab"));
    }
}
