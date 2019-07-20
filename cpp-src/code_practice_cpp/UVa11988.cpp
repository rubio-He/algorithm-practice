#include <cstring>
#include <cstdio>
using namespace std;
#define INF 0x3f3f3f3f
const int maxn = 1e5+5;
char s[maxn];
int Next[maxn];
int main(int argc, char const *argv[])
{
while(scanf("%s",s+1) != EOF) {
    int cur = 0,last = 0;
    Next[0] = -1;//尾节点的next默认值，可以写成-1,0，指针的话用的是null
    int n = strlen(s+1);
    for (int i = 1; i <= n; ++i){
        if(s[i] == '[') cur = 0;
        else if(s[i] == ']') cur = last;
        else{//根据光标位置插入元素
            Next[i] = Next[cur];//插入时元素连接光标元素后的链接
            Next[cur] = i;//光标元素连接插入元素
            if(cur == last) last = i;//正常插入时cur,last相等，插入后右移
            cur = i;//光标右移，更新位置
        }
    }
    for (int i = Next[0]; i != -1; i = Next[i]) printf("%c",s[i]);
        printf("\n");
    }
}