#include<cstdio>
#include<cstring>
#define INF 0x3f3f3f3f  
const int maxn = 1010;
int map[maxn][maxn];
int v[maxn], d[maxn];
void Dijkstra(int n){
    int pos, min;
    for(int i = 1; i <= n; i++){
        v[i] = 0;
        d[i] = map[1][i];
    }
    for(int i = 0; i < n; ++i){
        min = INF;
        for(int j = 1; j <= n; j++){
            if(!v[j] && d[j]  < min ){
                min = d[j];
                pos = j;
            }
        }
        v[pos] = 1;
        for(int j = 1; j <= n; j++){
            if(!v[j] && map[pos][j] + d[pos] < d[j] ){
                d[j] = map[pos][j] + d[pos];
            }
        }
    }
}

int main(){
    // freopen("input.txt","r", stdin);
    int t, n;
    scanf("%d%d", &t,&n);
    memset(map, INF, sizeof(map));
    while(t--){
        int from, to, dist;
        scanf("%d%d%d",&from, &to, &dist);
        if(map[from][to] >dist ){
            map[from][to] = map[to][from] = dist;
        }
    }
    Dijkstra(n);
    printf("%d\n", d[n]);
    return 0;
}