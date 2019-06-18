public class decodeWaysII {
    public int numDecodings(String s) {
        // dp[i] = dp[]
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        if(s.charAt(0) == '*') dp[1] = 9;
        else dp[1] = 1;

        for(int i = 2; i <= s.length(); i++) {
            char first = s.charAt(i - 2);
            char second = s.charAt(i - 1);

            if (second == '*') dp[i] += dp[i - 1] * 9;
            else if (second > '0') dp[i] += dp[i - 1];

            if (first == '*') {
                if (second == '*') dp[i] += 15 * dp[i - 2];
                else if (second <= '6') dp[i] += 2 * dp[i - 2];
                else dp[i] += dp[i - 2];
            } else if (first == '2' || first == '1') {
                if (second == '*') {
                    if (first == '1') dp[i] += dp[i - 2] * 9;
                    else dp[i] += dp[i - 2] * 6;
                } else if ((first - '0') * 10 + (second - '0') <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int)dp[s.length()];
    }
}
