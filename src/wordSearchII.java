/**
 * Created by Hobbes on 6/18/17.
 */

import java.util.*;
public class wordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        trie t = new trie();
        for(int i = 0; i < words.length; i++){
            t.insert(words[i]);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];


        Set<String> res = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper(res,board, visited, t,i, j, new StringBuilder());
            }
        }
        List<String> r = new LinkedList<>(res);
        return r;
    }


    public void helper(Set<String> res, char[][] board ,boolean[][] visited, trie t,int i, int j, StringBuilder sb){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(visited[i][j]) return;

        sb.append(board[i][j]);

        if(!t.startWith(sb.toString())) return;

        visited[i][j] = true;
        if(t.search(sb.toString())) res.add(sb.toString());

        helper(res,board,visited, t, i+1, j, new StringBuilder(sb.toString()));
        helper(res,board,visited, t, i-1, j, new StringBuilder(sb.toString()));
        helper(res,board,visited, t, i,   j+1, new StringBuilder(sb.toString()));
        helper(res,board,visited, t, i,   j-1, new StringBuilder(sb.toString()));

        visited[i][j] = false;

    }
}
