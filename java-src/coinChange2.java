import java.util.*;

public class coinChange2 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin ; i <= amount; i++){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args){
        change(10, new int[]{1,2,5});
    }
}
