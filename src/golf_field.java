import java.util.*;
class golf_field {
    class Tree implements Comparable<Tree>{
        int x,y;
        int h;
        public Tree(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public int compareTo(Tree t2){
            return this.h - t2.h;
        }
    }
    public int cutOffTree(List<List<Integer>> forest) {
        int n = forest.size();
        int m = forest.get(0).size();

        if (forest.get(0).get(0)==0)
            return -1;





        List<Tree> trees = new ArrayList<>();




        for (int i=0; i<n; i++)
            for (int j=0; j<m; j++){
                if (forest.get(i).get(j)>1){
                    trees.add(new Tree(i, j, forest.get(i).get(j)));
                }
            }

        trees.add(new Tree(0,0,1));
        Collections.sort(trees);

        int res = 0;
        for (int i=0; i<trees.size()-1; i++){
            Tree t1 = trees.get(i);
            Tree t2 = trees.get(i+1);
            int tmp = dis(forest, t1, t2, n, m);
            if (tmp!=-1)
                res+=tmp;
            else
                return -1;
        }

        return res;
    }

    private int dis(List<List<Integer>> forest, Tree t1, Tree t2, int n, int m){
        if (t1.x==t2.x && t1.y==t2.y)
            return 0;

        boolean[][] visited = new boolean[n][m];
        LinkedList<Integer> xList = new LinkedList<>();
        LinkedList<Integer> yList = new LinkedList<>();

        int res = 1;
        xList.add(t1.x);
        yList.add(t1.y);
        xList.add(null);
        yList.add(null);
        visited[t1.x][t1.y] = true;

        int[] dx = new int[] {-1,0,1,0};
        int[] dy = new int[] {0,1,0,-1};
        while (xList.size()>0){
            Integer curx = xList.remove();
            Integer cury = yList.remove();
            if (curx==null){
                if (xList.size()==0)
                    return -1;
                res++;
                xList.add(null);
                yList.add(null);
                continue;
            }

            for (int i=0; i<4; i++){
                int x = curx + dx[i];
                int y = cury + dy[i];
                if (x>=0 && x<n && y>=0 && y<m && forest.get(x).get(y)!=0 && !visited[x][y]){
                    if (x==t2.x && y==t2.y)
                        return res;
                    visited[x][y] = true;
                    xList.add(x);
                    yList.add(y);
                }
            }
        }

        return -1;
    }
}