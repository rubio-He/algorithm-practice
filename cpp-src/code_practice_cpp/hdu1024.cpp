#include <cstdio>
#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
#include <cstring>
#include <string>
#include <cmath>
#include <vector>
#include <bitset>
#include <list>
#include <sstream>
#include <set>
#include <functional>
#include <map>

using namespace std;

typedef long long ll;
typedef pair<int, int> P;
#define mod 100005
#define RDI(x) scanf("%d",&x)   
#define RDII(x,y) scanf("%d %d",&x,&y) 
#define PTI(x) printf("%d\n", x);
#define FOR(x,y,z) for(int x = (y); x < (z); x++)
#define FORR(x,y,z) for(int x = (y); x >= (z); x--) 
#define MS0(x) memset(x, 0, sizeof(x))
#define MS1(x) memset(x, 1, sizeof(x))
#define PII pair<int, int>
#define MP(x,y) make_pair(x,y)
#define PB(x) push_backa(x)
#define MAX(x,y) (x>y?x:y)
#define MIN(x,y) (x<y?x:y)
#define inf 0x7fffffff  

int n, m;
int arr[1000005]; 
int solve()
{
    int dp[n+1];
    int max[n+1];
    MS0(dp);
    MS0(max);
    int res;
    FOR(i,1,m+1){
        res = -inf;
        FOR(j,1,n+2){
            dp[j] = MAX(dp[j-1], max[j-1]) + arr[j];
            max[j-1]=res;
            res= MAX(res, dp[j]);    
    }}   
    PTI(res);
    return 0;
}



int main()
{
    freopen("input.txt","r", stdin);
    while(RDI(m) != EOF)
    {
        MS0(arr);
        RDI(n);
        FOR(i,1,n+1){RDI(arr[i]);}
        solve();
    }
    return 0;
}
