public class Freedom_Trail {




    public static int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        int[][] dp = new int[n + 1][m];
        for(int i = n-1; i >= 0; i--){
            for(int j = 0; j < m; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0 ; k < m; k++){
                    if(ring.charAt(k) == key.charAt(i)){
                        int step = Math.abs(k-j);
                        int min = Math.min(m - step, step);
                        dp[i][j] = Math.min(dp[i][j], min + dp[i+1][j]);
                    }
                }
            }
        }
        return dp[0][0] + n;




    }

    public static void main(String[] args){
        findRotateSteps("dding","dding");
    }




}
