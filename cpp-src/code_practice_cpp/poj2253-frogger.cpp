#include<cstdio>
#include<cstring>
#include<cmath>

int n;
int q[205],t = 0;
double d[205], w[205][205],c[205][2] ;

double dist(double s1, double s2, double e1, double e2)
{
    return sqrt(pow(s1-e1, 2) + pow(s2-e2,2));
}

void dijk(){
    for(int i = 0; i < n; i++)
    {
        d[i] = w[0][i];
    }
    q[0] = 1;
    for(int i = 0; i < n; i++)
    {
        double min = 0x3f3f3f3f;
        int pos = 1;
        for(int j =1; j < n; j++)
        {
            if(!q[j] && d[j] < min)
            {
                pos = j;
                min = d[j];
            }
        }
        q[pos] = 1; 

        for(int j = 1; j < n; j++)
        {
            double temp = w[pos][j] > d[pos] ? w[pos][j] : d[pos];
            d[j] = d[j] < temp ? d[j] : temp; 
        }
    }

    printf("Scenario #%d\n",++t);
    printf("Frog Distance = %.3f\n\n", d[1]);
}

int main()
{
    freopen("input.txt", "r", stdin);
    while(scanf("%d", &n), n != 0)
    {  
        memset(w, 0, sizeof(w));
        memset(q, 0, sizeof(q));
        for(int i = 0; i < n; i++)
        {
            scanf("%lf%lf", &c[i][0], &c[i][1]);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                w[i][j] = dist(c[i][0], c[i][1], c[j][0], c[j][1]);
            }
        }
        dijk();
    }
    return 0;
}