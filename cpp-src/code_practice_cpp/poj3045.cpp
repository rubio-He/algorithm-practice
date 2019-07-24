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


struct Cow{
    int w, s;
    bool operator > (const Cow & c) const
    {
        return w + c > c.w + c.s;
    }
};

int n;
Cow cow[50000];


ll solve()
{
    sort(cow, cow+n , greater<Cow>());

    ll W = 0;
    FOR(i, 0 , n){
        W += cow[i].w;
    }
    ll max_risk = -1;
    FOR(i, 0, n){
        W -= cow[i].w;
        ll risk = W - cows[i].s;
        if(risk > max_risk) max_risk = risk;
    }
    return max_risk;
}
int main()
{

    RDI(n);
    FOR(i, 0, n){
        RDII(cow[i].w, cow[i].s);
    }
    PTI(solve());
    return 0;

}
