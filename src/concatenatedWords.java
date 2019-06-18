/**
 * Created by Hobbes on 6/23/17.
 */
import java.util.*;
public class concatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        for(String w : words){
            if(w.length() == 0) continue;
            addWord(w);
        }

        dfs(root,0);
        return result;


    }
    private TrieNode root;
    private List<String> result;

    class TrieNode{
        TrieNode[] children;
        String word;
        boolean isEnd;
        boolean combo; //if this word is a combination of simple words
        boolean added; //if this word is already added in result
        public TrieNode() {
            this.children = new TrieNode[26];
            this.word = new String();
            this.isEnd = false;
            this.combo = false;
            this.added = false;
        }
    }

    private void addWord(String str) {
        TrieNode node = root;
        result = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
        node.word = str;
    }

    private void dfs(TrieNode node, int times){
        if(node.isEnd && !node.added && times > 1){
            node.combo=true;
            node.added=true;
            result.add(node.word);
        }
        searchWord(node,root,times);

    }
    private void searchWord(TrieNode node1, TrieNode node2, int times){
        if(node2.combo){
            return;
        }
        if(node2.isEnd){
            dfs(node1, times+1);
        }

        for(int i =0 ; i < 26;i++){
            if(node1.children[i] != null && node2.children[i] != null){
                searchWord(node1.children[i],node2.children[i],times);
            }
        }
    }


    public static void main(String[] args){
        String[] words1 = new String[]{"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        concatenatedWords sol = new concatenatedWords();

        List<String> res = sol.findAllConcatenatedWordsInADict(words1);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }


}
