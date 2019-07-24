#include<cstdio>
#include<cmath>
#include<algorithm>
using namespace std;
int a, b;
int main(){
    freopen("input.txt","r", stdin);
    double p = (1 + sqrt(5)) / 2;
    while(scanf("%d%d", &a, &b) != EOF)
    {
        if(a > b) swap(a,b);
        int k = a / p;
        if((a == (int) (k * p) && b == a + k )|| (a == (int)((k+1) * p)) && b == a + k + 1){
            printf("0\n");
        }
        else{
            printf("1\n");
        }
    }
    return 0;
}