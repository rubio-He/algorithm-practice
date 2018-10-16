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
#include <iomanip>
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
#define eps 1e-5
#define N 1005
double x;
struct Test{
    int a, b;
    bool operator < (const Test& other) const
    {
        return a - x * b > other.a - x * other.b;
    }
};
Test test[N];
int n, k;

bool judge(double m){
    x = m;
    sort(test, test +n);
    double tot_a = 0, tot_b = 0;
    FOR(i,0,n - k){
        tot_a += test[i].a;
        tot_b += test[i].b;
    }
    return tot_a / tot_b > m;

}

int main(){
//    freopen("input.txt","r", stdin);
    while(RDII(n,k) != EOF){
        if(n == 0) break;
        FOR(i,0,n) RDI(test[i].a);
        FOR(i,0,n) RDI(test[i].b);
        double l = 0, r = 1;
        while( r-l > eps){
                double m = (l + r) / 2 ;
            if(judge(m)){
                l = m;
            }
            else{
                r = m;
            }
        }

       cout << fixed << setprecision(0) << l * 100 << endl;
    }
    return 0;
}
