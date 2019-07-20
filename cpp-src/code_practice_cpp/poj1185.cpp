#include<cstdio>
#include<cstring>
#include<algorithm>
#define N  105 
#define M  15
#define MAXM 80
using namespace std;
char map[N][M];
int n,m, nums;
int base[N], state[MAXM], soldier[MAXM];
int  dp[N][MAXM][MAXM];
int main(){
    freopen("input.txt","r", stdin);
    memset(base, 0, sizeof(base));
    memset(state, 0, sizeof(state));
    memset(soldier, 0, sizeof(soldier));
    memset(dp, 0, sizeof(dp));
    nums = 0;
    scanf("%d%d", &n, &m);
    for(int i = 0; i < n; i++){
        scanf("%s", map[i]);
        for(int j= 0; j < m; j++) 
        if(map[i][j] == 'H') base[i] += (1 << j);
    }
    for(int i = 0; i < (1 << m); i++){
        if(i & i << 1) continue;
        if(i & i << 2 ) continue;
    
        int k = i;
        while(k){
            soldier[nums]+=k&1;
            k = k >>1;
        }
        state[nums++] = i;
    }
    for(int i = 0; i < nums; i++){
        if( base[0] & state[i]) continue;
        dp[0][i][0] = soldier[i];
    }

    for(int i = 0; i < nums; i++){
        if(state[i] & base[0]) continue;
        for(int j = 0; j < nums; j++){
            if(base[1] & state[j]) continue;
            if(state[i] & state[j] ) continue;
            dp[1][j][i] = dp[0][i][0] + soldier[j];
        }
    }
    for(int r = 2; r < n; r++){
        for(int i = 0; i < n; i++){
            if(base[r] & state[i]) continue;
            for(int j = 0; j < nums; j++){
                if(state[j] & base[r-1]) continue;
                if(state[i] & state[j]) continue;
                for(int k = 0; k < nums; k++){
                    if(state[k] & base[r-2]) continue;
                    if(state[k] & state[i]) continue;
                    if(state[k] & state[j]) continue;
                    dp[r][i][j] = max(dp[r][i][j], soldier[i] + dp[r-1][j][k]);
                }
            }
        }
    }

    int ans=0;
    for(int i=0; i<nums; i++)
        for(int j=0; j<nums; j++) //枚举dp[row-1][i][j]
            ans=max(ans,dp[n-1][i][j]);
    printf("%d\n",ans);

    return 0;
}