/**
 * Created by Hobbes on 7/21/17.
 */
import java.util.*;
public class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        Set<String> v = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        set.addAll(wordList);
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                Set<String> s = beginSet;
                beginSet = endSet;
                endSet = s;
            }
            Set<String> temp = new HashSet<>();
            for(String s : beginSet){
                char[] word = s.toCharArray();
                for(int i = 0; i < word.length; i++){
                    for(int j = 0; j < 26; j++){
                        char old = word[i];
                        word[i] = (char)('a' + j);
                        String target = String.valueOf(word);
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        if(!v.contains(target) && set.contains(target)){
                            temp.add(target);
                            v.add(target);
                        }
                        word[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }
        return 0;


    }

    public static void main(String[] args){
        String b = "hit";
        String e = "cog";
        List<String> l = new LinkedList<>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("log");
        l.add("lot");
        System.out.print(ladderLength(b,e,l));


    }
}