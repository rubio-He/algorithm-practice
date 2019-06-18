import java.util.*;

public class monoStack {
    static int[] rightLargeElement(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res , -1);
        for(int i = 0; i < n; i++){
            while(!stk.isEmpty() && arr[stk.peek()] < arr[i]){
                res[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        for(int i = 0; i < 5; i++)
        System.out.println(rightLargeElement(new int[]{5,3,1,2,4})[i]);
    }
}
