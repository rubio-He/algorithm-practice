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
#define N 2005


int n;
char s[N],t[N];
void solve(){
    int j = 0; 
    int a = 0, b = n - 1;
    while(a <= b){
        bool left = false;
        for(int i = 0; i + a <= b; i++){
            if(s[i+a] < s[b-i]){
                left = true;
                break;
            }
            else if(s[i+a] > s[b-i]){
                break;
            }
        }

        if(left) cout << s[a++];
        else cout << s[b--];
    }
    cout << endl;


}


int main(){
     freopen("input.txt", "r", stdin);
    RDI(n);
    MS0(t);
    FOR(i,0,n){
       cin >> s[i];
    }
    solve();


}