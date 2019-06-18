public class maxVacationDay {
    public static int maxVacationDays(int[][] flights, int[][] days) {
        //opt(C,W) = dats[c][w] + max(opt(All Cs)(w-1)  * flights[C'][C]);

        int n = flights.length;
        if(n == 0) return 0;
        int k = days[0].length;
        int[][] dp = new int[n][k];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) {
                    if(j == 0 || flights[0][j] == 1) dp[j][0] = days[j][0];
                    else dp[j][0] = -1;
                }
                else{
                    dp[j][i] = -1;
                    for(int c = 0; c < n; c++) {
                        if(c == j && dp[j][i-1] != -1) dp[j][i] = Math.max(days[j][i] + dp[c][i-1], dp[j][i]);
                        else {
                            if(dp[c][i-1] == -1) dp[j][i] = Math.max(-1, dp[j][i]);
                            else if(flights[c][j] == 1) dp[j][i] = Math.max(dp[j][i],days[j][i] + dp[c][i-1]);
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++) max = Math.max(max, dp[i][k-1]);
        return max;
    }
    public static void main(String[] args){

        System.out.println(maxVacationDays(new int[][]{{0,0,0},{0,0,0},{0,0,0}}
,new int[][]{{1,1,1},{7,7,7},{7,7,7}}));

    }
}

