import java.util.*;
public class wordSquare {
    class node {
        List<String> startWith;
        node[] children;
        public node(){
            startWith = new LinkedList<>();
            children = new node[26];
        }

    }
    class Trie{
        node root;
        public Trie(String[] words){
            root = new node();
            for(String word : words){
                node n = root;
                for(char c : word.toCharArray()){
                    if(n.children[c-'a'] == null){
                        n.children[c-'a'] = new node();
                    }
                    n = n.children[c - 'a'];
                    n.startWith.add(word);
                }
            }
        }
        List<String> findStartWith(String prefix){
            node n = root;
            for(char c : prefix.toCharArray()){
                if(n.children[c-'a'] == null) return null;
                else n = n.children[c-'a'];
            }
            return n.startWith;

        }


    }
    public List<List<String>> wordSquares(String[] words) {
        Trie tr = new Trie(words);
        List<String> temp = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for(String word : words){
            temp.add(word);
            search(tr, temp, res, word.length());
            temp.clear();
        }
        return res;
    }


    void search(Trie tr, List<String> temp, List<List<String>> res, int len ){
        if(temp.size() == len){
            List<String> toadd = new LinkedList<>(temp);
            res.add(toadd);
            return;
        }

        StringBuilder req = new StringBuilder();

        for(int i = 0; i < temp.size(); i++){
            req.append(temp.get(i).charAt(temp.size()));
        }

        List<String> candidate = tr.findStartWith(req.toString());

        if(candidate == null) return;
        for(String word : candidate){
            temp.add(word);
            search(tr, temp, res, len);
            temp.remove(temp.size() - 1);
        }

    }


}
