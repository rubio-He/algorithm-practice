
public class alienDictionary {
    public static String alienOrder(String[] words) {
        boolean[][] adj = new boolean[26][26];
        int[] v = new int[26];
        for(int i = 0; i < words.length; i++){
            for(char c : words[i].toCharArray()) v[c - 'a'] = 1;
            if(i > 0){
                char[] w1 = words[i-1].toCharArray();
                char[] w2 = words[i].toCharArray();
                int min = Math.min(w1.length,w2.length);
                for(int j = 0; j < min; j++){
                    if(w1[j] != w2[j]){
                        adj[w1[j]-'a'][w2[j]-'a'] = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++){
            if(v[i] == 1){
                if(!dfs(v,adj,sb,i)) return "";
            }
        }

        return sb.reverse().toString();
    }

    public static boolean dfs(int[] v, boolean[][] adj, StringBuilder sb, int i){
        v[i] = 2;  // 2 represent visited;
        for(int j = 0; j <26; j++){
            if(adj[i][j]) {
                if (v[j] == 2) return false;
                if (v[j] == 1) {
                    if (!dfs(v, adj, sb, j)) return false;
                }
            }
        }
        v[i] = 3;
        sb.append((char) ( i+'a'));
        return true;
    }


    public static void main(String[] args){
        String[] words = new String[]{"wrt","wrf","er","ett","rftt"};
        alienOrder(words);
    }
}
