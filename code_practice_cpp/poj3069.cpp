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
#define N  1005
int arr[N], r, n;

void solve(){

    

    int res = 0;
    sort(arr, arr+n);
    int i = 0, f, c; 
    while(i < n){
        f = arr[i++];
        while(i < n && arr[i] - f <= r) i++;
        c = arr[i-1];
        while(i < n && arr[i] - c <= r) i++;
        res++;
    }
    PTI(res);

}


int main(){
    freopen("input.txt", "r" , stdin);
    MS0(arr);
    while(RDII(r, n)!= EOF){
        if(n == -1) break;
        for(int i = 0; i < n; i++){
            RDI(arr[i]);
        }
        solve();
    }
    return 1;
}