public class candy_Crush {
        public int[][] candyCrush(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean f = true;
            while(f){
                f = false;
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        int type = Math.abs(board[i][j]);
                        int s = row(board, i ,j, type, m, n);
                        if(s >= 3){
                            f = true;
                            for(int ii = i; ii < s + i; ii++){
                                board[ii][j] = -1 * type;
                            }
                        }

                        s = col(board, i ,j, type, m, n);
                        if(s >= 3){
                            f = true;
                            for(int jj = j; jj < s + j; jj++){
                                board[i][jj] = -1 * type;
                            }
                        }
                    }
                }
                gravityAgent(board);

            }
            return board;

        }

        int row(int[][] board, int i, int j, int type, int m, int n){
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 0 ||  Math.abs(board[i][j]) != type) return 0;
            int size = 1;
            size += row(board, i + 1, j, type, m, n);
            return size;
        }


        int col(int[][] board, int i, int j, int type, int m, int n){
            if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 0 ||  Math.abs(board[i][j]) != type) return 0;
            int size = 1;
            size += col(board, i, j + 1, type, m, n);
            return size;
        }

        void gravityAgent(int[][] board){
            int m = board.length;
            int n = board[0].length;
            for(int j = 0; j < n; j++){
                int index = m - 1;
                for(int i = m - 1; i >= 0; i--){
                    if(board[i][j] > 0) board[index--][j] = board[i][j];
                }
                for(int i = index; i >= 0; i--){
                    board[i][j] = 0;
                }
            }
        }

}
