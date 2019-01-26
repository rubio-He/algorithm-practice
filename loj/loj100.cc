#include<cstdio>
const int Mod = 10e9 + 7;
int a[505][505], b[505][505], n, p, m; 
int main() {
	scanf("%d%d%d", &n,&p,&m);
	int i, j;
	for(int i =0; i < n; i++) {
		for(int j = 0; j < p; j++) {
			scanf("%d%d%d", a[i] + j );
		}}
	for(int i = 0; i < p; i++) {
		for(int j =0; j < m; j++) {
			scanf("%d%d%d", b[i] + j);
		}}
	for(int i = 0; i < n; ++i){
		for(int j = 0; j < m; j++ ){
			long long s = 0;
			for(int k = 0; k < p; k++){
				s += (long long)a[i][k] * b[k][j] % Mod;
			}
			printf("%d ", (s%Mod + Mod)%Mod);}
		printf("\n");}
}




