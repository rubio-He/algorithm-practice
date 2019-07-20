/**
 * Created by Hobbes on 6/7/17.
 */
public class Binary_Search {
    /*
     * In the array, find the index of the first changes.
     * The algorithm is based on the Binary search, time complexity is O(log n)
     */
     static int getFirstIndexChangedVer1(int[] arr, int i, int j){
        int l = 0;
        int r = arr.length - 1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(arr[m] == i) l =  m + 1;
            else if (arr[m] == j) r = m - 1;
        }
        return l;
    }
    static int getFirstIndexChangedVer2(int[] arr, int i , int j){
         int l = 0;
         int r = arr.length - 1;
         while(l < r){
             int m = l + (r-l)/2;
             if(arr[m] == i) l = m + 1;
             else if(arr[m] == j) r  = m ;
         }
         return l;
    }

    static int getFirstIndexChangedVer3(int[] arr, int i, int j){
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] == i)
                l = m + 1;
            else
                r = m;
        }
        return l;
    }




    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 1, 1, 1, 1, 1, 1};
        int[] arr2 = new int[]{2, 2, 2, 2, 2, 2, 2};
        int[] arr3 = new int[]{1, 1, 2, 2, 2, 2, 2};
        System.out.println(getFirstIndexChangedVer1(arr1, 1, 2));
        System.out.println(getFirstIndexChangedVer1(arr2, 1, 2));
        System.out.println(getFirstIndexChangedVer1(arr3, 1, 2));
        System.out.println(getFirstIndexChangedVer3(arr1, 1, 2));
        System.out.println(getFirstIndexChangedVer3(arr2, 1, 2));
        System.out.println(getFirstIndexChangedVer3(arr3, 1, 2));
    }
}
