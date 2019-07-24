import java.util.*;

public class Shortest_Distance_from_All_Buildings {
        static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
        public static int shortestDistance(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[][] dist = new int[m][n];

            List<Tuple> t = new LinkedList<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1) t.add(new Tuple(i,j,0));
                    grid[i][j] *= -1;
                }
            }


            for(int i = 0; i < t.size(); i++){
                bfs(dist, grid, t.get(i),i, m, n );
            }

            int res = -1;

            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == t.size() && (res < 0 || res > dist[i][j]))
                        res = dist[i][j];
                }
            }
            return res;
        }


        static void bfs(int[][] dist,int[][] grid, Tuple t, int k, int m, int n){
            Queue<Tuple> q = new LinkedList<>();
            q.add(t);
            while(!q.isEmpty()){
                Tuple d = q.poll();
                dist[d.x][d.y] += d.dist;
                for(int i = 0; i <4; i++){
                    int x = d.x + dx[i], y = d.y + dy[i];
                    if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == k) {
                        grid[x][y] = k + 1;
                        q.add(new Tuple(x,y,d.dist +1 ));
                    }
                }
            }
        }
    public static void main(String[] args){
        shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}});
    }


}

class Tuple {
    public int y;
    public int x;
    public int dist;

    public Tuple(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
