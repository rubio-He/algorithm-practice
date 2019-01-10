#include <iostream>
#include <algorithm>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <string>
#include <map>
#include <set>
#include <queue>
#include <deque>
#include <list>
#include <bitset>
#include <stack>
#define lowbit(x) (x&-x)
using namespace std;
int main()
{
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        long long ans = 2*n*n-n+1;
        cout<<ans<<endl;
    }
    return 0;
}