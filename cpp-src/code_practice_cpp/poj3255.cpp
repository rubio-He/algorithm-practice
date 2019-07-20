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
#define MS1(x) memset(x, -1, sizeof(x))
#define PII pair<int, int>
#define MP(x,y) make_pair(x,y)
#define PB(x) push_backa(x)




int r,n;
int adj[5005][5005];
priority_queue<P, vector<P>, greater<P>> pq;
void solve(){
    pq.push(P(0,0));

}

int main(){
    RDII(n, r);
    MS1(adj);
    FOR(i,0,r){
        int s, e,dist;
        RDII(s,e);
        RDI(dist);
        adj[s][e] = dist;
        adj[e][s] = dist; 
    }

    solve();
}   