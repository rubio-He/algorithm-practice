public class Reverse_word_in_a_string {
    public class Solution {
        public String reverseWords(String s) {
            if(s.length() == 0) return "";
            char[] arr = s.toCharArray();
            int n = arr.length;
            int i = 0 , pre = 0;
            while( i < n){
                while(i < n && arr[i] == ' ') i++;
                pre = i;
                while(i < n && arr[i] != ' ') i++;
                reverse(arr, pre, i-1);
            }

            StringBuilder sb = new StringBuilder();
            i = n - 1;
            while( i >= 0){
                while(i >= 0 && arr[i] == ' ') i--;
                while(i >= 0 && arr[i] != ' ') sb.append(arr[i--]);
                sb.append(' ');
            }

            return sb.toString().trim();

        }

        void reverse(char[] arr, int i, int j){
            while(i < j){
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
                i++;
                j--;
            }
        }
    }
}
