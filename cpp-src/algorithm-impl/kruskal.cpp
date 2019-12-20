#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
 
/*边的定义*/
struct edge
{
       int u, v;                                //边的两个端点编号
       int cost;                                //边权
       edge(int x,int y, int c):u(x),v(y),cost(c){}
};
 
/*边的比较函数*/
bool cmp(edge a, edge b)
{
       return a.cost < b.cost;
}
 
/*并查集查询函数，返回x所在集合的根结点*/
int findFather(vector<int> father, int x)
{
       int a = x;
       while (x != father[x])
              x = father[x];
       while (a != father[a]) {
              int z = a;
              a = father[a];
              father[z] = x;
       }
       return x;
}
 
/*Kruskal算法求无向图的最小生成树*/
int Kruskal(int n, int m, vector<edge>& E)
{
       /*
       param
       n:                         图的顶点个数
       m:                         图中边的个数
       E:                         边的集合
       */
       vector<int> father(n);                                 //并查集数组
       int ans = 0;                                           //所求边权之和
       int NumEdge = 0;                                       //记录最小生成树边数
       for (int i = 0; i < n; i++)                            //初始化并查集
              father[i] = i;
       Sort(E.begin(), E.end(), cmp);                         //所有边按边权从小到大排序
       for (int i = 0; i < m; ++i)                            //枚举所有边
       {
              int faU = findFather(father, E[i].u);           //查询端点u所在集合的根结点
              int faV = findFather(father, E[i].v);           //查询端点v所在集合的根结点
              if (faU != faV) {                               //如果不在一个集合中
                     father[faU] = faV;                       //合并集合（相当于把测试边加入到最小生成树）
                     ans += E[i].cost;
                     NumEdge++;                               //当前生成树边数加1
                     if (NumEdge == n - 1)                    //边数等于顶点数减1，算法结束
                           break;
              }
       }
       if (NumEdge != n - 1)                                  //无法连通时返回-1
              return -1;
       else
              return ans;                                     //返回最小生成树边权之和
}
 
int main()
{
       vector<edge> E = { edge(0,1,4),edge(1,2,1),edge(2,3,6),edge(3,4,5),edge(0,4,1),
                          edge(0,5,2),edge(1,5,3),edge(2,5,5),edge(3,5,4),edge(4,5,3) };
       int n = 6;
       int m = 10;
       int res = Kruskal(n, m, E);
       cout << res << endl;
}
