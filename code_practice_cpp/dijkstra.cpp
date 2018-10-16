#include<cstdio>
#include<iostream>
#include<algorithm>
#include<cstring>
#include<queue>
#include<vector>
#include<set>
#include<map>
#include<string>

using namespace std;
#define INF 0x3f3f3f3f
const int maxn = 2000 + 5;

struct Edge {
    int from, to, dist;
};

struct Node {
    int d, u;
    bool operator < (const Node& rhs) const {
        return d > rhs.d;
    }
};

struct Dijkstra {
    int n, m;
    vector<Edge> edges; //保存边信息
    vector<int> G[maxn]; //出边表
    int d[maxn];
    bool done[maxn];

    void init(int n) {
        this->n = n;
        memset(done, 0, sizeof(done));
        memset(d, INF, sizeof(d));
        for (int i = 0; i <= n; ++i)
            G[i].clear();
        edges.clear();
    }

    void AddEdge(int from, int to, int dist) {
        edges.push_back((Edge){from, to, dist});
        m = edges.size();
        G[from].push_back(m-1);
    }

    void dijkstra(int s) {
         priority_queue<Node> Q;
         d[s] = 0;
         Q.push((Node){d[s], s});
         while(!Q.empty()) {
             Node x = Q.top(); Q.pop();
             int u = x.u;
             if (done[u]) continue;
             done[u] = true;
             int len = G[u].size();
             for (int i = 0; i < len; ++i) {
                 Edge &e = edges[G[u][i]];
                 if (d[e.to] > d[u] + e.dist) {
                    d[e.to] = d[u] + e.dist;
                    Q.push((Node){d[e.to], e.to});
                 }
             }
         }
    }

};

Dijkstra di;

int main() {
    int n, m, a, b, c;
    while(cin>>m>>n) {
        di.init(n);
        while(m--) {
            cin>>a>>b>>c;
            di.AddEdge(a, b, c);
            di.AddEdge(b, a, c);
        }
        di.dijkstra(1);
        cout<<di.d[n]<<endl;
    }

    return 0;
}