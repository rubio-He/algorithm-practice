#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>
#include <cstdio>
#include <cmath>
#include <algorithm>
#include <stack>
using namespace std;

#define MEM(a,b) memset(a,b,sizeof(a))
#define pf printf
#define sf scanf
#define debug printf("!/m")
#define INF 1100000
#define MAX(a,b) a>b?a:b
#define blank pf("\n")
#define LL long long
#define M 1000000007

LL dp[INF][5];
LL n,m,k,u,v;

LL Cal()
{
          dp[0][0] = 1;//初始化时可以随意放一个，没有什么影响，因为后面已经把所有情况考虑进去
          dp[0][1] = 0;
          dp[0][2] = 0;
          int i;
          for(i = 1;i<=n;i++)
          {
                    LL sum = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%M;
                    dp[i][2]=sum;
                    if(i<=u)
                              dp[i][0] = sum;
                    else if(i==u+1)
                              dp[i][0] = (sum-1)%M;
                    else
                              dp[i][0] = (sum - dp[i-u-1][1] - dp[i-u-1][2])%M;

                    if(i<=v)
                              dp[i][1] = sum;
                    else if(i==v+1)
                              dp[i][1] = (sum - 1)%M;
                    else
                              dp[i][1] = (sum - dp[i-v-1][0] - dp[i-v-1][2])%M;

          }
          return (dp[n][0]+dp[n][1]+dp[n][2])%M;
}


int main()
{
          while(~sf("%lld%lld%lld",&n,&m,&k))
          {
                    u = n;v = k;
                    LL ans = Cal();
                    u = m-1;v = k;
                    ans = ((ans - Cal())%M+M)%M;
                    pf("%lld\n",ans);
          }

    return 0;
}