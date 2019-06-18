public class DecodeString {
        public static String decodeString(String s) {
            StringBuilder sb = new StringBuilder();
            helper(sb, s, 1);
            return sb.toString();
        }

        static void helper(StringBuilder sb, String s, int time){
            int n = s.length();
            int left = 0;
            int right = 0;
            int pre = 0;
            int i = 0;
            int amount = 0;
            StringBuilder temp = new StringBuilder();
            while(i < n){
                if(amount == 0 && Character.isDigit(s.charAt(i))){
                    while(i < n && Character.isDigit(s.charAt(i)) ){
                        amount = amount * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    continue;
                }
                else if(s.charAt(i) == '['){
                    left++;
                    if(left == right + 1) pre = i;
                }
                else if(s.charAt(i) == ']'){
                    right++;
                    if(right == left && left != 0){

                        helper(temp,s.substring(pre + 1,i),  amount);
                        amount = 0;
                    }
                }
                else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' && left == right ){

                    while(i < n && s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                        temp.append(s.charAt(i));
                        i++;
                    }

                    continue;
                }
                i++;
            }
            for(int j = 0; j < time; j++){
                sb.append(temp.toString());
            }
        }


        public static void main(String[] args){
            System.out.println(decodeString("3[a2[c]]"));
        }

}
