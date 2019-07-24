/**
 * Created by Hobbes on 6/18/17.
 */


import java.util.*;

public class trie {
    private trieNode root;
    public trie() {
        root = new trieNode();
    }


    public void insert(String word){

        HashMap<Character, trieNode> children = root.children;

        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            trieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }
            else{
                t = new trieNode(c);
                children.put(c,t);
            }
            children  = t.children;


            if(i == word.length() - 1){
                t.isLeaf = true;
            }
        }
    }



    public boolean search(String word){
        trieNode t = searchNode(word);
        if( t != null && t.isLeaf){
            return true;
        }
        else return false;
    }

    public trieNode searchNode(String str){
        Map<Character,trieNode> children = root.children;
        trieNode t = null;
        for(int i = 0; i < str.length();  i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }
            else return null;
        }

        return t;
    }


    public boolean startWith(String prefix){

        if(searchNode(prefix) == null){
            return false;
        }
        else{
            return true;
        }
    }

}

class trieNode {
    private char c;
    HashMap<Character, trieNode> children = new HashMap<>();
    boolean isLeaf;
    public trieNode() {}
    public trieNode(char c){
        this.c  = c;
    }
}