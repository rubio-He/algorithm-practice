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
#define PB(x) push_back(x)
#define N 100005

int n, a[N], k;


bool judge(int m){
    int cnt = 0;
    FOR(i, 0, n){
        if(a[i] >= m){
            int more = a[i] - m;
            cnt+= (more + k - 2) / (k -1 );
            if(cnt > m) return false;
        }
    }
    return true;
}


 a[i] + * -(m-*)    /(k-1) 


int main()
{
    freopen("input.txt", "r", stdin);
    RDI(n);
    int r = 0;
    FOR(i,0,n){ RDI(a[i]); r = max(r, a[i]);}
    RDI(k);
    if(k == 1){

        PTI(r);
    }
    else{
        int l=0;
        while(l + 1 < r ){
            int m = (r + l) >> 1;
            if(judge(m)) r = m;
            else l = m;
        }
        PTI(r);
    }
    return 0;
}
