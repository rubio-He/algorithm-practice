import java.util.*;
public class wordpatternII {
    public static boolean wordPatternMatch(String pattern, String str) {
        Set<Character> s = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(char c : pattern.toCharArray()) s.add(c);
        return dfs(s,map,str,0,pattern,0,set);

    }

    private static boolean dfs(Set<Character>pfreq, Map<Character,String> map,
                        String str, int is, String p, int ip, Set<String> set){
        if(ip == p.length() && is == str.length()) return true;
        if(ip == p.length() && is < str.length()) return false;
        if(ip < p.length() && is == str.length() ) return false;
        char currp = p.charAt(ip);
        if(map.containsKey(currp)){
            String tmp = map.get(p.charAt(ip));
            int len = tmp.length();
            if(!str.startsWith(tmp,is)) return false;
            return dfs(pfreq,map,str,is+len,p,ip+1,set);
        }
        for(int i = is; i < str.length(); i++){
            String tmp = str.substring(is,i+1);
            if (set.contains(tmp)) {
                continue;
            }
            map.put(currp,tmp);
            set.add(tmp);
            if(map.size() == pfreq.size()){
                if(!exceedTotLength(pfreq,map,p,str)) {
                    map.remove(currp);
                    set.remove(tmp);
                    return false;
                }
            }
            if(dfs(pfreq,map,str,i+1,p,ip+1,set)) return true;
            map.remove(currp);
            set.remove(tmp);
        }
        return false;

    }


    private static boolean exceedTotLength(Set<Character> pfreq,Map<Character,String> map,String p,String str){
        int sum = 0;
        for(char c : p.toCharArray()){
            sum += map.get(c).length();
        }
        return sum <= str.length();
    }

    public static void main(String[] args){
        System.out.print(wordPatternMatch("abba","dogcatcatdog"));
    }
}
