#include<cstdio>
#include<cstring> 
#include<algorithm>
int n, dp[65], cow[65];
int main(){
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 1; 
    cow[1] = 1;
    cow[2] = 2;
    cow[3] = 3;
    cow[4] = 4;
    for(int i = 5; i <= 65; i++){
        dp[i] = dp[i-1] + dp[i-3];
        cow[i] = cow[i-1] + dp[i];
    }
    while(scanf("%d", &n) && n){
        printf("%d\n",cow[n]);
    }
    return 0;
}
