#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <ctime>
#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <deque>
#include <list>
#include <set>
#include <map>
#include <stack>
#include <queue>
#include <numeric>
#include <iomanip>
#include <bitset>
#include <sstream>
#include <fstream>
#define debug puts("-----")
#define pi (acos(-1.0))
#define eps (1e-8)
#define inf (1<<28)
#define MAXN 35
using namespace std;

#define MAX_NUM 31

class Node
{
public:
    int l, r, c;
    int time;
public:
    bool operator==(const Node &rhs) const
    {
        return l == rhs.l && r == rhs.r && c == rhs.c;
    }
};

int layer, row, col;
Node start, end;
bool dic[MAX_NUM][MAX_NUM][MAX_NUM];
bool flag[MAX_NUM][MAX_NUM][MAX_NUM];
int steps[6][3] = { {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, { -1, 0, 0} };

bool CheckValid(const Node &node)
{
    int l = node.l, r = node.r, c = node.c;

    if (l >= 0 && l < layer
            && r >= 0 && r < row
            && c >= 0 && c < col
            && dic[l][r][c])
    {
        return true;
    }
    return false;
}

int TBFS()
{
    int i;
    queue<Node> q;
    q.push(start);
    flag[start.l][start.r][start.c] = 1;

    while (!q.empty())
    {
        Node tmp = q.front();
        q.pop();

        for (i = 0; i < 6; ++i)
        {
            Node node = tmp;
            node.l += steps[i][0];
            node.r += steps[i][1];
            node.c += steps[i][2];
            if (CheckValid(node) && !flag[node.l][node.r][node.c])
            {
                ++node.time;
                flag[node.l][node.r][node.c] = 1;
                q.push(node);

                if (node == end)
                {
                    return node.time;
                }
            }
        }
    }
    return 0;
}

int main(int argc, char const *argv[])
{
    int i, j, k;
    char ch;

    while (1)
    {
        Node tmp;
        scanf ("%d %d %d%*c", &layer, &row, &col); //注意这里的一个小小细节，%*c用来忽略输入后面的那个回车，学习了。
        if (!layer && !row && !col)
            break;
        for (i = 0; i < layer; ++i)
        {
            for (j = 0; j < row; ++j)
            {
                for (k = 0; k < col; ++k)
                {
                    ch = getchar();
                    if (ch == '#')
                    {
                        dic[i][j][k] = 0;
                    }
                    else if (ch == '.')
                    {
                        dic[i][j][k] = 1;
                    }
                    else if (ch == 'S')
                    {
                        start.l = i;
                        start.r = j;
                        start.c = k;
                        start.time = 0;
                        dic[i][j][k] = 1;
                    }
                    else if (ch == 'E')
                    {
                        end.l = i;
                        end.r = j;
                        end.c = k;
                        end.time = 0;
                        dic[i][j][k] = 1;
                    }
                }
                getchar ();
            }
            getchar ();
        }
        memset(flag, 0, sizeof(flag));
        int ret = TBFS();
        if (ret)
        {
            printf ("Escaped in %d minute(s).\n", ret);
        }
        else
        {
            printf ("Trapped!\n");
        }
    }
    return 0;
}
