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
#define N 105


int arr[N][N]; 
int now[N];
int res, sum;
int  main(){
    // freopen("input.txt", "r", stdin);
    int n;
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            scanf("%d", &arr[i][j]);
        }
    }
    res = arr[0][0];

    for(int i = 0; i < n; i++){
        memset(now, 0, sizeof(now));
        for(int j = i; j < n; j++){
            sum = 0;
            for(int k = 0; k < n; k++){
                now[k] = now[k] + arr[j][k];
                sum = sum > 0 ? sum + now[k] : now[k];
                res = res > sum ? res : sum;
            }
        }
    }
    
    printf("%d", res);
}
