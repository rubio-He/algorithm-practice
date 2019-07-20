import java.util.*;

public class radix_count {
    static int getMax(int arr[], int n){
        int max  = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    static void countSort(int arr[], int n , int exp){
        int res[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for(int num: arr){
            count[(num/exp)%10]++;
        }

        for( i = 1; i < 10; i++)
            count[i] += count[i-1];

        for(i = n - 1; i >= 0; i--){
            res[count[(arr[i]/exp)%10] - 1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(i = 0; i < n; i++){
            arr[i] = res[i];
        }
    }

    static void radixsort(int arr[], int n){
        int m = getMax(arr,n);
        for(int exp = 1; m/exp >0; exp*= 10){
            countSort(arr,n,exp);
        }
    }
}
