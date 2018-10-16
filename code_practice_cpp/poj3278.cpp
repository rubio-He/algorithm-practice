/**
 * 
 * Description

Farmer John has been informed of the location of a fugitive cow and wants to catch her immediately. He starts at a point N (0 ≤ N ≤ 100,000) on a number line and the cow is at a point K (0 ≤ K ≤ 100,000) on the same number line. Farmer John has two modes of transportation: walking and teleporting.

* Walking: FJ can move from any point X to the points X - 1 or X + 1 in a single minute
* Teleporting: FJ can move from any point X to the point 2 × X in a single minute.

If the cow, unaware of its pursuit, does not move at all, how long does it take for Farmer John to retrieve it?

Input

Line 1: Two space-separated integers: N and K
Output

Line 1: The least amount of time, in minutes, it takes for Farmer John to catch the fugitive cow.
Sample Input

5 17
Sample Output

4
Hint

The fastest way for Farmer John to reach the fugitive cow is to move along the following path: 5-10-9-18-17, which takes 4 minutes.
 * 
*/

#include<cstdio>
#include<cstring>
int p[1000000];
int q[1000000];
int main(){
    // freopen("input.txt", "r",stdin);
    int n, k;
    scanf("%d%d",&n,&k);
    memset(p, -1,sizeof(p));
    int top = 0;
    int low = 0;
    q[top++] = n;
    p[n] = 0;
    while(low < top){
        int s = q[low++];
        if(s == k){
            break;
        }
        if(s - 1 >= 0 && p[s-1] == -1){
            p[s-1] = p[s] + 1;
            q[top++] = s-1; 
        }
        if(s + 1 < 1000000 && p[s + 1] == -1){
            p[s + 1] = p[s] + 1;
            q[top++] = s+1;
        }
        if(s * 2 <1000000 && p[2 * s] == -1){
            p[2 * s] = p[s] + 1;
            q[top++] =  s * 2;
        }
    }
    printf("%d\n", p[k]);
    return 0;
}
