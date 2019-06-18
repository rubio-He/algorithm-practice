public class Dungeon_Game {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 0;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);
        for(int i = m-2; i >= 0; i--){
            dp[i][n-1] = Math.max(1, dp[i+1][n-1] - dungeon[i][n-1]);
        }
        for(int i = n-2; i >= 0; i--){
            dp[m-1][i] = Math.max(1,dp[m-1][i+1] -dungeon[m-1][i]);
        }

        for(int i = m-2; i >= 0; i--){
            for(int j = m -2; j >= 0; j++){
                int down = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                int right = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                dp[i][j] = Math.min(down,right);
            }
        }
        return dp[0][0];
    }
}
