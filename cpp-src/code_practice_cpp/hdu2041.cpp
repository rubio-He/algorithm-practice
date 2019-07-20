#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <iostream>
int n, m; 
long long dp[55];
int main(){
    scanf("%d", &n);
    memset(dp, 0, sizeof(dp));
    dp[1 ]= dp[2] = 1;
    for(int i = 3; i < 55; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    while(n--){
        scanf("%d", &m);
        printf("%lld\n", dp[m]);
    }
    return 0;
}