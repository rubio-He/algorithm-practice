public class StrangePrinter {
    /*
    There is a strange printer with the following two special requirements:

The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
Example 2:
Input: "aba"
Output: 2
Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
Hint: Length of the given string will not exceed 100.
     */

    public int strangePrinter(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][n];
        return helper(dp, 0,n-1, 0,s.toCharArray());

    }
    int helper(int[][][] dp, int l, int r, int k, char[] s){
        if(l > r ) return Integer.MAX_VALUE;
        if(dp[l][r][k] > 0) return dp[l][r][k];
        while(l < r && s[l+1] == s[l]){
            l++;
            k++;
        }
        int res = 1 + helper(dp, l+1, r , 0, s);
        for(int i = l+1; i <= r; i++){
            if(s[i] == s[l]){
                res = Math.min(res, helper(dp, l+1, i-1, 0,s) + helper(dp, i, r, k+1, s));
            }
        }
        dp[l][r][k] = res;
        return res;

    }
}
