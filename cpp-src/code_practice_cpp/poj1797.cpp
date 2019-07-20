#include<cstring>
#include<iostream>
#include<algorithm>
#include<cstdio>
#define INF 0x3f3f3f3f  
const int maxn = 1010;
int d[maxn], map[maxn][maxn],v[maxn];
using namespace std;

void dijkstra(int n){
    int pos, max;
    for(int i = 1; i <= n; i++){
        d[i] = map[1][i];
        v[i] = 0;
    }

    for(int i = 0; i < n; ++i){
        max = -1;
        for(int j = 1; j <= n; ++j){
            if(!v[j] && d[j] > max){
                max = d[j];
                pos = j;
            }   
        }
        v[pos] = 1;

        for(int j = 1; j <= n; j++){
            if(!v[j] && d[j] < min(map[pos][j], d[pos])){
                d[j] = min(map[pos][j], d[pos]);
            }
        }
    }


}


int main(){
    int nCase;  
    scanf("%d",&nCase);  
    for(int k = 1;k <= nCase; k++){  
  
        int n,m;  
        scanf("%d%d",&n,&m);  
        for(int i = 1;i <= n; i++)  
            for(int j = 1;j <= n; j++)  
                map[i][j] = 0;              //求最大当然初始化为小，此题不是求最短路径  
  
        for(int i = 1;i <= m; i++){  
            int c1,c2,weight;  
            scanf("%d%d%d",&c1,&c2,&weight);  
            map[c1][c2] =map[c2][c1] = weight;  
        }  
        dijkstra(n);  
        printf("Scenario #%d:\n%d\n\n",k,d[n]);  
    }  
    return 0; 

}