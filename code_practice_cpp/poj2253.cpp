#include<cstdio>
#include<cmath>
#define INF 0x3f3f3f3f 
using namespace std;
const int maxn = 210;
int v[maxn];
double  d[maxn], map[maxn][maxn], coor[maxn][2];

double Distance(int i, int j){
    int x = coor[i][0] - coor[j][0];
    int y = coor[i][1] - coor[j][1];
    return sqrt(x*x + y*y);
}


void Dijkstra(int n){
    for(int i = 1; i <= n; i++){
        v[i] = 0;
        d[i] = map[1][i]; 
    }
    d[1] = 0;
    v[1] = 1;
    int min, pos = 1;
    for(int i = 0; i < n; i++){
        min = INF;
        for(int j = 1; j <= n; j++){
            if(!v[j] && d[j] < min){
                pos = j;
                min = d[j];
            }
        } 
        v[pos] =1;
        for(int j = 1; j <= n; j++){
            double m = d[pos] > map[pos][j] ? d[pos]:map[pos][j];     //判断最大  
            d[j] = d[j] < m ? d[j]:m;                               //最大中的最小 
        }
    }
}


int main()  
{  
    int n,nCase = 1;  
    freopen("input.txt", "r", stdin);
    while(scanf("%d",&n),n){  
        for(int i = 1;i <= n; i++)  
            for(int j = 1;j <= n; j++)  
                map[i][j] = INF;  
        for(int i = 1;i <= n; i++)  
            scanf("%lf%lf",&coor[i][0],&coor[i][1]);  
  
        for(int i = 1;i <= n; i++)  
            for(int j = 1;j <= n; j++)  
                map[i][j] = Distance(i,j);  
        Dijkstra(n);  
        printf("Scenario #%d\nFrog Distance = %.3f\n\n",nCase++,d[2]);  
    }  
    return 0;  
}  